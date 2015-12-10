package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.objs.AbstractModelObject;
import model.objs.WoodModel;
import extend.IOFile;
import extend.IOFile.ErrorType;

public class WoodFragmentDao extends AbstractFragmentDao {

	@Override
	public List<AbstractModelObject> loadData() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM "
					+ RootDao.TABLE_FOREST);

			List<AbstractModelObject> result = new ArrayList<>();
			WoodModel woodModel = null;
			while (rs.next()) {
				woodModel = new WoodModel(rs.getLong("id"),
						rs.getString("type"), rs.getString("group"),
						rs.getString("name"), rs.getString("unit"),
						rs.getInt("amount"), rs.getDouble("weight"),
						rs.getString("rate"), rs.getBoolean("keep"));
				result.add(woodModel);
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
			StringBuilder sql = new StringBuilder("SELECT * FROM ")
					.append(RootDao.TABLE_FOREST).append("WHERE idDataBreach=")
					.append(breachId);
			ResultSet rs = sta.executeQuery(sql.toString());

			List<AbstractModelObject> result = new ArrayList<>();
			WoodModel woodModel = null;
			while (rs.next()) {
				woodModel = new WoodModel(rs.getLong("id"),
						rs.getString("type"), rs.getString("group"),
						rs.getString("name"), rs.getString("unit"),
						rs.getInt("amount"), rs.getDouble("weight"),
						rs.getString("rate"), rs.getBoolean("keep"));
				result.add(woodModel);
			}
			rs.close();
			sta.close();
			conn.close();

			return null;
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
			WoodModel woodModel = (WoodModel) model;
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			StringBuilder sql = new StringBuilder();

			if (woodModel.getId() == -1) {
				sql.append("INSERT INTO ")
						.append(RootDao.TABLE_FOREST)
						.append("(idDataBreach,type,group,name,unit,amount,weight,rate,keep) VALUES(?,?,?,?,?,?,?,?,?");

				pre = conn.prepareStatement(sql.toString(),
						PreparedStatement.RETURN_GENERATED_KEYS);
				pre.setLong(1, breachId);
				pre.setString(2, woodModel.getType());
				pre.setString(3, woodModel.getGroup());
				pre.setString(4, woodModel.getName());
				pre.setString(5, woodModel.getUnit());
				pre.setInt(6, woodModel.getAmount());
				pre.setDouble(7, woodModel.getWeight());
				pre.setString(8, woodModel.getRate());
				pre.setBoolean(9, woodModel.isKeep());

			} else {
				sql.append("UPDATE ")
						.append(RootDao.TABLE_FOREST)
						.append("SET type=?, group=?, name=?, unit=?, amount=?, weight=?, rate=?, keep=? wHERE id=?");
				pre = conn.prepareStatement(sql.toString());
				pre.setString(1, woodModel.getType());
				pre.setString(2, woodModel.getGroup());
				pre.setString(3, woodModel.getName());
				pre.setString(4, woodModel.getUnit());
				pre.setInt(5, woodModel.getAmount());
				pre.setDouble(6, woodModel.getWeight());
				pre.setString(7, woodModel.getRate());
				pre.setBoolean(8, woodModel.isKeep());
				pre.setLong(9, woodModel.getId());
			}
			result = pre.executeUpdate() > 0;
			if (result) {
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next())
					woodModel.setId(rs.getLong(1));

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
	public boolean updateAllBreachId(List<AbstractModelObject> models,
			long breachId) {
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
			StringBuilder sql = new StringBuilder("UPDATE").append(
					RootDao.TABLE_FOREST).append(
					"SET idDataBreach=? WHERE id=?");

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
			StringBuilder sql = new StringBuilder("DELETE FROM ").append(
					RootDao.TABLE_FOREST).append("WHERE isDataBreach=?");

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

}
