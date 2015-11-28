package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXTable;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.toolbar.WebToolBar;

import controller.LibTreesController;
import factory.ButtonFactory;
import factory.CommandFactory;
import factory.ImageFactory;
import factory.TableFactory;
import model.datatable.TreesDataTable;

public class PanelLibTrees extends JPanel {

	private static final long serialVersionUID = -2419640083464648171L;
	private JXTable table;
	private JPopupMenu popupMenu;

	public PanelLibTrees(TreesDataTable model, LibTreesController controller) {
		createPopupMenu(controller);
		init(model, controller);
	}

	private void init(TreesDataTable model, LibTreesController controller) {
		setBorder(new TitledBorder(null, "Th\u01B0 vi\u1EC7n th\u1EF1c v\u1EADt", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = TableFactory.createCustomTable(model, controller);
		scrollPane.setViewportView(table);

		WebToolBar webToolBar = ButtonFactory.createLibWebToolBar(controller);
		add(webToolBar, BorderLayout.EAST);
	}

	public int[] getSelectedRows() {
		int[] selectedRow = table.getSelectedRows();
		int[] realRow = new int[table.getSelectedRowCount()];
		for (int i = 0; i < realRow.length; i++) {
			realRow[i] = table.convertRowIndexToModel(selectedRow[i]);
		}
		return realRow;
	}

	private void createPopupMenu(LibTreesController controller) {
		popupMenu = new JPopupMenu();

		JMenuItem mntmThmTiKhon = new JMenuItem("Thêm dòng mới");
		mntmThmTiKhon.setIcon(ImageFactory.getIcon(ImageFactory.NEW_ICON));
		mntmThmTiKhon.setActionCommand(CommandFactory.ADD_CMD);
		mntmThmTiKhon.addActionListener(controller);
		popupMenu.add(mntmThmTiKhon);

		popupMenu.addSeparator();

		JMenuItem mnNotify = new JMenuItem("Xóa dòng đã chọn");
		mnNotify.setIcon(ImageFactory.getIcon(ImageFactory.DELETE_ICON));
		mnNotify.setActionCommand(CommandFactory.DELETE_CMD);
		mnNotify.addActionListener(controller);
		popupMenu.add(mnNotify);

		JMenuItem mnDel = new JMenuItem("Tải lại dữ liệu");
		mnDel.setIcon(ImageFactory.getIcon(ImageFactory.REFRESH_ICON));
		mnDel.setActionCommand(CommandFactory.REFRESH_CMD);
		mnDel.addActionListener(controller);
		popupMenu.add(mnDel);
	}

	public void showPopup(Component component, int x, int y) {
		popupMenu.show(component, x, y);
	}

	public static void main(String[] args) {
		JFrame jframe = new JFrame("Lib trees");

		WebLookAndFeel.install();
		// try {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// } catch (ClassNotFoundException | InstantiationException |
		// IllegalAccessException
		// | UnsupportedLookAndFeelException e) {
		// e.printStackTrace();
		// }

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

		TreesDataTable model = new TreesDataTable();
		LibTreesController controller = new LibTreesController(model);

		jframe.setContentPane(controller.getView());
		jframe.setSize(900, 400);
		jframe.setVisible(true);
	}

}
