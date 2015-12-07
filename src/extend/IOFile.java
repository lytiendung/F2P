package extend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class IOFile {
	private File errorFile;
	private PrintWriter pw;
	private volatile static IOFile instance;
	private Date date;

	public enum ErrorType {
		DB_ERROR, LAF_ERROR, CONVERT_ERROR
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

}
