package view;

import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.LoginController;
import controller.MainController;
import controller.libs.LibAnimalsController;
import controller.libs.LibSolutionsController;
import controller.libs.LibTreesController;
import factory.CommandFactory;
import model.datatable.AnimalsDataTable;
import model.datatable.SolutionsDataTable;
import model.datatable.TreesDataTable;
import model.objs.LoginModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

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

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		// TODO test panels
		JMenu mnTest = new JMenu("Test");
		mnFile.add(mnTest);

		JMenuItem mntmPanel = new JMenuItem("Panel001");
		mntmPanel.setActionCommand("panel1");
		mnTest.add(mntmPanel);

		JMenuItem mntmPanel_1 = new JMenuItem("Panel002");
		mntmPanel_1.setActionCommand("panel2");
		mnTest.add(mntmPanel_1);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				switch (cmd) {
				case "panel1":
					doShowWorkspace("panel1");
					break;
				case "panel2":
					doShowWorkspace("panel2");
					break;
				}
			}
		};

		mntmPanel.addActionListener(action);
		mntmPanel_1.addActionListener(action);
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
		TreesDataTable libTreesModel = new TreesDataTable();
		LibTreesController libTreesControll = new LibTreesController(libTreesModel);
		this.workspaceView.add(libTreesControll.getView(), CommandFactory.PANEL_LIB_TREE);

		// library animal
		AnimalsDataTable libAnimalModel = new AnimalsDataTable();
		LibAnimalsController libAnimalsController = new LibAnimalsController(libAnimalModel);
		this.workspaceView.add(libAnimalsController.getView(), CommandFactory.PANEL_LIB_ANIMAL);
		
		// library solution
		SolutionsDataTable libSolModel = new SolutionsDataTable();
		LibSolutionsController libSolutionsController = new LibSolutionsController(libSolModel);
		this.workspaceView.add(libSolutionsController.getView(), CommandFactory.PANEL_LIB_SOLUTION);

		// test panels
		Panel001 panel1 = new Panel001();
		this.workspaceView.add(panel1, "panel1");

		Panel002 panel2 = new Panel002();
		this.workspaceView.add(panel2, "panel2");

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
