package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.TreeModel;

public class LibDao {

	public static ArrayList<TreeModel> loadLibTrees() {
		try {
			Connection conn = DBConnection.DBConnect();
			System.out.println(conn);
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
	
	public static void main(String[] args) {
		System.out.println(loadLibTrees());
	}

}
