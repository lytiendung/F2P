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
import model.objs.AnimalModel;
import model.objs.SolutionModel;
import model.objs.TreeModel;

public class LibDao {
	private static final String TABLE_TREES = "trees";
	private static final String TABLE_SOLUTIONS = "solutions";
	private static final String TABLE_ANIMALS = "animals";

	// TODO root method
	private static boolean clearTable(String table) {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			sta.executeUpdate("DELETE FROM " + table);

			sta.close();
			conn.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			return false;
		}
	}

	private static boolean deleteRecordInTable(String table, int[] ids) {
		ArrayList<Integer> fillterList = fillterList(ids);
		String whereCond = listToString(fillterList);

		System.out.println("list ids to delete: " + whereCond);

		// case list have id -1
		if (fillterList.isEmpty())
			return true;

		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			StringBuilder sql = new StringBuilder("DELETE FROM ").append(table).append(" WHERE id IN ")
					.append(whereCond);
			int del = sta.executeUpdate(sql.toString());

			sta.close();
			conn.close();

			return (del == fillterList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String listToString(ArrayList<Integer> list) {
		StringBuilder result = new StringBuilder();
		for (Integer i : list) {
			result.append(",").append(i);
		}
		result.replace(0, 1, "(").append(")");

		return result.toString();
	}

	// filter record has id = -1
	private static ArrayList<Integer> fillterList(int[] ids) {
		ArrayList<Integer> fillterList = new ArrayList<>();
		for (int i : ids)
			if (i != -1)
				fillterList.add(i);

		return fillterList;
	}

	// TODO tree library
	public static List<Object> loadLibTrees() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM trees");

			List<Object> result = new ArrayList<>();
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
			e.printStackTrace();
		}

		return null;
	}

	public static boolean clearTableTree() {
		return clearTable(TABLE_TREES);
	}

	public static boolean deleteRecordTreesTable(int[] ids) {
		return deleteRecordInTable(TABLE_TREES, ids);
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
			}

			pre.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// TODO solutions library
	public static List<Object> loadLibSolutions() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM solutions");

			List<Object> result = new ArrayList<>();
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
			e.printStackTrace();
		}

		return null;
	}

	public static boolean clearTableSolutions() {
		return clearTable(TABLE_SOLUTIONS);
	}

	public static boolean deleteRecordSolutionsTable(int[] ids) {
		return deleteRecordInTable(TABLE_SOLUTIONS, ids);
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
			}

			pre.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}// TODO animals library

	public static List<Object> loadLibAnimals() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM animals");

			List<Object> result = new ArrayList<>();
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
			e.printStackTrace();
		}

		return null;
	}

	public static boolean clearTableAnimals() {
		return clearTable(TABLE_ANIMALS);
	}

	public static boolean deleteRecordAnimalsTable(int[] ids) {
		return deleteRecordInTable(TABLE_TREES, ids);
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
			}

			pre.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
