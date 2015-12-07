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
import model.objs.AnimalModel;
import model.objs.SolutionModel;
import model.objs.TreeModel;

public class LibDao {

	// TODO tree library
	public static List<AbstractModelObject> loadLibTrees() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM trees");

			List<AbstractModelObject> result = new ArrayList<>();
			TreeModel tree = null;
			while (rs.next()) {
				tree = new TreeModel(rs.getLong("id"), rs.getString("name_vi"), rs.getString("name_en"),
						rs.getString("name_latinh"), rs.getString("last_name"), rs.getString("rare"));
				result.add(tree);
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

	public static boolean clearTableTree() {
		return RootDao.clearTable(RootDao.TABLE_TREES);
	}

	public static boolean deleteRecordTreesTable(long[] ids) {
		return RootDao.deleteRecordInTable(RootDao.TABLE_TREES, ids);
	}

	public static boolean saveOrUpdateTree(TreeModel treeModel) {
		try {
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			boolean result = false;

			if (treeModel.getId() != -1) {
				System.out.println("update obj");
				// update
				pre = conn.prepareStatement(
						"UPDATE trees SET name_vi=?,name_en=?,name_latinh=?,last_name=?,rare=? WHERE id=?");
				pre.setString(1, treeModel.getNameVi());
				pre.setString(2, treeModel.getNameEn());
				pre.setString(3, treeModel.getNameLatinh());
				pre.setString(4, treeModel.getLastname());
				pre.setString(5, treeModel.getRare());
				pre.setLong(6, treeModel.getId());
			} else {
				System.out.println("save obj");
				// save
				pre = conn.prepareStatement(
						"INSERT INTO trees(name_vi,name_en,name_latinh,last_name,rare) VALUES(?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				pre.setString(1, treeModel.getNameVi());
				pre.setString(2, treeModel.getNameEn());
				pre.setString(3, treeModel.getNameLatinh());
				pre.setString(4, treeModel.getLastname());
				pre.setString(5, treeModel.getRare());
			}

			result = pre.executeUpdate() > 0;
			if (result) {
				// update id
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next())
					treeModel.setId(rs.getLong(1));

				rs.close();
			}

			pre.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
			return false;
		}
	}

	// TODO solutions library
	public static List<AbstractModelObject> loadLibSolutions() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM solutions");

			List<AbstractModelObject> result = new ArrayList<>();
			SolutionModel sol = null;
			while (rs.next()) {
				sol = new SolutionModel(rs.getLong("id"), rs.getString("bihavior"), rs.getString("solution"),
						rs.getString("place"));
				result.add(sol);
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

	public static boolean clearTableSolutions() {
		return RootDao.clearTable(RootDao.TABLE_SOLUTIONS);
	}

	public static boolean deleteRecordSolutionsTable(long[] ids) {
		return RootDao.deleteRecordInTable(RootDao.TABLE_SOLUTIONS, ids);
	}

	public static boolean saveOrUpdateSolution(SolutionModel solutionModel) {
		try {
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			boolean result = false;

			if (solutionModel.getId() != -1) {
				System.out.println("update obj");
				// update
				pre = conn.prepareStatement("UPDATE solutions SET bihavior=?,solution=?,place=? WHERE id=?");
				pre.setString(1, solutionModel.getViolation());
				pre.setString(2, solutionModel.getRemedies());
				pre.setString(3, solutionModel.getPlacesBreach());
				pre.setLong(4, solutionModel.getId());
			} else {
				System.out.println("save obj");
				// save
				pre = conn.prepareStatement("INSERT INTO solutions(bihavior, solution, place) VALUES(?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				pre.setString(1, solutionModel.getViolation());
				pre.setString(2, solutionModel.getRemedies());
				pre.setString(3, solutionModel.getPlacesBreach());
			}

			result = pre.executeUpdate() > 0;
			if (result) {
				// update id
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next())
					solutionModel.setId(rs.getLong(1));

				rs.close();
			}

			pre.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
			return false;
		}
	}// TODO animals library

	public static List<AbstractModelObject> loadLibAnimals() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM animals");

			List<AbstractModelObject> result = new ArrayList<>();
			AnimalModel animal = null;
			while (rs.next()) {
				animal = new AnimalModel(rs.getLong("id"), rs.getString("name_vi"), rs.getString("name_en"),
						rs.getString("name_latinh"), rs.getString("last_name"), rs.getString("rare"));
				result.add(animal);
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

	public static boolean clearTableAnimals() {
		return RootDao.clearTable(RootDao.TABLE_ANIMALS);
	}

	public static boolean deleteRecordAnimalsTable(long[] ls) {
		return RootDao.deleteRecordInTable(RootDao.TABLE_TREES, ls);
	}

	public static boolean saveOrUpdateAnimal(AnimalModel ani) {
		try {
			Connection conn = DBConnection.DBConnect();
			PreparedStatement pre = null;
			boolean result = false;

			if (ani.getId() != -1) {
				System.out.println("update obj");
				// update
				pre = conn.prepareStatement(
						"UPDATE trees SET name_vi=?,name_en=?,name_latinh=?,last_name=?,rare=? WHERE id=?");
				pre.setString(1, ani.getNameVi());
				pre.setString(2, ani.getNameEn());
				pre.setString(3, ani.getNameLatinh());
				pre.setString(4, ani.getLastname());
				pre.setString(5, ani.getRare());
				pre.setLong(6, ani.getId());
			} else {
				System.out.println("save obj");
				// save
				pre = conn.prepareStatement(
						"INSERT INTO trees(name_vi,name_en,name_latinh,last_name,rare) VALUES(?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				pre.setString(1, ani.getNameVi());
				pre.setString(2, ani.getNameEn());
				pre.setString(3, ani.getNameLatinh());
				pre.setString(4, ani.getLastname());
				pre.setString(5, ani.getRare());
			}

			result = pre.executeUpdate() > 0;
			if (result) {
				// update id
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next())
					ani.setId(rs.getLong(1));

				rs.close();
			}

			pre.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
			return false;
		}
	}

}
