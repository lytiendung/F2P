package factory;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.SwingConstants;

import com.alee.global.StyleConstants;
import com.alee.laf.button.WebButton;
import com.alee.laf.toolbar.WebToolBar;

import controller.LibTreesController;

public class ButtonFactory {

	public static WebButton createButtonToolBar(String toolTipText, String actionCommand, Icon icon,
			ActionListener action, boolean rolloverDecoratedOnly) {
		WebButton webButton = new WebButton("", icon, action);
		webButton.setActionCommand(actionCommand);
		webButton.setToolTipText(toolTipText);
		webButton.setRolloverDecoratedOnly(rolloverDecoratedOnly);
		webButton.setRound(StyleConstants.smallRound);

		return webButton;
	}

	public static WebToolBar createLibWebToolBar(LibTreesController controller) {
		WebToolBar webToolBar = new WebToolBar();
		webToolBar.setUndecorated(true);
		webToolBar.setShadeWidth(0);
		webToolBar.setSpacing(-2);
		webToolBar.setOrientation(SwingConstants.VERTICAL);
		webToolBar.setFloatable(true);

		webToolBar.add(ButtonFactory.createButtonToolBar("Thêm dòng mới", CommandFactory.ADD_CMD,
				ImageFactory.getIcon(ImageFactory.NEW_ICON), controller, true));
		webToolBar.add(ButtonFactory.createButtonToolBar("Xóa dòng đã chọn", CommandFactory.DELETE_CMD,
				ImageFactory.getIcon(ImageFactory.DELETE_ICON), controller, true));
		webToolBar.add(ButtonFactory.createButtonToolBar("Tải lại dữ liệu", CommandFactory.RELOAD_CMD,
				ImageFactory.getIcon(ImageFactory.REFRESH_ICON), controller, true));

		return webToolBar;
	}
}
