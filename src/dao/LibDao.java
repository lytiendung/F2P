package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.TreeModel;

public class LibDao {

	public static void main(String[] args) {
		int[] ids = new int[1];
		System.out.println(listToString(ids));
	}

	public static ArrayList<TreeModel> loadLibTrees() {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM trees");

			ArrayList<TreeModel> result = new ArrayList<>();
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

	public static String listToString(int[] list) {
		StringBuilder result = new StringBuilder();
		for (int i : list) {
			result.append(",").append(i);
		}
		result.replace(0, 1, "(").append(")");

		return result.toString();
	}

	public static boolean deleteRecordTreeTable(int[] ids) {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			int del = sta.executeUpdate("DELETE FROM trees WHERE id IN " + listToString(ids));

			sta.close();
			conn.close();

			return (del == ids.length);
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
				// update
				pre = conn.prepareStatement(
						"UPDATE trees SET (name_vi=?,name_en=?,name_latinh=?,last_name=?,rare=?) WHERE id=?");
				pre.setString(1, treeModel.getNameVi());
				pre.setString(2, treeModel.getNameEn());
				pre.setString(3, treeModel.getNameLatinh());
				pre.setString(4, treeModel.getLastname());
				pre.setString(5, treeModel.getRare());
				pre.setLong(6, treeModel.getId());
			} else {
				// save
				pre = conn.prepareStatement(
						"INSERT INTO trees(name_vi,name_en,name_latinh,last_name,rare) VALUES(?,?,?,?,?)");
				pre.setString(1, treeModel.getNameVi());
				pre.setString(2, treeModel.getNameEn());
				pre.setString(3, treeModel.getNameLatinh());
				pre.setString(4, treeModel.getLastname());
				pre.setString(5, treeModel.getRare());
			}

			result = pre.executeUpdate() > 0;

			pre.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
