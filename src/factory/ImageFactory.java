package factory;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageFactory {

	public static final String ABOUT_ICON = "/images/about.png";
	public static final String ADVANCED_ICON = "/images/advan.png";
	public static final String BILL_ICON = "/images/bill.png";
	public static final String CALENDAR_ICON = "/images/calendar.png";
	public static final String CANCEL_ICON = "/images/cancel.png";
	public static final String CHART_ICON = "/images/chart.png";
	public static final String CHART_BUTTON_ICON = "/images/chartIcon.png";
	public static final String DELETE_ICON = "/images/delete.png";
	public static final String DOLLA_ICON = "/images/dolla.png";
	public static final String DOLLAR_ICON = "/images/dollar.png";
	public static final String EDIT_ICON = "/images/edit.png";
	public static final String EMPLOYEE_ICON = "/images/employee.png";
	public static final String EXIT_ICON = "/images/exit.png";
	public static final String FIND_ICON = "/images/find.png";
	public static final String HOADON_ICON = "/images/hoadon.png";
	public static final String HOME_ICON = "/images/home.png";
	public static final String ICON = "/images/icon.png";
	public static final String INPUT_ICON = "/images/input.png";
	public static final String KEY_ICON = "/images/key.png";
	public static final String LIST_ICON = "/images/list.png";
	public static final String LOCKED_ICON = "/images/locked.png";
	public static final String LOGOUT_ICON = "/images/logout.png";
	public static final String MANAGER_ICON = "/images/manager.png";
	public static final String NEW_ICON = "/images/new.png";
	public static final String NEW_BILL_ICON = "/images/new_bill.png";
	public static final String OUTPUT_ICON = "/images/output.png";
	public static final String REFRESH_ICON = "/images/refresh.png";
	public static final String REFRESH_BILL_ICON = "/images/refresh_bill.png";
	public static final String REPORT_ICON = "/images/report.png";
	public static final String SAVE_ICON = "/images/save.png";
	public static final String SEARCH_ICON = "/images/search.png";
	public static final String SELLDOWN_ICON = "/images/selldown.png";
	public static final String SELLUP_ICON = "/images/sellup.png";
	public static final String STORE_ICON = "/images/store.png";
	public static final String SYS_ICON = "/images/sys.png";
	public static final String UNLOCK_ICON = "/images/unlock.png";
	public static final String USER_ICON = "/images/user.png";
	public static final String VALID_ICON = "/images/valid.png";
	public static final String WARNING_ICON = "/images/warning.png";
	public static final String SETTINGS_ICON = "/images/settings.png";

	public static final String WAIT_CONNECTION_BACKGROUND = "/images/wait_connection.png";

	public static Icon getIcon(String path) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Icon icon = new ImageIcon(toolkit.getClass().getResource(path));
		return icon;
	}

	public static Image getImage(String path) {
		ImageIcon image = (ImageIcon) getIcon(path);
		return image.getImage();
	}

}
