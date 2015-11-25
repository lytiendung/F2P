package factory;

import java.awt.event.ActionListener;

import javax.swing.Icon;

import com.alee.global.StyleConstants;
import com.alee.laf.button.WebButton;

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
}
