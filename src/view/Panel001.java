package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class Panel001 extends JPanel {
	private static final long serialVersionUID = 3316135450030229753L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public Panel001() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblTnnV = new JLabel("Tên đơn vị");
		add(lblTnnV, "2, 2, right, default");

		textField = new JTextField();
		add(textField, "4, 2, fill, default");
		textField.setColumns(10);

		JCheckBox chckbxCCh = new JCheckBox("Có chủ");
		add(chckbxCCh, "6, 2");

		JCheckBox chckbxNewCheckBox = new JCheckBox("Xử lý hình sự");
		add(chckbxNewCheckBox, "8, 2");

		JLabel lblSBb = new JLabel("Số BB");
		add(lblSBb, "2, 4, right, default");

		textField_1 = new JTextField();
		add(textField_1, "4, 4, fill, default");
		textField_1.setColumns(10);

		JLabel lblbbvphc = new JLabel("/BB-VPHC");
		add(lblbbvphc, "6, 4");
		
		JLabel lblNgyBb = new JLabel("Ngày BB");
		add(lblNgyBb, "8, 4, right, default");
		
		textField_4 = new JTextField();
		add(textField_4, "10, 4, fill, default");
		textField_4.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thi\u1EC7t h\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		add(panel, "12, 3, 1, 6, fill, bottom");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblRngTrng = new JLabel("Rừng trồng");
		panel.add(lblRngTrng, "2, 2, right, default");
		
		textField_6 = new JTextField();
		panel.add(textField_6, "4, 2, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblHa = new JLabel("ha");
		panel.add(lblHa, "6, 2");
		
		JLabel lblRngTNhin = new JLabel("Rừng tự nhiên");
		panel.add(lblRngTNhin, "2, 4, right, default");
		
		textField_7 = new JTextField();
		panel.add(textField_7, "4, 4, fill, default");
		textField_7.setColumns(10);
		
		JLabel lblHa_1 = new JLabel("ha");
		panel.add(lblHa_1, "6, 4");
		
		JLabel lbltLn = new JLabel("Đất LN");
		panel.add(lbltLn, "2, 6, right, default");
		
		textField_8 = new JTextField();
		panel.add(textField_8, "4, 6, fill, default");
		textField_8.setColumns(10);
		
		JLabel lblHa_2 = new JLabel("ha");
		panel.add(lblHa_2, "6, 6");

		JLabel lblSQ = new JLabel("Số QĐ");
		add(lblSQ, "2, 6, right, default");

		textField_2 = new JTextField();
		add(textField_2, "4, 6, fill, default");
		textField_2.setColumns(10);

		JLabel lblQ = new JLabel("/QĐ-TTTVPT");
		add(lblQ, "6, 6");
		
		JLabel lblNgyQ = new JLabel("Ngày QĐ");
		add(lblNgyQ, "8, 6, right, default");
		
		textField_5 = new JTextField();
		add(textField_5, "10, 6, fill, default");
		textField_5.setColumns(10);

		JLabel lblaimVp = new JLabel("Địa điểm VP");
		add(lblaimVp, "2, 8, right, default");

		textField_3 = new JTextField();
		add(textField_3, "4, 8, 7, 1, fill, default");
		textField_3.setColumns(10);
		
		JLabel lbltngVp = new JLabel("Đ.tượng VP");
		add(lbltngVp, "2, 10, right, default");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "4, 10, fill, default");
		
		JLabel lblPhtChnh = new JLabel("Phạt chính");
		add(lblPhtChnh, "6, 10, right, default");
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "8, 10, fill, default");
		
		JLabel lblCQuanX = new JLabel("Cơ quan xử lý");
		add(lblCQuanX, "10, 10, right, default");
		
		JComboBox comboBox_2 = new JComboBox();
		add(comboBox_2, "12, 10, fill, default");
		
		JLabel lblTinPht = new JLabel("Tiền phạt");
		add(lblTinPht, "2, 12");
		
		JLabel lblNp = new JLabel("Đã nộp");
		add(lblNp, "2, 14");
	}

}
