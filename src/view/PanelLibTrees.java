package view;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.toolbar.WebToolBar;

import controller.libs.AbstractLibController;
import controller.libs.LibTreesController;
import factory.ButtonFactory;
import factory.TableFactory;
import model.datatable.AbstractDataTable;
import model.datatable.TreesDataTable;

public class PanelLibTrees extends AbstractPanelPopup {
	private static final long serialVersionUID = -6367090562412671722L;

	public PanelLibTrees(TreesDataTable model, LibTreesController controller) {
		super(model, controller);
	}

	@Override
	protected void init(AbstractDataTable model, AbstractLibController controller) {
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
