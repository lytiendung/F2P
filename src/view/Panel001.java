package view;

import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;

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
	private JTextField textField_9;
	private JTextField textField_10;

	public Panel001() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow(3)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),}));

		JPanel panel_1 = new JPanel();
		add(panel_1, "2, 2, fill, fill");
		panel_1.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, }));

		JLabel lblTnnV = new JLabel("Tên đơn vị");
		panel_1.add(lblTnnV, "2, 2");

		textField = new JTextField();
		panel_1.add(textField, "4, 2");
		textField.setColumns(10);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		panel_1.add(panel_2, "6, 2, 5, 1, left, fill");

		JCheckBox chckbxCCh = new JCheckBox("Có chủ");
		panel_2.add(chckbxCCh);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Xử lý hình sự");
		panel_2.add(chckbxNewCheckBox);

		JLabel lblSBb = new JLabel("Số biên bản");
		panel_1.add(lblSBb, "2, 4");

		textField_1 = new JTextField();
		panel_1.add(textField_1, "4, 4");
		textField_1.setColumns(10);

		JLabel lblbbvphc = new JLabel("/BB-VPHC");
		panel_1.add(lblbbvphc, "6, 4");

		JLabel lblNgyBb = new JLabel("Ngày lập biên bản");
		panel_1.add(lblNgyBb, "8, 4, right, default");

		textField_4 = new JTextField();
		panel_1.add(textField_4, "10, 4");
		textField_4.setColumns(10);

		JLabel lblSQ = new JLabel("Số quyết định");
		panel_1.add(lblSQ, "2, 6");

		textField_2 = new JTextField();
		panel_1.add(textField_2, "4, 6");
		textField_2.setColumns(10);

		JLabel lblQ = new JLabel("/QĐ-TTTVPT");
		panel_1.add(lblQ, "6, 6");

		JLabel lblNgyQ = new JLabel("Ngày quyết định");
		panel_1.add(lblNgyQ, "8, 6, right, default");

		textField_5 = new JTextField();
		panel_1.add(textField_5, "10, 6");
		textField_5.setColumns(10);

		JLabel lblaimVp = new JLabel("Địa điểm VP");
		panel_1.add(lblaimVp, "2, 8");

		textField_3 = new JTextField();
		panel_1.add(textField_3, "4, 8, 7, 1");
		textField_3.setColumns(10);

		JLabel lblPhtChnh = new JLabel("Phạt chính");
		panel_1.add(lblPhtChnh, "2, 10");

		JComboBox<String> comboBox_1 = new JComboBox<>();
		panel_1.add(comboBox_1, "4, 10, 7, 1");

		JLabel lbltngVp = new JLabel("Đ.tượng VP");
		panel_1.add(lbltngVp, "2, 12");

		JComboBox<String> comboBox = new JComboBox<>();
		panel_1.add(comboBox, "4, 12, 7, 1");

		JLabel lblCQuanX = new JLabel("Cơ quan xử lý");
		panel_1.add(lblCQuanX, "2, 14");

		JComboBox<String> comboBox_2 = new JComboBox<>();
		panel_1.add(comboBox_2, "4, 14, 7, 1");

		JLabel lblTinPht = new JLabel("Tiền phạt");
		panel_1.add(lblTinPht, "2, 16");

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "4, 16, 7, 1, fill, fill");
		panel_3.setLayout(
				new FormLayout(
						new ColumnSpec[] { ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
								FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
								FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
								FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
						new RowSpec[] { FormSpecs.DEFAULT_ROWSPEC, }));

		textField_10 = new JTextField();
		panel_3.add(textField_10, "1, 1, fill, default");
		textField_10.setColumns(10);

		JLabel lblng = new JLabel("(đồng)");
		lblng.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_3.add(lblng, "3, 1");

		JLabel lblNp = new JLabel("Đã nộp");
		panel_3.add(lblNp, "5, 1, right, default");

		textField_9 = new JTextField();
		panel_3.add(textField_9, "7, 1, fill, default");
		textField_9.setColumns(10);

		JLabel lblng_1 = new JLabel("(đồng)");
		lblng_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_3.add(lblng_1, "9, 1");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thi\u1EC7t h\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null,
				SystemColor.textHighlight));
		add(panel, "4, 2, fill, fill");
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, }));

		JLabel lblRngTrng = new JLabel("Rừng trồng");
		panel.add(lblRngTrng, "2, 2, left, default");

		textField_6 = new JTextField();
		panel.add(textField_6, "4, 2, fill, default");
		textField_6.setColumns(10);

		JLabel lblHa_1 = new JLabel("ha");
		panel.add(lblHa_1, "6, 2");

		JLabel lblRngTNhin = new JLabel("Rừng tự nhiên");
		panel.add(lblRngTNhin, "2, 4, left, default");

		textField_7 = new JTextField();
		panel.add(textField_7, "4, 4, fill, default");
		textField_7.setColumns(10);

		JLabel lblHa = new JLabel("ha");
		panel.add(lblHa, "6, 4");

		JLabel lbltLn = new JLabel("Đất LN");
		panel.add(lbltLn, "2, 6, left, default");

		textField_8 = new JTextField();
		panel.add(textField_8, "4, 6, fill, default");
		textField_8.setColumns(10);

		JLabel lblHa_2 = new JLabel("ha");
		panel.add(lblHa_2, "6, 6");
	}

}
