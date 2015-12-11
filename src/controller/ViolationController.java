package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import dao.ViolationDao;
import factory.CommandFactory;
import factory.MessageFactory;
import model.main.ViolationCore;
import view.PanelViolation;

public class ViolationController implements ActionListener, FocusListener, IView {
	private PanelViolation view;
	private ViolationCore model;

	public ViolationController(ViolationCore model) {
		this.model = model;
		this.view = new PanelViolation(model, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println("action: " + cmd);
		switch (cmd) {
		case CommandFactory.ADD_CMD:
			if (ViolationDao.isTmpModel()) {
				if (MessageFactory.showQuestionDilog(view,
						"Không thể tạo biên bản mới vì dữ liệu biên bản hiện tại chưa được nhập hoàn tất\r\n- Nhấn \"Làm sạch\" để xóa tất cả dữ liệu hiện có\r\n- Nhấn \"Đóng\" để tiếp tục nhập liệu cho biên bản",
						"Cảnh báo", MessageFactory.WARNING_MESSAGE, MessageFactory.CLEAR_CANCEL_OPTION,
						MessageFactory.CANCEL_OPTION) == MessageFactory.CLEAR_OPTION) {
					model.resetViolation();
					view.updateModelToView();
				}
			} else {
				model.addViolation();
			}
			break;
		case CommandFactory.SAVE_CMD:
			model.saveOrUpdate();
			break;
		case CommandFactory.RESET_CMD:
			if (MessageFactory.showQuestionDilog(view, "Toàn bộ dữ liệu đang nhập trong biên bản hiện tại sẽ bị xóa?",
					"Cảnh báo", MessageFactory.QUESTION_MESSAGE, MessageFactory.OK_CANCEL_OPTION,
					MessageFactory.CANCEL_OPTION) == MessageFactory.OK_OPTION) {
				model.resetViolation();
				view.updateModelToView();
			}
			break;
		case CommandFactory.OWNER_CMD:
			view.updateOwner();
		default:
			autoUpdateModel();
			break;
		}
	}

	private void autoUpdateModel() {
		if (!view.updateViewToModel()) {
			ViolationDao.updateTmpModel();
			System.out.println("update model");
		}
	}

	@Override
	public Container getView() {
		return view;
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		autoUpdateModel();
	}

}
