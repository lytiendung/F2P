package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.alee.laf.WebLookAndFeel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.violation.AbstractFragmentTableController;
import controller.violation.ForestTableController;
import model.datatable.ForestDataTable;

public class PanelViolation extends JPanel {
	private static final long serialVersionUID = -4090572103960843279L;
	private JScrollPane scrollPeople;
	private JPanel panelPeople;

	public PanelViolation() {
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

		JTextField textField = new JTextField();
		panelViolation.add(textField, "3, 1");
		textField.setColumns(10);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(0);
		panelViolation.add(panel_2, "5, 1, 5, 1, left, fill");

		JCheckBox chckbxCCh = new JCheckBox("Có chủ");
		panel_2.add(chckbxCCh);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Xử lý hình sự");
		panel_2.add(chckbxNewCheckBox);

		JLabel lblSBb = new JLabel("Số biên bản");
		panelViolation.add(lblSBb, "1, 3");

		JTextField textField_1 = new JTextField();
		panelViolation.add(textField_1, "3, 3");
		textField_1.setColumns(10);

		JLabel lblbbvphc = new JLabel("/BB-VPHC");
		panelViolation.add(lblbbvphc, "5, 3");

		JLabel lblNgyBb = new JLabel("Ngày lập biên bản");
		panelViolation.add(lblNgyBb, "7, 3, right, default");

		JTextField textField_4 = new JTextField();
		panelViolation.add(textField_4, "9, 3");
		textField_4.setColumns(10);

		JLabel lblSQ = new JLabel("Số quyết định");
		panelViolation.add(lblSQ, "1, 5");

		JTextField textField_2 = new JTextField();
		panelViolation.add(textField_2, "3, 5");
		textField_2.setColumns(10);

		JLabel lblQ = new JLabel("/QĐ-TTTVPT");
		panelViolation.add(lblQ, "5, 5");

		JLabel lblNgyQ = new JLabel("Ngày quyết định");
		panelViolation.add(lblNgyQ, "7, 5, right, default");

		JTextField textField_5 = new JTextField();
		panelViolation.add(textField_5, "9, 5");
		textField_5.setColumns(10);

		JLabel lblaimVp = new JLabel("Địa điểm VP");
		panelViolation.add(lblaimVp, "1, 7");

		JTextField textField_3 = new JTextField();
		panelViolation.add(textField_3, "3, 7, 7, 1");
		textField_3.setColumns(10);

		JLabel lblPhtChnh = new JLabel("Phạt chính");
		panelViolation.add(lblPhtChnh, "1, 9");

		JComboBox<String> comboBox_1 = new JComboBox<>();
		panelViolation.add(comboBox_1, "3, 9, 7, 1");

		JLabel lbltngVp = new JLabel("Đ.tượng VP");
		panelViolation.add(lbltngVp, "1, 11");

		JComboBox<String> comboBox = new JComboBox<>();
		panelViolation.add(comboBox, "3, 11, 7, 1");

		JLabel lblCQuanX = new JLabel("Cơ quan xử lý");
		panelViolation.add(lblCQuanX, "1, 13");

		JComboBox<String> comboBox_2 = new JComboBox<>();
		panelViolation.add(comboBox_2, "3, 13, 7, 1");

		JLabel lblTinPht = new JLabel("Tiền phạt");
		panelViolation.add(lblTinPht, "1, 15");

		JPanel panel_3 = new JPanel();
		panelViolation.add(panel_3, "3, 15, 7, 1, fill, fill");
		panel_3.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"),
				FormSpecs.DEFAULT_COLSPEC, ColumnSpec.decode("9dlu"), ColumnSpec.decode("right:default"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.DEFAULT_ROWSPEC, }));

		JTextField textField_10 = new JTextField();
		panel_3.add(textField_10, "1, 1, fill, default");
		textField_10.setColumns(10);

		JLabel lblng = new JLabel("(đồng)");
		lblng.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_3.add(lblng, "2, 1");

		JLabel lblNp = new JLabel("Đã nộp");
		panel_3.add(lblNp, "4, 1, right, default");

		JTextField textField_9 = new JTextField();
		panel_3.add(textField_9, "6, 1, fill, default");
		textField_9.setColumns(10);

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

		JTable tableVehicle = new JTable();
		tableVehicle.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "T\u00EAn ph\u01B0\u01A1ng ti\u1EC7n", "S\u1ED1 l\u01B0\u1EE3ng",
						"Bi\u1EC3n ki\u1EC3m so\u00E1t", "Thu", "Ghi ch\u00FA" }));
		scrollVehicle.setViewportView(tableVehicle);
		splitPane_3.setLeftComponent(panelVehicle);
		// ==================================================
		JPanel panelAnimal = new JPanel();
		panelAnimal.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1ED9ng v\u1EADt hoang d\u00E3",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelAnimal.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollAnimal = new JScrollPane();
		panelAnimal.add(scrollAnimal, BorderLayout.CENTER);

		JTable tableAnimal = new JTable();
		tableAnimal.setModel(new DefaultTableModel(
				new Object[][] { { "", null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "T\u00EAn", "S\u1ED1 l\u01B0\u1EE3ng", "Tr\u1ECDng l\u01B0\u1EE3ng (Kg)", "Hi\u1EBFm",
						"Thu" }));
		scrollAnimal.setViewportView(tableAnimal);
		splitPane_3.setRightComponent(panelAnimal);

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOneTouchExpandable(true);
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setResizeWeight(0.5);
		splitPane_1.setRightComponent(splitPane_4);

		panelPeople = new JPanel();
		panelPeople.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Ng\u01B0\u1EDDi vi ph\u1EA1m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelPeople.setLayout(new BorderLayout(0, 0));

		scrollPeople = new JScrollPane();
		panelPeople.add(scrollPeople, BorderLayout.CENTER);

		JTable tablePeople = new JTable();
		tablePeople.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null }, },
				new String[] { "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh", "D\u00E2n t\u1ED9c",
						"Ch\u1EE9ng minh th\u01B0 | Gi\u1EA5y ph\u00E9p l\u00E1i xe", "H\u00E0nh vi vi ph\u1EA1m",
						"T\u00EAn \u1EA3nh", "S\u1ED1 Q\u0110XP/Q\u0110-XPHC", "S\u1ED1 bi\u00EAn b\u1EA3n" }));
		tablePeople.getColumnModel().getColumn(7).setResizable(false);
		scrollPeople.setViewportView(tablePeople);
		splitPane_4.setLeftComponent(panelPeople);
		// ==================================================
		JPanel panelForestOther = new JPanel();
		panelForestOther.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"L\u00E2m s\u1EA3n kh\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelForestOther.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollForestOther = new JScrollPane();
		panelForestOther.add(scrollForestOther, BorderLayout.CENTER);

		JTable tableForestOther = new JTable();
		tableForestOther.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "T\u00EAn", "\u0110\u01A1n v\u1ECB t\u00EDnh", "S\u1ED1 l\u01B0\u1EE3ng",
						"Tr\u1ECDng l\u01B0\u1EE3ng (Kg)", "Hi\u1EBFm", "Thu" }));
		scrollForestOther.setViewportView(tableForestOther);
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

		ForestDataTable forestDataTable = new ForestDataTable(
				new String[] { "Lo\u1EA1i CQL", "T\u00EAn ch\u1EE7 qu\u1EA3n", "Lo\u1EA1i r\u1EEBng",
						"R\u1EEBng tr\u1ED3ng (m2)", "R\u1EEBng t\u1EF1 nhi\u00EAn (m2)" });
		AbstractFragmentTableController forestController = new ForestTableController(forestDataTable);

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

		JTable tableWood = new JTable();
		tableWood.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, "", null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null }, },
				new String[] { "Lo\u1EA1i", "Nh\u00F3m", "T\u00EAn", "\u0110\u01A1n v\u1ECB t\u00EDnh",
						"S\u1ED1 l\u01B0\u1EE3ng", "Kh\u1ED1i l\u01B0\u1EE3ng (m3)", "Hi\u1EBFm", "Thu" }));
		scrollWood.setViewportView(tableWood);
		splitPane_2.setRightComponent(panelWood);

	}

	public static void main(String[] args) {
		JFrame jframe = new JFrame("Lib trees");

		WebLookAndFeel.install();

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

		jframe.setContentPane(new PanelViolation());
		jframe.setSize(900, 400);
		jframe.setVisible(true);
	}

}
