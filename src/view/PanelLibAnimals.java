package view;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import com.alee.laf.toolbar.WebToolBar;

import controller.libs.AbstractLibController;
import factory.ButtonFactory;
import factory.CommandFactory;
import factory.ImageFactory;
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

	@Override
	protected void createPopupMenu(AbstractLibController controller) {
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

}
