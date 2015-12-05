package factory;

import java.awt.Color;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.HighlighterFactory;

import com.alee.laf.combobox.WebComboBox;
import com.alee.laf.text.WebTextField;

import controller.TableHeaderControlPopup;
import controller.libs.AbstractLibController;
import controller.violation.AbstractFragmentTableController;
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

	public static JXTable createCustomTable(AbstractDataTable model, AbstractLibController controller) {
		JXTable table = createCustomTable(model);

		// add mouse listener
		table.addMouseListener(controller);

		return table;

	}

	public static JXTable createCustomTable(AbstractDataTable model, AbstractFragmentTableController controller) {
		JXTable table = createCustomTable(model);

		table.setDefaultEditor(Double.class, new NumberCellEditor(new Double(0)));
		table.setDefaultEditor(Integer.class, new NumberCellEditor(new Integer(0)));

		// add mouse listener
		table.addMouseListener(controller);

		return table;
	}

	private static JXTable createCustomTable(AbstractDataTable model) {
		JXTable table = new JXTable(model);
		table.setSurrendersFocusOnKeystroke(true);
		table.setHorizontalScrollEnabled(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);

		formatHighlighter(table);
		formatHeader(table, SwingConstants.CENTER);

		// cell editor
		WebTextField tmpTextfield = new WebTextField();
		tmpTextfield.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tmpTextfield.selectAll();
			}
		});
		tmpTextfield.setDrawBorder(false);

		DefaultCellEditor txtCellEditor = new DefaultCellEditor(tmpTextfield);
		table.setDefaultEditor(String.class, txtCellEditor);

		return table;
	}

	public static ComboBoxCellEditor createDefaultComboboxCellEditor(Object[] items) {
		WebComboBox cbx = new WebComboBox(items);
		cbx.setDrawBorder(false);

		return new ComboBoxCellEditor(cbx);
	}

}
