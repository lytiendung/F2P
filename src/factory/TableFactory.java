package factory;

import java.awt.Color;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.HighlighterFactory;

import com.alee.laf.text.WebTextField;

import controller.LibTreesController;
import controller.TableHeaderControlPopup;
import model.datatable.AbstractDataTable;

public class TableFactory {
	public static void formatHeader(JXTable table, int alignment) {
		if (table != null) {
			if (alignment < 0)
				alignment = 0;
			TableCellRenderer myRenderer = table.getTableHeader().getDefaultRenderer();
			JLabel label = (JLabel) myRenderer;
			label.setHorizontalAlignment(alignment);

			table.getTableHeader().setBackground(SystemColor.activeCaption);
			table.getTableHeader().addMouseListener(new TableHeaderControlPopup(table));
		}
	}

	public static void formatHighlighter(final JXTable table) {
		formatHighlighter(table, null);
	}

	public static void formatHighlighter(final JXTable table, Color color) {
		if (table != null) {
			if (color == null)
				color = Color.blue;
			table.setHighlighters(HighlighterFactory.createAlternateStriping(),
					HighlighterFactory.createComputedForegroundHighlighter(),
					HighlighterFactory.createSimpleStriping());

			table.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW, null, color));

			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					if (table.isEnabled() && e.isPopupTrigger()) {
						Point p = e.getPoint();
						int rowNumber = table.rowAtPoint(p);
						if (rowNumber != -1 && !table.isRowSelected(rowNumber))
							table.setRowSelectionInterval(rowNumber, rowNumber);
					}
				}
			});
		}
	}

	public static JXTable createCustomTable(AbstractDataTable model, LibTreesController controller) {
		JXTable table = new JXTable(model);
		table.setSurrendersFocusOnKeystroke(true);
		table.setHorizontalScrollEnabled(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);

		formatHighlighter(table);
		formatHeader(table, SwingConstants.CENTER);

		// add mouse listener
		table.addMouseListener(controller);

		// cell editor
		WebTextField tmpTextfield = new WebTextField();
		tmpTextfield.setDrawBorder(false);

		DefaultCellEditor cellEditor = new DefaultCellEditor(tmpTextfield);
		table.setDefaultEditor(String.class, cellEditor);

		return table;
	}
}
