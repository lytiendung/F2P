package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import extend.IOFile;
import extend.IOFile.ErrorType;
import model.objs.AbstractModelObject;
import model.objs.ViolatorModel;

public class ViolatorFragmentDao extends AbstractFragmentDao {

	@Override
	public List<AbstractModelObject> loadData() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM " + RootDao.TABLE_VIOLATOR);

			List<AbstractModelObject> result = new ArrayList<>();
			ViolatorModel violatorModel = null;
			while (rs.next()) {
				violatorModel = new ViolatorModel(rs.getLong("id"), rs.getString("fullName"), rs.getString("serial"),
						rs.getDate("birthday"), rs.getString("sex"), rs.getString("nation"),
						rs.getString("cardIdentify"), rs.getString("imageName"), rs.getString("address"),
						rs.getString("numberRule"), rs.getString("numberReport"), rs.getDate("dateRule"),
						rs.getDate("dateReport"), rs.getString("behavior"), rs.getString("penalty"),
						rs.getString("solution"), rs.getDouble("fine"), rs.getDouble("submitted"));
				result.add(violatorModel);
			}

			rs.close();
			sta.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<AbstractModelObject> loadTmpData() {
		return loadDataByBreachId(ViolationDao.DEFAULT_TMP_ID);
	}

	@Override
	public List<AbstractModelObject> loadDataByBreachId(long breachId) {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			StringBuilder sql = new StringBuilder("SELECT * FROM ").append(RootDao.TABLE_VIOLATOR)
					.append(" WHERE idDataBreach=").append(breachId);
			ResultSet rs = sta.executeQuery(sql.toString());

			List<AbstractModelObject> result = new ArrayList<>();
			ViolatorModel violatorModel = null;
			while (rs.next()) {
				violatorModel = new ViolatorModel(rs.getLong("id"), rs.getString("fullName"), rs.getString("serial"),
						rs.getDate("birthday"), rs.getString("sex"), rs.getString("nation"),
						rs.getString("cardIdentify"), rs.getString("imageName"), rs.getString("address"),
						rs.getString("numberRules"), rs.getString("numberReport"), rs.getDate("dateRule"),
						rs.getDate("dateReport"), rs.getString("behavior"), rs.getString("penalty"),
						rs.getString("solution"), rs.getDouble("fine"), rs.getDouble("submitted"));
				result.add(violatorModel);
			}

			rs.close();
			sta.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean saveOrUpdate(AbstractModelObject model, long breachId) {
		boolean result = false;
		try {
			ViolatorModel violatorModel = (ViolatorModel) model;
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			StringBuilder sql = new StringBuilder();

			if (violatorModel.getId() == -1) { // save
				sql.append("INSERT INTO ").append(RootDao.TABLE_VIOLATOR).append(
						"(idDataBreach,fullName,serial,birthday,sex,nation,cardIdentify,imageName,address,numberRules,numberReport,dateRule,dateReport,behavior,penalty,solution,fine,submitted) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				pre = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
				pre.setLong(1, breachId);
				pre.setString(2, violatorModel.getFullName());
				pre.setString(3, violatorModel.getSerial());
				pre.setDate(4, RootDao.formatDateSQL(violatorModel.getBirthday()));
				pre.setString(5, violatorModel.getSex());
				pre.setString(6, violatorModel.getNation());
				pre.setString(7, violatorModel.getCardIdentify());
				pre.setString(8, violatorModel.getImageName());
				pre.setString(9, violatorModel.getAddress());
				pre.setString(10, violatorModel.getNumberRule());
				pre.setString(11, violatorModel.getNumberReport());
				pre.setDate(12, RootDao.formatDateSQL(violatorModel.getDateRule()));
				pre.setDate(13, RootDao.formatDateSQL(violatorModel.getDateReport()));
				pre.setString(14, violatorModel.getBehavior());
				pre.setString(15, violatorModel.getPenalty());
				pre.setString(16, violatorModel.getSolution());
				pre.setDouble(17, violatorModel.getFine());
				pre.setDouble(18, violatorModel.getSubmitted());
			} else { // update
				sql.append("UPDATE ").append(RootDao.TABLE_FOREST).append(
						"SET idDataBreach=?,fullName=?,serial=?,birthday=?,sex=?,nation=?,cardIdentify=?,imageName=?,address=?,numberRules=?,numberReport=?,dateRule=?,dateReport=?,behavior=?,penalty=?,solution=?,fine=?,submitted=? WHERE id=?");

				pre = conn.prepareStatement(sql.toString());
				pre.setLong(1, breachId);
				pre.setString(2, violatorModel.getFullName());
				pre.setString(3, violatorModel.getSerial());
				pre.setDate(4, RootDao.formatDateSQL(violatorModel.getBirthday()));
				pre.setString(5, violatorModel.getSex());
				pre.setString(6, violatorModel.getNation());
				pre.setString(7, violatorModel.getCardIdentify());
				pre.setString(8, violatorModel.getImageName());
				pre.setString(9, violatorModel.getAddress());
				pre.setString(10, violatorModel.getNumberRule());
				pre.setString(11, violatorModel.getNumberReport());
				pre.setDate(12, RootDao.formatDateSQL(violatorModel.getDateRule()));
				pre.setDate(13, RootDao.formatDateSQL(violatorModel.getDateReport()));
				pre.setString(14, violatorModel.getBehavior());
				pre.setString(15, violatorModel.getPenalty());
				pre.setString(16, violatorModel.getSolution());
				pre.setDouble(17, violatorModel.getFine());
				pre.setDouble(18, violatorModel.getSubmitted());
				pre.setLong(19, violatorModel.getId());
			}

			result = pre.executeUpdate() > 0;
			if (result) {
				// update id
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next())
					violatorModel.setId(rs.getLong(1));

				rs.close();
			}

			System.out.println("save or update forest: " + sql.toString());
			pre.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean updateAllBreachId(List<AbstractModelObject> models, long breachId) {
		boolean result = true;

		for (AbstractModelObject model : models) {
			if (!updateBreachId(model, breachId))
				result = false;
		}

		return result;
	}

	@Override
	public boolean updateBreachId(AbstractModelObject model, long breachId) {
		boolean result = false;
		try {
			Connection conn = DBConnection.DBConnect();
			StringBuilder sql = new StringBuilder("UPDATE ").append(RootDao.TABLE_VIOLATOR)
					.append(" SET idDataBreach=? WHERE id=?");

			PreparedStatement pre = conn.prepareStatement(sql.toString());
			pre.setLong(1, breachId);
			pre.setLong(2, model.getId());

			result = pre.executeUpdate() > 0;

			pre.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean deleteRecords(long[] ids) {
		return RootDao.deleteRecordInTable(RootDao.TABLE_FOREST, ids);
	}

	@Override
	public boolean deleteByBreachId(long breachId) {
		boolean result = false;
		try {
			Connection conn = DBConnection.DBConnect();
			StringBuilder sql = new StringBuilder("DELETE FROM ").append(RootDao.TABLE_VIOLATOR)
					.append(" WHERE idDataBreach=?");

			PreparedStatement pre = conn.prepareStatement(sql.toString());
			pre.setLong(1, breachId);

			result = pre.executeUpdate() > 0;

			pre.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean clearTable() {
		return RootDao.clearTable(RootDao.TABLE_FOREST);
	}

	public static void main(String[] args) {
		ViolatorFragmentDao dao = new ViolatorFragmentDao();
		System.out.println("recodes: " + dao.loadData().size());
	}

}
