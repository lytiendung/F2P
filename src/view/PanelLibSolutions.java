package view;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXTable;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.toolbar.WebToolBar;

import controller.LibSolutionsController;

import factory.ButtonFactory;
import factory.CommandFactory;
import factory.ImageFactory;
import model.datatable.SolutionsDataTable;

import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class PanelLibSolutions extends JPanel {
	private static final long serialVersionUID = -2419640083464648171L;
	private JXTable table;

	public PanelLibSolutions(SolutionsDataTable model, LibSolutionsController controller) {
		setBorder(new TitledBorder(null, "Th\u01B0 vi\u1EC7n gi\u1EA3i ph\u00E1p", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JXTable(model);
		table.setSurrendersFocusOnKeystroke(true);
		table.setHorizontalScrollEnabled(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		WebToolBar webToolBar = new WebToolBar();
		webToolBar.setUndecorated(true);
		webToolBar.setShadeWidth(0);
		webToolBar.setSpacing(-2);
		webToolBar.setOrientation(SwingConstants.VERTICAL);
		webToolBar.setFloatable(false);
		add(webToolBar, BorderLayout.EAST);

		JButton btnNewRecord = ButtonFactory.createButtonToolBar("Thêm dòng mới", CommandFactory.ADD_CMD,
				ImageFactory.getIcon(ImageFactory.NEW_ICON), controller, true);
		webToolBar.add(btnNewRecord);

		JButton btnDeleteRecord = ButtonFactory.createButtonToolBar("Xóa dòng đã chọn", CommandFactory.DELETE_CMD,
				ImageFactory.getIcon(ImageFactory.DELETE_ICON), controller, true);
		webToolBar.add(btnDeleteRecord);

		JButton btnRefresh = ButtonFactory.createButtonToolBar("Tải lại dữ liệu", CommandFactory.RELOAD_CMD,
				ImageFactory.getIcon(ImageFactory.REFRESH_ICON), controller, true);
		webToolBar.add(btnRefresh);

	}

	public int[] getSelectedRows() {
		int[] selectedRow = table.getSelectedRows();
		int[] realRow = new int[table.getSelectedRowCount()];
		for (int i = 0; i < realRow.length; i++) {
			realRow[i] = table.convertRowIndexToModel(selectedRow[i]);
		}
		return realRow;
	}

	public static void main(String[] args) {
		JFrame jframe = new JFrame("Thư viện lưu trữ");

		WebLookAndFeel.install();

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

		SolutionsDataTable model = new SolutionsDataTable();
		LibSolutionsController controller = new LibSolutionsController(model);

		jframe.setContentPane(controller.getView());
		jframe.setSize(900, 400);
		jframe.setVisible(true);
	}

}
