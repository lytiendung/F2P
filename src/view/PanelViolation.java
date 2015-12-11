package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.alee.extended.date.WebDateField;
import com.alee.laf.button.WebButton;
import com.alee.laf.separator.WebSeparator;
import com.alee.laf.toolbar.ToolbarStyle;
import com.alee.laf.toolbar.WebToolBar;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.ViolationController;
import controller.fragments.AbstractFragmentTableController;
import controller.fragments.ForestFragmentTableController;
import controller.fragments.ForestryOtherFragmentTableController;
import controller.fragments.VehicleFragmentTableController;
import controller.fragments.ViolatorFragmentTableController;
import controller.fragments.WildAnimalFragmentTableController;
import controller.fragments.WoodFragmentTableController;
import dao.RootDao;
import dao.ViolationDao;
import extend.IOFile;
import extend.IOFile.ErrorType;
import factory.ButtonFactory;
import factory.CommandFactory;
import factory.ImageFactory;
import model.datatable.ForestDataTable;
import model.datatable.ForestryOtherDataTable;
import model.datatable.VehicleDataTable;
import model.datatable.ViolatorDataTable;
import model.datatable.WildAnimalDataTable;
import model.datatable.WoodDataTable;
import model.main.ViolationCore;
import model.objs.ViolationModel;

public class PanelViolation extends JPanel {
	private static final long serialVersionUID = -4090572103960843279L;
	private JTextField txtUnit;
	private JCheckBox ckbOwner;
	private JCheckBox ckbHandling;
	private JTextField txtNumberReport;
	private WebDateField dateDayReport;
	private JTextField txtNumberRule;
	private WebDateField dateDayRule;
	private JTextField txtLocaltion;
	private JComboBox<String> cbxMajorPenalty;
	private JComboBox<String> cbxObject;
	private JComboBox<String> cbxHandlingAgency;
	private JFormattedTextField txtFines;
	private JFormattedTextField txtAlreadySumitted;
	private JLabel lblNewLabel;
	private JLabel lblReportState;

