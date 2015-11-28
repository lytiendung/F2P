package view;

import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.LibSolutionsController;
import controller.LibTreesController;
import controller.LoginController;
import controller.MainController;
import factory.CommandFactory;
import model.LibSolutionsModel;
import model.LibTreesModel;
import model.LoginModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8720432252745326845L;
	private MainController controll;
	private CardLayout cardLayout;
	private JPanel workspaceView;
	private CardLayout workspaceCardLayout;
	private JMenuBar menuBar;

	public MainFrame(MainController controll) {
		this.controll = controll;
		this.cardLayout = new CardLayout(0, 0);

		setTitle("F2P");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(cardLayout);

		initMenuBar();
		initWorkspaceView();
	}

	private void initMenuBar() {
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmTreesLibrary = new JMenuItem("Trees library");
		mntmTreesLibrary.addActionListener(controll);
		mntmTreesLibrary.setActionCommand(CommandFactory.TREE_LIB_CMD);
		mnFile.add(mntmTreesLibrary);

		JMenuItem mntmAnimalsLibrary = new JMenuItem("Animals library");
		mntmAnimalsLibrary.addActionListener(controll);
		mntmAnimalsLibrary.setActionCommand(CommandFactory.ANIMAL_LIB_CMD);
		mnFile.add(mntmAnimalsLibrary);

		JMenuItem mntmSolutionsLibrary = new JMenuItem("Solutions library");
		mntmSolutionsLibrary.addActionListener(controll);
		mntmSolutionsLibrary.setActionCommand(CommandFactory.SOLUTION_LIB_CMD);
		mnFile.add(mntmSolutionsLibrary);
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

		// library soludtion
		LibSolutionsModel libSolModel = new LibSolutionsModel();
		LibSolutionsController libSolutionsController = new LibSolutionsController(libSolModel);
		this.workspaceView.add(libSolutionsController.getView(), CommandFactory.PANEL_LIB_SOLUTION);

		// add workspace view into main view
		getContentPane().add(this.workspaceView, CommandFactory.PANEL_WORKSPACE);
	}

	public void doChangeDisplay(String name) {
		this.cardLayout.show(this.getContentPane(), name);
	}

	public void doShowWorkspace(String name) {
		this.workspaceCardLayout.show(this.workspaceView, name);
	}

	public void doVisibleMenuBar(boolean b) {
		this.menuBar.setVisible(b);
	}

}
