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
import model.objs.ForestModel;

public class ForestFragmentDao extends AbstractFragmentDao {

	@Override
	public List<AbstractModelObject> loadData() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM " + RootDao.TABLE_FOREST);

			List<AbstractModelObject> result = new ArrayList<>();
			ForestModel forestModel = null;
			while (rs.next()) {
				forestModel = new ForestModel(rs.getLong("id"), rs.getString("kind_CQL"), rs.getString("nameManager"),
						rs.getString("forestType"), rs.getDouble("plantations"), rs.getDouble("naturalForest"));
				result.add(forestModel);
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
			StringBuilder sql = new StringBuilder("SELECT * FROM ").append(RootDao.TABLE_FOREST)
					.append(" WHERE idDataBreach=").append(breachId);
			ResultSet rs = sta.executeQuery(sql.toString());

			List<AbstractModelObject> result = new ArrayList<>();
			ForestModel forestModel = null;
			while (rs.next()) {
				forestModel = new ForestModel(rs.getLong("id"), rs.getString("kind_CQL"), rs.getString("nameManager"),
						rs.getString("forestType"), rs.getDouble("plantations"), rs.getDouble("naturalForest"));
				result.add(forestModel);
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
	public boolean saveOrUpdate(AbstractModelObject model, long idDataBreach) {
		boolean result = false;
		try {
			ForestModel forestModel = (ForestModel) model;
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			StringBuilder sql = new StringBuilder();

			if (forestModel.getId() == -1) { // save
				sql.append("INSERT INTO ").append(RootDao.TABLE_FOREST).append(
						"(idDataBreach,kind_CQL,nameManager,forestType,plantations,naturalForest) VALUES(?,?,?,?,?,?)");

				pre = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
				pre.setLong(1, idDataBreach);
				pre.setString(2, forestModel.getKindCQL());
				pre.setString(3, forestModel.getNameManger());
				pre.setString(4, forestModel.getForestType());
				pre.setDouble(5, forestModel.getPlantation());
				pre.setDouble(6, forestModel.getNaturalForest());
			} else { // update
				sql.append("UPDATE ").append(RootDao.TABLE_FOREST)
						.append("SET kind_CQL=?,nameManager=?,forestType=?,platations=?,naturalForest=? WHERE id=?");

				pre = conn.prepareStatement(sql.toString());
				pre.setString(1, forestModel.getKindCQL());
				pre.setString(2, forestModel.getNameManger());
				pre.setString(3, forestModel.getForestType());
				pre.setDouble(4, forestModel.getPlantation());
				pre.setDouble(5, forestModel.getNaturalForest());
				pre.setLong(6, forestModel.getId());
			}

			result = pre.executeUpdate() > 0;
			if (result) {
				// update id
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next())
					forestModel.setId(rs.getLong(1));

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
			StringBuilder sql = new StringBuilder("UPDATE ").append(RootDao.TABLE_FOREST)
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
	public boolean deleteRecords(long[] ls) {
		return RootDao.deleteRecordInTable(RootDao.TABLE_FOREST, ls);
	}

	@Override
	public boolean deleteByBreachId(long breachId) {
		boolean result = false;
		try {
			Connection conn = DBConnection.DBConnect();
			StringBuilder sql = new StringBuilder("DELETE FROM ").append(RootDao.TABLE_FOREST)
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

}