	public PanelViolation(ViolationCore model, ViolationController controller) {
		setLayout(new BorderLayout(0, 0));

		JPanel panelViolation = new JPanel();
		panelViolation.setBorder(new TitledBorder(null, "Bi\u00EAn b\u1EA3n vi ph\u1EA1m", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		panelViolation.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), }));

		add(panelViolation, BorderLayout.NORTH);

		JLabel lblTnnV = new JLabel("Tên đơn vị");
		panelViolation.add(lblTnnV, "1, 1");

		txtUnit = new JTextField();
		txtUnit.addActionListener(controller);
		txtUnit.addFocusListener(controller);
		panelViolation.add(txtUnit, "3, 1");

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(0);
		panelViolation.add(panel_2, "5, 1, 5, 1, left, center");

		ckbOwner = new JCheckBox("Có chủ");
		ckbOwner.setActionCommand(CommandFactory.OWNER_CMD);
		ckbOwner.addActionListener(controller);
		panel_2.add(ckbOwner);

		ckbHandling = new JCheckBox("Xử lý hình sự");
		ckbHandling.addActionListener(controller);
		panel_2.add(ckbHandling);

		JLabel lblSBb = new JLabel("Số biên bản");
		panelViolation.add(lblSBb, "1, 3");

		txtNumberReport = new JTextField();
		txtNumberReport.addActionListener(controller);
		txtNumberReport.addFocusListener(controller);
		panelViolation.add(txtNumberReport, "3, 3");

		JLabel lblbbvphc = new JLabel("/BB-VPHC");
		panelViolation.add(lblbbvphc, "5, 3");

		JLabel lblNgyBb = new JLabel("Ngày lập biên bản");
		panelViolation.add(lblNgyBb, "7, 3, right, default");

		dateDayReport = new WebDateField();
		dateDayReport.setDateFormat(RootDao.DATE_FORMAT_USER);
		dateDayReport.addActionListener(controller);
		dateDayReport.addFocusListener(controller);
		panelViolation.add(dateDayReport, "9, 3");

		JLabel lblSQ = new JLabel("Số quyết định");
		panelViolation.add(lblSQ, "1, 5");

		txtNumberRule = new JTextField();
		txtNumberRule.addActionListener(controller);
		txtNumberRule.addFocusListener(controller);
		panelViolation.add(txtNumberRule, "3, 5");

		JLabel lblQ = new JLabel("/QĐ-TTTVPT");
		panelViolation.add(lblQ, "5, 5");

		JLabel lblNgyQ = new JLabel("Ngày quyết định");
		panelViolation.add(lblNgyQ, "7, 5, right, default");

		dateDayRule = new WebDateField();
		dateDayRule.setDateFormat(RootDao.DATE_FORMAT_USER);
		dateDayRule.addActionListener(controller);
		dateDayRule.addFocusListener(controller);
		panelViolation.add(dateDayRule, "9, 5");

		JLabel lblaimVp = new JLabel("Địa điểm VP");
		panelViolation.add(lblaimVp, "1, 7");

		txtLocaltion = new JTextField();
		txtLocaltion.addActionListener(controller);
		txtLocaltion.addFocusListener(controller);
		panelViolation.add(txtLocaltion, "3, 7, 7, 1");

		JLabel lblPhtChnh = new JLabel("Phạt chính");
		panelViolation.add(lblPhtChnh, "1, 9");

		cbxMajorPenalty = new JComboBox<>();
		cbxMajorPenalty.setModel(new DefaultComboBoxModel<>(new String[] { "Phạt tiền", "Cảnh cáo" }));
		panelViolation.add(cbxMajorPenalty, "3, 9, 7, 1");

		JLabel lbltngVp = new JLabel("Đ.tượng VP");
		panelViolation.add(lbltngVp, "1, 11");

		cbxObject = new JComboBox<>();
		cbxObject.setModel(new DefaultComboBoxModel<>(new String[] { "Tổ chức", "Cá nhân" }));
		panelViolation.add(cbxObject, "3, 11, 7, 1");

		JLabel lblCQuanX = new JLabel("Cơ quan xử lý");
		panelViolation.add(lblCQuanX, "1, 13");

		cbxHandlingAgency = new JComboBox<>();
		cbxHandlingAgency.setModel(new DefaultComboBoxModel<String>(new String[] { "Hạt Kiểm lâm", "Đội cơ động",
				"Trạm Kiểm lâm", "Chi cục Kiểm lâm", "UBND Xã", "UBND Huyện", "UBND Tỉnh" }));
		panelViolation.add(cbxHandlingAgency, "3, 13, 7, 1");

		JLabel lblTinPht = new JLabel("Tiền phạt");
		panelViolation.add(lblTinPht, "1, 15");

		JPanel panel_3 = new JPanel();
		panelViolation.add(panel_3, "3, 15, 7, 1, fill, fill");
		panel_3.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"),
				FormSpecs.DEFAULT_COLSPEC, ColumnSpec.decode("9dlu"), ColumnSpec.decode("right:default"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.DEFAULT_ROWSPEC, }));

		txtFines = new JFormattedTextField(NumberFormat.getIntegerInstance());
		txtFines.addActionListener(controller);
		txtFines.addFocusListener(controller);
		panel_3.add(txtFines, "1, 1, fill, default");

		JLabel lblng = new JLabel("(đồng)");
		lblng.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_3.add(lblng, "2, 1");

		JLabel lblNp = new JLabel("Đã nộp");
		panel_3.add(lblNp, "4, 1, right, default");

		txtAlreadySumitted = new JFormattedTextField();
		txtAlreadySumitted.addActionListener(controller);
		txtAlreadySumitted.addFocusListener(controller);
		panel_3.add(txtAlreadySumitted, "6, 1, fill, default");

		JLabel lblng_1 = new JLabel("(đồng)");
		lblng_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_3.add(lblng_1, "7, 1");

		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setOneTouchExpandable(true);
		splitPane.setResizeWeight(0.3);
		add(splitPane, BorderLayout.CENTER);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOneTouchExpandable(true);
		splitPane_1.setResizeWeight(0.5);
		splitPane.setRightComponent(splitPane_1);

		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOneTouchExpandable(true);
		splitPane_3.setResizeWeight(0.5);
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_3);

		// ===========================================
		JPanel panelVehicle = new JPanel();
		panelVehicle.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ph\u01B0\u01A1ng ti\u1EC7n vi ph\u1EA1m",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelVehicle.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollVehicle = new JScrollPane();
		panelVehicle.add(scrollVehicle, BorderLayout.CENTER);

		VehicleDataTable vehicleModel = new VehicleDataTable();
		model.registerObserver(vehicleModel);
		VehicleFragmentTableController vehicleController = new VehicleFragmentTableController(vehicleModel);

		scrollVehicle.setViewportView(vehicleController.getView());
		splitPane_3.setLeftComponent(panelVehicle);
		// ==================================================
		JPanel panelAnimal = new JPanel();
		panelAnimal.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1ED9ng v\u1EADt hoang d\u00E3",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelAnimal.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollAnimal = new JScrollPane();
		panelAnimal.add(scrollAnimal, BorderLayout.CENTER);

		WildAnimalDataTable wildAnimalModel = new WildAnimalDataTable();
		model.registerObserver(wildAnimalModel);
		WildAnimalFragmentTableController wildAnimalController = new WildAnimalFragmentTableController(wildAnimalModel);

		scrollAnimal.setViewportView(wildAnimalController.getView());
		splitPane_3.setRightComponent(panelAnimal);

		// =================================================
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOneTouchExpandable(true);
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setResizeWeight(0.5);
		splitPane_1.setRightComponent(splitPane_4);

		JPanel panelPeople = new JPanel();
		panelPeople.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Ng\u01B0\u1EDDi vi ph\u1EA1m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelPeople.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPeople = new JScrollPane();
		panelPeople.add(scrollPeople, BorderLayout.CENTER);

		ViolatorDataTable violatorModel = new ViolatorDataTable();
		model.registerObserver(violatorModel);
		ViolatorFragmentTableController violatorController = new ViolatorFragmentTableController(violatorModel);

		scrollPeople.setViewportView(violatorController.getView());
		splitPane_4.setLeftComponent(panelPeople);
		// ==================================================
		JPanel panelForestOther = new JPanel();
		panelForestOther.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"L\u00E2m s\u1EA3n kh\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelForestOther.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollForestOther = new JScrollPane();
		panelForestOther.add(scrollForestOther, BorderLayout.CENTER);

		ForestryOtherDataTable forestryModel = new ForestryOtherDataTable();
		model.registerObserver(forestryModel);
		ForestryOtherFragmentTableController forestryCotroller = new ForestryOtherFragmentTableController(
				forestryModel);

		scrollForestOther.setViewportView(forestryCotroller.getView());
		splitPane_4.setRightComponent(panelForestOther);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOneTouchExpandable(true);
		splitPane_2.setResizeWeight(0.5);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_2);

		// ===============Forest panel====================
		JPanel panelForest = new JPanel();
		panelForest.setBorder(new TitledBorder(null, "R\u1EEBng thi\u1EC7t h\u1EA1i", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		panelForest.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollForest = new JScrollPane();
		panelForest.add(scrollForest);

		ForestDataTable forestDataTable = new ForestDataTable();
		model.registerObserver(forestDataTable);
		AbstractFragmentTableController forestController = new ForestFragmentTableController(forestDataTable);

		scrollForest.setViewportView(forestController.getView());
		splitPane_2.setLeftComponent(panelForest);

		// ==============================================
		JPanel panelWood = new JPanel();
		panelWood.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"G\u1ED7 tr\u00F2n - G\u1ED7 x\u1EBB - G\u1ED7 s\u1EA3n ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelWood.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollWood = new JScrollPane();
		panelWood.add(scrollWood, BorderLayout.CENTER);

		WoodDataTable woodModel = new WoodDataTable();
		model.registerObserver(woodModel);
		WoodFragmentTableController woodController = new WoodFragmentTableController(woodModel);

		scrollWood.setViewportView(woodController.getView());
		splitPane_2.setRightComponent(panelWood);

		JPanel panelToolBar = new JPanel();
		add(panelToolBar, BorderLayout.SOUTH);
		panelToolBar.setLayout(new BorderLayout(0, 0));

		WebToolBar webToolBar = new WebToolBar();
		webToolBar.setFloatable(false);
		webToolBar.setToolbarStyle(ToolbarStyle.attached);
		webToolBar.setUndecorated(true);
		panelToolBar.add(webToolBar, BorderLayout.EAST);

		WebButton btnNew = ButtonFactory.createButtonToolBar("Tạo mới", "Tạo biên bản mới", CommandFactory.ADD_CMD,
				ImageFactory.getIcon(ImageFactory.NEW_ICON), controller);
		webToolBar.add(btnNew);

		WebButton btnSave = ButtonFactory.createButtonToolBar("Lưu lại", "Lưu biên bản hiện tại",
				CommandFactory.SAVE_CMD, ImageFactory.getIcon(ImageFactory.SAVE_ICON), controller);
		webToolBar.add(btnSave);

		WebButton btnReset = ButtonFactory.createButtonToolBar("Làm sạch", "Xóa các dữ liệu đã nhập",
				CommandFactory.RESET_CMD, ImageFactory.getIcon(ImageFactory.REFRESH_BILL_ICON), controller);
		webToolBar.add(btnReset);

		JPanel panel_1 = new JPanel();
		panelToolBar.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		lblNewLabel = new JLabel("Tổng số biên bản:");
		panel_1.add(lblNewLabel, "2, 2");

		JLabel lblNumReport = new JLabel("999");
		panel_1.add(lblNumReport, "4, 2");

		WebSeparator webSeparator = new WebSeparator();
		panel_1.add(webSeparator, "6, 2");

		JLabel lblTrngThi = new JLabel("Trạng thái biên bản hiện tại:");
		panel_1.add(lblTrngThi, "8, 2");

		lblReportState = new JLabel("chờ nhập liệu");
		panel_1.add(lblReportState, "10, 2");

		updateModelToView();

		cbxMajorPenalty.addActionListener(controller);
		cbxObject.addActionListener(controller);
		cbxHandlingAgency.addActionListener(controller);
	}

	public void updateModelToView() {
		ViolationModel vio = ViolationDao.getModel();

		this.txtUnit.setText(vio.getUnit());
		this.ckbOwner.setSelected(vio.isOwer());
		this.ckbHandling.setSelected(vio.isHandling());
		this.txtNumberReport.setText(vio.getNumberReport());
		this.dateDayReport.setDate(vio.getDayReport());
		this.txtNumberRule.setText(vio.getNumberRule());
		this.dateDayRule.setDate(vio.getDayRule());
		this.txtLocaltion.setText(vio.getLocation());
		this.cbxMajorPenalty.setSelectedItem(vio.getMajorPenalty());
		this.cbxObject.setSelectedItem(vio.getObject());
		this.cbxHandlingAgency.setSelectedItem(vio.getHandlingAgency());
		this.txtFines.setText(vio.getFines() + "");
		this.txtAlreadySumitted.setText(vio.getAlreadySubmmited() + "");

		boolean hasOwner = vio.isOwer();
		this.txtNumberRule.setEnabled(hasOwner);
		this.dateDayRule.setEnabled(hasOwner);
	}

	public boolean updateViewToModel() {
		ViolationModel vio = ViolationDao.getModel();
		ViolationModel tmpModel = vio.clone();

		vio.setUnit(txtUnit.getText());
		vio.setOwer(ckbOwner.isSelected());
		vio.setHandling(ckbHandling.isSelected());
		vio.setNumberReport(txtNumberReport.getText());
		vio.setDayReport(dateDayReport.getDate());
		vio.setNumberRule(txtNumberRule.getText());
		vio.setDayRule(dateDayRule.getDate());
		vio.setLocation(txtLocaltion.getText());
		vio.setMajorPenalty((String) cbxMajorPenalty.getSelectedItem());
		vio.setObject((String) cbxObject.getSelectedItem());
		vio.setHandlingAgency((String) cbxHandlingAgency.getSelectedItem());
		try {
			vio.setFines(Double.parseDouble(txtFines.getText()));
			vio.setAlreadySubmmited(Double.parseDouble(txtAlreadySumitted.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace(IOFile.getPrintStream(ErrorType.CONVERT_ERROR));
			e.printStackTrace();
		}

		return tmpModel.equals(vio);
	}

	public void updateOwner() {
		boolean hasOwner = ckbOwner.isSelected();
		this.txtNumberRule.setEnabled(hasOwner);
		this.dateDayRule.setEnabled(hasOwner);
	}

}
