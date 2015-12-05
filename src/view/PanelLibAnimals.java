package view;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import com.alee.laf.toolbar.WebToolBar;

import controller.libs.AbstractLibController;
import factory.ButtonFactory;
import factory.TableFactory;
import model.datatable.AbstractDataTable;

public class PanelLibAnimals extends AbstractPanelPopup {
	private static final long serialVersionUID = 3894405356333770233L;

	public PanelLibAnimals(AbstractDataTable model, AbstractLibController controller) {
		super(model, controller);
	}

	@Override
	protected void init(AbstractDataTable model, AbstractLibController controller) {
		setBorder(new TitledBorder(null, "Th\u01B0 vi\u1EC7n \u0111\u1ED9ng v\u1EADt", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = TableFactory.createCustomTable(model, controller);
		scrollPane.setViewportView(table);

		WebToolBar webToolBar = ButtonFactory.createLibWebToolBar(controller);
		add(webToolBar, BorderLayout.EAST);
	}

}
