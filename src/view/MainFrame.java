package view;

import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.LibTreesController;
import controller.LoginController;
import controller.MainController;
import factory.CommandFactory;
import model.LibTreesModel;
import model.LoginModel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8720432252745326845L;
	private MainController controll;
	private CardLayout cardLayout;
	private JPanel workspaceView;
	private CardLayout workspaceCardLayout;

	public MainFrame(MainController controll) {
		this.controll = controll;
		this.cardLayout = new CardLayout(0, 0);

		setTitle("F2P");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(cardLayout);

		initWorkspaceView();
	}

	private void initWorkspaceView() {
		// login view
		LoginModel loginModel = new LoginModel();
		LoginController loginControll = new LoginController(loginModel);
		getContentPane().add(loginControll.getView(), CommandFactory.PANEL_LOGIN);

		this.workspaceCardLayout = new CardLayout(0, 0);
		this.workspaceView = new JPanel();
		this.workspaceView.setLayout(workspaceCardLayout);

		// library tree
		LibTreesModel libTreesModel = new LibTreesModel();
		LibTreesController libTreesControll = new LibTreesController(libTreesModel);
		this.workspaceView.add(libTreesControll.getView(), CommandFactory.PANEL_LIB_TREE);

		// add workspace view into main view
		getContentPane().add(this.workspaceView, CommandFactory.PANEL_WORKSPACE);
	}

	public void doChangeDisplay(String name) {
		this.cardLayout.show(this.getContentPane(), name);
	}

}
