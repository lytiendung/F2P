package extend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class IOFile {
	// private static final int BUFFER_SIZE = 10240;
	private File errorFile;
	private PrintWriter pw;
	private volatile static IOFile instance;
	private Date date;

	public enum ErrorType {
		DB_ERROR, LAF_ERROR
	};

	private IOFile() {
		date = new Date();
		errorFile = new File("./data/error/error.log");
		if (!errorFile.getParentFile().exists()) {
			errorFile.getParentFile().mkdirs();
		}
		try {
			this.pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(errorFile, true)), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static PrintWriter getPrintStream(ErrorType error) {
		if (instance == null) {
			synchronized (IOFile.class) {
				if (instance == null) {
					instance = new IOFile();
				}
			}
		}
		return instance.getStream(error);
	}

	private PrintWriter getStream(ErrorType error) {
		this.pw.println(new StringBuilder("\r\n######### ").append(error).append(" // ").append(date));
		return this.pw;
	}

	// public static boolean createParentFile(String path) {
	// File file = new File(path);
	// if (!file.getParentFile().exists())
	// return file.getParentFile().mkdirs();
	// return true;
	// }

	// public static void copyFile(InputStream is, OutputStream os) throws
	// IOException {
	// byte[] buffer = new byte[BUFFER_SIZE];
	// int len = 0;
	// while ((len = is.read(buffer)) != -1) {
	// os.write(buffer, 0, len);
	// }
	// is.close();
	// os.close();
	// }

	// public static void createFontFile() throws IOException {
	// createParentFile("./data/fonts/");
	// FileOutputStream fos = new
	// FileOutputStream("./data/fonts/SNAP_ITC_REGULA.TTF");
	// IOFile.copyFile(Toolkit.getDefaultToolkit().getClass().getResourceAsStream("/fonts/SNAP_ITC_REGULA.TTF"),
	// fos);
	// }

	public static void main(String[] args) {
		try {
			Long.parseLong("afdasdf");
		} catch (Exception e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.DB_ERROR));
			System.out.println("done");
		}
	}
}
