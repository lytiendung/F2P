package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.alee.laf.combobox.WebComboBox;

import factory.CommandFactory;
import factory.TableFactory;

public class PairComboboxController implements ActionListener {
	private WebComboBox cbx1;
	private WebComboBox cbx2;

	public PairComboboxController(Object[] cb1, Object[] cb2) {
		this.cbx1 = TableFactory.createPairWebComboBox(cb1);
		this.cbx2 = TableFactory.createPairWebComboBox(cb2);

		doPrepare();
	}

	private void doPrepare() {
		this.cbx1.setActionCommand(CommandFactory.CBX1_CMD);
		this.cbx1.addActionListener(this);
		this.cbx2.setActionCommand(CommandFactory.CBX2_CMD);
		this.cbx2.addActionListener(this);
	}

	public WebComboBox getCbx1() {
		return cbx1;
	}

	public void setCbx1(WebComboBox cbx1) {
		this.cbx1 = cbx1;
	}

	public WebComboBox getCbx2() {
		return cbx2;
	}

	public void setCbx2(WebComboBox cbx2) {
		this.cbx2 = cbx2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case CommandFactory.CBX1_CMD:
			System.out.println("cb1");
			this.cbx2.setSelectedIndex(this.cbx1.getSelectedIndex());
			break;
		case CommandFactory.CBX2_CMD:
			System.out.println("cb2");
//			this.cbx1.setSelectedIndex(this.cbx2.getSelectedIndex());
			break;
		}
	}

}
