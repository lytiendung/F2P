package view.test;

import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import com.alee.laf.WebLookAndFeel;

import controller.ViolationController;
import model.main.ViolationCore;

public class ViolationPanelTest {

	public static void main(String[] args) {
		JFrame jframe = new JFrame("Violation panel");

		WebLookAndFeel.install();

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

		ViolationCore model = new ViolationCore();
		ViolationController controller = new ViolationController(model);

		jframe.setContentPane(controller.getView());
		jframe.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);

		jframe.setVisible(true);
	}
}
