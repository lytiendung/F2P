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
import controller.libs.LibSolutionsController;
import factory.ButtonFactory;
import factory.TableFactory;
import model.datatable.AbstractDataTable;
import model.datatable.SolutionsDataTable;

public class PanelLibSolutions extends AbstractPanelPopup {
	private static final long serialVersionUID = 8715262162694432105L;

	public PanelLibSolutions(AbstractDataTable model, AbstractLibController controller) {
		super(model, controller);
	}

	@Override
	protected void init(AbstractDataTable model, AbstractLibController controller) {
		setBorder(new TitledBorder(null, "Th\u01B0 vi\u1EC7n gi\u1EA3i ph\u00E1p", TitledBorder.LEADING,
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
