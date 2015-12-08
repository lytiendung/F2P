package celleditor;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import com.alee.laf.text.WebFormattedTextField;

import factory.MessageFactory;

public class NumberCellEditor extends DefaultCellEditor {
	private static final long serialVersionUID = -2321311338901700832L;
	protected WebFormattedTextField formatedTxt;
	protected Number number;
	protected NumberFormat numberFormat;
	protected NumberFormatter numberFomatter;

	public NumberCellEditor(Number number) {
		super(new WebFormattedTextField());
		this.number = number;
		this.formatedTxt = (WebFormattedTextField) getComponent();
		this.formatedTxt.setDrawBorder(false);
		this.formatedTxt.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				formatedTxt.selectAll();
			}
		});

		numberFormat = (number instanceof Integer) ? NumberFormat.getIntegerInstance()
				: NumberFormat.getNumberInstance();
		numberFomatter = new NumberFormatter(numberFormat);

		if (number instanceof Double) {
			numberFormat.setMaximumFractionDigits(5);
			numberFomatter.setMinimum(new Double(number.doubleValue()));
		} else {
			numberFomatter.setMinimum(new Integer(number.intValue()));
		}

		formatedTxt.setFormatterFactory(new DefaultFormatterFactory(numberFomatter));
		formatedTxt.setValue(number);
		formatedTxt.setHorizontalAlignment(JTextField.TRAILING);
		formatedTxt.setFocusLostBehavior(JFormattedTextField.PERSIST);

		formatedTxt.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "check");
		formatedTxt.getActionMap().put("check", new AbstractAction() {
			private static final long serialVersionUID = -4738286625558229546L;

			public void actionPerformed(ActionEvent e) {
				if (!formatedTxt.isEditValid()) { // The text is invalid.
					if (revert()) { // reverted
						formatedTxt.postActionEvent(); // inform the editor
					}
				} else
					try { // The text is valid,
						formatedTxt.commitEdit(); // so use it.
						formatedTxt.postActionEvent(); // stop editing
					} catch (java.text.ParseException e1) {
						// formatedTxt.setValue(0);
						e1.printStackTrace();
					}
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return super.getTableCellEditorComponent(table, value, isSelected, row, column);
	}

	@Override
	public Object getCellEditorValue() {
		return formatedTxt.getValue();
	}

	@Override
	public boolean stopCellEditing() {
		if (formatedTxt.isEditValid()) {
			try {
				formatedTxt.commitEdit();
			} catch (ParseException exc) {
				exc.printStackTrace();
			}
		} else { // text is invalid
			if (!revert()) { // user wants to edit
				return false; // don't let the editor go away
			}
		}
		super.stopCellEditing();

		return true;
	}

	protected boolean revert() {
		Toolkit.getDefaultToolkit().beep();
		formatedTxt.selectAll();
		int answer = JOptionPane.showOptionDialog(SwingUtilities.getWindowAncestor(formatedTxt),
				"Định dạng số không hợp lệ", "Lỗi nhập dữ liệu", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
				null, MessageFactory.NUMBER_CELL_EDITOR_OPTION, MessageFactory.EDIT_OPTION);

		if (answer == 1) { // revert
			formatedTxt.setValue(formatedTxt.getValue());
			return true;
		}
		return false;
	}

}
