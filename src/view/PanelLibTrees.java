package view;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.JXTable;

import com.alee.laf.WebLookAndFeel;

import controller.LibTreesController;
import model.LibTreesModel;

public class PanelLibTrees extends JPanel {

	private static final long serialVersionUID = -2419640083464648171L;
	private JXTable table;

	public PanelLibTrees(LibTreesModel model, LibTreesController controller) {
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

	}

	public static void main(String[] args) {
		JFrame jframe = new JFrame("Lib trees");

		WebLookAndFeel.install();

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);

		jframe.setContentPane(new PanelLibTrees(new LibTreesModel(), null));
		jframe.setVisible(true);
	}

}
