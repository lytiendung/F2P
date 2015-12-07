package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import extend.IOFile;
import extend.IOFile.ErrorType;
import model.objs.ViolationModel;

public class ViolationDao {
	private static final long DEFAULT_TMP_ID = 1;
	private static ViolationModel model;
	private static boolean tmpModel;

	public static ViolationModel getModel() {
		if (model == null)
			loadTmpModel();

		return model;
	}

	private static void loadTmpModel() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			StringBuilder sql = new StringBuilder("SELECT * FROM ").append(RootDao.TABLE_BREACH).append(" WHERE id=")
					.append(DEFAULT_TMP_ID);

			ResultSet rs = sta.executeQuery(sql.toString());
			if (rs.next()) {
				model = new ViolationModel();
				model.setId(rs.getLong("id"));
				model.setUnit(rs.getString("unit"));
				model.setOwer(rs.getBoolean("owner"));
				model.setHandling(rs.getBoolean("handling"));
				model.setNumberReport(rs.getString("numberReport"));
				model.setDayReport(rs.getDate("dayReport"));
				model.setNumberRule(rs.getString("numberRule"));
				model.setDayRule(rs.getDate("dayRule"));
				model.setLocation(rs.getString("locations"));
				model.setObject(rs.getString("objects"));
				model.setMajorPenalty(rs.getString("majorPenalty"));
				model.setHandlingAgency(rs.getString("handlingAgency"));
				model.setFines(rs.getDouble("fines"));
				model.setAlreadySubmmited(rs.getDouble("alreadySubmitted"));
			} else {
				model = new ViolationModel();
				preSave();
			}

			tmpModel = true;
			rs.close();
			sta.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}
	}

	// use after save instance into database
	public static boolean clearTmpModel() {
		model = new ViolationModel();
		model.setId(DEFAULT_TMP_ID);
		tmpModel = true;
		return updateTmpModel();
	}

	public static boolean updateTmpModel() {
		return saveOrUpdate(getModel());
	}

	public static boolean saveOrUpdate(ViolationModel model) {
		boolean result = false;
		try {
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			StringBuilder sql = new StringBuilder();

			if (model.getId() == -1) { // save
				sql.append("INSERT INTO ").append(RootDao.TABLE_BREACH).append(
						"(unit,owner,handling,numberReport,dayReport,numberRule,dayRule,locations,objects,majorPenalty,handlingAgency,fines,alreadySubmitted) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");

				pre = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
				pre.setString(1, model.getUnit());
				pre.setBoolean(2, model.isOwer());
				pre.setBoolean(3, model.isHandling());
				pre.setString(4, model.getNumberReport());
				pre.setDate(5, RootDao.formatDateSQL(model.getDayReport()));
				pre.setString(6, model.getNumberRule());
				pre.setDate(7, RootDao.formatDateSQL(model.getDayRule()));
				pre.setString(8, model.getLocation());
				pre.setString(9, model.getObject());
				pre.setString(10, model.getMajorPenalty());
				pre.setString(11, model.getHandlingAgency());
				pre.setDouble(12, model.getFines());
				pre.setDouble(13, model.getAlreadySubmmited());
			} else { // update
				sql.append("UPDATE ").append(RootDao.TABLE_BREACH).append(
						" SET unit=?,owner=?,handling=?,numberReport=?,dayReport=?,numberRule=?,dayRule=?,locations=?,objects=?,majorPenalty=?,handlingAgency=?,fines=?,alreadySubmitted=? WHERE id=?");

				pre = conn.prepareStatement(sql.toString());
				pre.setString(1, model.getUnit());
				pre.setBoolean(2, model.isOwer());
				pre.setBoolean(3, model.isHandling());
				pre.setString(4, model.getNumberReport());
				pre.setDate(5, RootDao.formatDateSQL(model.getDayReport()));
				pre.setString(6, model.getNumberRule());
				pre.setDate(7, RootDao.formatDateSQL(model.getDayRule()));
				pre.setString(8, model.getLocation());
				pre.setString(9, model.getObject());
				pre.setString(10, model.getMajorPenalty());
				pre.setString(11, model.getHandlingAgency());
				pre.setDouble(12, model.getFines());
				pre.setDouble(13, model.getAlreadySubmmited());
				pre.setLong(14, model.getId());
			}

			result = pre.executeUpdate() > 0;
			if (result) {
				// update id
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next())
					model.setId(rs.getLong(1));

				rs.close();
			}
			pre.close();
			conn.close();

			System.out.println("save or update: " + sql);
		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}

		return result;
	}

	private static boolean preSave() {
		boolean result = false;
		try {
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO ").append(RootDao.TABLE_BREACH)
					.append("(id,unit,owner,handling,numberReport,dayReport,numberRule,dayRule,locations,objects,majorPenalty,handlingAgency,fines,alreadySubmitted) VALUES(")
					.append(DEFAULT_TMP_ID).append(",?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pre = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setString(1, model.getUnit());
			pre.setBoolean(2, model.isOwer());
			pre.setBoolean(3, model.isHandling());
			pre.setString(4, model.getNumberReport());
			pre.setDate(5, RootDao.formatDateSQL(model.getDayReport()));
			pre.setString(6, model.getNumberRule());
			pre.setDate(7, RootDao.formatDateSQL(model.getDayRule()));
			pre.setString(8, model.getLocation());
			pre.setString(9, model.getObject());
			pre.setString(10, model.getMajorPenalty());
			pre.setString(11, model.getHandlingAgency());
			pre.setDouble(12, model.getFines());
			pre.setDouble(13, model.getAlreadySubmmited());

			result = pre.executeUpdate() > 0;
			if (result)
				model.setId(0);

			System.out.println("pre save: " + sql);
		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}

		return result;
	}

	public static boolean delete(long id) {
		return RootDao.deleteRecordInTable(RootDao.TABLE_BREACH, id);
	}

	public static boolean isTmpModel() {
		return tmpModel;
	}

}
