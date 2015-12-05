package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class Panel001 extends JPanel {
	private static final long serialVersionUID = 3316135450030229753L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_9;
	private JTextField textField_10;

	public Panel001() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow(3)"),},
			new RowSpec[] {
				RowSpec.decode("fill:default"),}));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Bi\u00EAn b\u1EA3n vi ph\u1EA1m", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		add(panel_1, "1, 1, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));

		JLabel lblTnnV = new JLabel("Tên đơn vị");
		panel_1.add(lblTnnV, "1, 1");

		textField = new JTextField();
		panel_1.add(textField, "3, 1");
		textField.setColumns(10);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(0);
		panel_1.add(panel_2, "5, 1, 5, 1, left, fill");

		JCheckBox chckbxCCh = new JCheckBox("Có chủ");
		panel_2.add(chckbxCCh);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Xử lý hình sự");
		panel_2.add(chckbxNewCheckBox);

		JLabel lblSBb = new JLabel("Số biên bản");
		panel_1.add(lblSBb, "1, 3");

		textField_1 = new JTextField();
		panel_1.add(textField_1, "3, 3");
		textField_1.setColumns(10);

		JLabel lblbbvphc = new JLabel("/BB-VPHC");
		panel_1.add(lblbbvphc, "5, 3");

		JLabel lblNgyBb = new JLabel("Ngày lập biên bản");
		panel_1.add(lblNgyBb, "7, 3, right, default");

		textField_4 = new JTextField();
		panel_1.add(textField_4, "9, 3");
		textField_4.setColumns(10);

		JLabel lblSQ = new JLabel("Số quyết định");
		panel_1.add(lblSQ, "1, 5");

		textField_2 = new JTextField();
		panel_1.add(textField_2, "3, 5");
		textField_2.setColumns(10);

		JLabel lblQ = new JLabel("/QĐ-TTTVPT");
		panel_1.add(lblQ, "5, 5");

		JLabel lblNgyQ = new JLabel("Ngày quyết định");
		panel_1.add(lblNgyQ, "7, 5, right, default");

		textField_5 = new JTextField();
		panel_1.add(textField_5, "9, 5");
		textField_5.setColumns(10);

		JLabel lblaimVp = new JLabel("Địa điểm VP");
		panel_1.add(lblaimVp, "1, 7");

		textField_3 = new JTextField();
		panel_1.add(textField_3, "3, 7, 7, 1");
		textField_3.setColumns(10);

		JLabel lblPhtChnh = new JLabel("Phạt chính");
		panel_1.add(lblPhtChnh, "1, 9");

		JComboBox<String> comboBox_1 = new JComboBox<>();
		panel_1.add(comboBox_1, "3, 9, 7, 1");

		JLabel lbltngVp = new JLabel("Đ.tượng VP");
		panel_1.add(lbltngVp, "1, 11");

		JComboBox<String> comboBox = new JComboBox<>();
		panel_1.add(comboBox, "3, 11, 7, 1");

		JLabel lblCQuanX = new JLabel("Cơ quan xử lý");
		panel_1.add(lblCQuanX, "1, 13");

		JComboBox<String> comboBox_2 = new JComboBox<>();
		panel_1.add(comboBox_2, "3, 13, 7, 1");

		JLabel lblTinPht = new JLabel("Tiền phạt");
		panel_1.add(lblTinPht, "1, 15");

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "3, 15, 7, 1, fill, fill");
		panel_3.setLayout(
				new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("9dlu"),
				ColumnSpec.decode("right:default"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));

		textField_10 = new JTextField();
		panel_3.add(textField_10, "1, 1, fill, default");
		textField_10.setColumns(10);

		JLabel lblng = new JLabel("(đồng)");
		lblng.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_3.add(lblng, "2, 1");

		JLabel lblNp = new JLabel("Đã nộp");
		panel_3.add(lblNp, "4, 1, right, default");

		textField_9 = new JTextField();
		panel_3.add(textField_9, "6, 1, fill, default");
		textField_9.setColumns(10);

		JLabel lblng_1 = new JLabel("(đồng)");
		lblng_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_3.add(lblng_1, "7, 1");
	}

}
