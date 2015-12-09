package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import extend.IOFile;
import extend.IOFile.ErrorType;

public class RootDao {
	protected static final String TABLE_TREES = "trees";
	protected static final String TABLE_SOLUTIONS = "solutions";
	protected static final String TABLE_ANIMALS = "animals";
	protected static final String TABLE_FOREST = "damages";
	protected static final String TABLE_BREACH = "databreach";
	protected static final String TABLE_FORESTRY_OTHER = "foresttryothers";
	protected static final String TABLE_VEHICLE = "vehicles";
	protected static final String TABLE_VIOLATOR = "violator";
	protected static final String TABLE_WILD_ANIMAL = "wildanimals";
	protected static final String TABLE_WOOD = "wood";
	protected static final DateFormat DATE_FORMAT_SQL = new SimpleDateFormat("MM/dd/yyyy");
	public static final SimpleDateFormat DATE_FORMAT_USER = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat DATE_FORMAT_YEAR_ONLY = new SimpleDateFormat("yyyy");
	protected static java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

	// TODO root method
	protected static boolean clearTable(String table) {
		try {
			Connection conn = DBConnection.DBConnect();
			Statement sta = conn.createStatement();
			sta.executeUpdate("DELETE FROM " + table);

			sta.close();
			conn.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
			return false;
		}
	}

	protected static boolean deleteRecordInTable(String table, long... ls) {
		if (ls.length == 0)
			return true;

		ArrayList<Long> fillterList = fillterList(ls);
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
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			e.printStackTrace();
			return false;
		}
	}

	protected static String listToString(ArrayList<Long> fillterList) {
		StringBuilder result = new StringBuilder();
		for (Long i : fillterList) {
			result.append(",").append(i);
		}
		result.replace(0, 1, "(").append(")");

		return result.toString();
	}

	// filter record has id = -1
	protected static ArrayList<Long> fillterList(long[] ls) {
		ArrayList<Long> fillterList = new ArrayList<>();
		for (long i : ls)
			if (i != -1)
				fillterList.add(i);

		return fillterList;
	}

	protected static java.sql.Date formatDateSQL(Date d) {
		RootDao.date.setTime(d.getTime());
		return RootDao.date;
	}

}
