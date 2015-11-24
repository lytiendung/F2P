package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.ucanaccess.jdbc.UcanaccessSQLException;

public class DBConnection {
	private static DBConnection install = null;
	// the name of file at user side
	private String path = System.getProperty("user.dir") + "\\db\\pc.accdb";

	protected DBConnection() {
	}

	public static DBConnection getInstall() {
		if (install == null) {
			install = new DBConnection();
		}
		return install;
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			initDBFile(); // catch file not found exception
			conn = DriverManager.getConnection("jdbc:ucanaccess://" + path);
		} catch (UcanaccessSQLException e) {
			System.out.println("catch IOException: Empty database file!");
			e.printStackTrace();
		}
		return conn;
	}

	private void initDBFile() {
		File file = new File(path);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			// create new ms access file from source
			initSourceFile(file);
		}
	}

	private void initSourceFile(File f) {
		try {
			BufferedInputStream bis = new BufferedInputStream(
					DBConnection.class.getResourceAsStream("/resources/f2p_v1.accdb"));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));

			byte[] buff = new byte[10240];
			int len = 0;

			while ((len = bis.read(buff)) != -1) {
				bos.write(buff, 0, len);
			}

			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
			// error install write log file to fix
		}
	}

	public static Connection DBConnect() throws SQLException {
		return getInstall().getConnection();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			DBConnection.DBConnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
