package factory;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MessageFactory {

	public static final String[] OK_OPTIONS = { "Đóng" };
	public static final String[] OK_CANCEL_OPTION = { "Đồng ý", "Hủy bỏ" };
	public static final String[] CLEAR_CANCEL_OPTION = { "Làm sạch", "Đóng" };
	public static final String[] NUMBER_CELL_EDITOR_OPTION = { "Sửa lại", "Hoàn tác" };

	public static final int OK_OPTION = 0;
	public static final int CANCEL_OPTION = 1;
	public static final int EDIT_OPTION = 0;
	public static final int REVERT_OPTION = 1;
	public static final int CLEAR_OPTION = 0;

	public static final int ERROR_MESSAGE = 0;
	public static final int INFORMATION_MESSAGE = 1;
	public static final int WARNING_MESSAGE = 2;
	public static final int QUESTION_MESSAGE = 3;
	public static final int PLAIN_MESSAGE = -1;

	public static Component windowForComponent(Component c) {
		return SwingUtilities.windowForComponent(c);
	}

	public static int showMessageDialog(Component parentComponent, Object messenger, String title, int messageType) {
		return JOptionPane.showOptionDialog(parentComponent, messenger, title, JOptionPane.CLOSED_OPTION, messageType,
				null, OK_OPTIONS, OK_OPTION);
	}

	public static int showQuestionDialog(Component parentComponent, Object messenger, String title, int messegeType) {
		return showQuestionDilog(parentComponent, messenger, title, messegeType, 1);
	}

	public static int showQuestionDilog(Component parentComponent, Object messenger, String title, int messegeType,
			int initialValue) {
		return JOptionPane.showOptionDialog(parentComponent, messenger, title, JOptionPane.YES_NO_OPTION, messegeType,
				null, OK_CANCEL_OPTION, OK_CANCEL_OPTION[initialValue]);
	}

	public static int showQuestionDilog(Component parentComponent, Object messenger, String title, int messegeType,
			String[] options, int initialValue) {
		return JOptionPane.showOptionDialog(parentComponent, messenger, title, JOptionPane.YES_NO_OPTION, messegeType,
				null, options, options[initialValue]);
	}

	public static void main(String[] args) {
		MessageFactory.showQuestionDialog(null,
				"Tất cả dữ liệu đã nhập hiện tại sẽ bị mất\nBạn có muốn làm mới danh sách dữ liệu?", "Xác nhận",
				MessageFactory.QUESTION_MESSAGE);
	}
}
