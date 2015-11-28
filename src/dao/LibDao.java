package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SolutionModel;
import model.TreeModel;

public class LibDao {

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
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			sta.executeUpdate("DELETE FROM trees");

			sta.close();
			conn.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			// write to log
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

	private static ArrayList<Integer> fillterList(int[] ids) {
		ArrayList<Integer> fillterList = new ArrayList<>();
		for (int i : ids)
			if (i != -1)
				fillterList.add(i);

		return fillterList;
	}

	public static boolean deleteRecordTreeTable(int[] ids) {
		ArrayList<Integer> fillterList = fillterList(ids);
		String whereCond = listToString(fillterList);

		System.out.println("list ids to delete: " + whereCond);

		// case list have id -1
		if (fillterList.isEmpty())
			return true;

		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			int del = sta.executeUpdate("DELETE FROM trees WHERE id IN " + whereCond);

			sta.close();
			conn.close();

			return (del == fillterList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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

	// TODO solutions
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

}
