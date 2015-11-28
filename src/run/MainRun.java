package run;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.alee.laf.WebLookAndFeel;

import controller.MainController;
import extend.IOFile;
import extend.IOFile.ErrorType;

public class MainRun {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new WebLookAndFeel());
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					new MainController();
				}
			});
		} catch (Exception e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.LAF_ERROR));
		}
	}
}
