package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXTextField;

import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Font;

public class Panel002 extends JPanel {
	private static final long serialVersionUID = -4475011562305211512L;
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
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	public Panel002() {
		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,});
		setLayout(formLayout);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		add(panel, "2, 2, 1, 9, fill, fill");

		JLabel lblSTt = new JLabel("Số TT");
		add(lblSTt, "4, 2, right, default");

		textField = new JTextField();
		add(textField, "6, 2, fill, default");
		textField.setColumns(10);

		JLabel lblHTn = new JLabel("Họ tên");
		add(lblHTn, "8, 2, 3, 1, right, default");

		textField_1 = new JTextField();
		add(textField_1, "12, 2, fill, default");
		textField_1.setColumns(10);

		JLabel lblNmSinh = new JLabel("Năm sinh");
		add(lblNmSinh, "4, 4, right, default");

		JComboBox comboBox_2 = new JComboBox();
		add(comboBox_2, "6, 4, fill, default");

		JLabel lblGiiTnh = new JLabel("Giới tính");
		add(lblGiiTnh, "8, 4, 3, 1, right, default");

		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "12, 4, fill, default");

		JLabel lblSCmt = new JLabel("Số CMT");
		add(lblSCmt, "4, 6, right, default");

		textField_2 = new JXTextField("(chứng minh thư hoặc giấy phép lái xe)");
		textField_2.setToolTipText("");
		add(textField_2, "6, 6, fill, default");
		textField_2.setColumns(10);

		JLabel lblDnTc = new JLabel("Dân tộc");
		add(lblDnTc, "8, 6, 3, 1, right, default");

		JComboBox comboBox = new JComboBox();
		add(comboBox, "12, 6, fill, default");

		JLabel lblTnnh = new JLabel("Tên ảnh");
		add(lblTnnh, "4, 8, right, default");

		textField_3 = new JTextField();
		add(textField_3, "6, 8, fill, default");
		textField_3.setColumns(10);

		JLabel lblaChThng = new JLabel("Địa chỉ thường trú");
		add(lblaChThng, "8, 8, 3, 1, right, default");

		textField_13 = new JTextField();
		add(textField_13, "12, 8, fill, default");
		textField_13.setColumns(10);

		JLabel lblSQxp = new JLabel("Số QĐXP");
		add(lblSQxp, "4, 10, right, default");

		textField_4 = new JTextField();
		add(textField_4, "6, 10, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblqxphc = new JLabel("/QĐ-XPHC");
		lblqxphc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblqxphc, "8, 10");

		JLabel lblSBb = new JLabel("Số BB");
		add(lblSBb, "10, 10, right, default");

		textField_12 = new JTextField();
		add(textField_12, "12, 10, fill, default");
		textField_12.setColumns(10);

		textField_14 = new JTextField();
		add(textField_14, "2, 12, fill, default");
		textField_14.setColumns(10);

		JLabel lblNgyQ = new JLabel("Ngày QĐ");
		add(lblNgyQ, "4, 12, right, default");

		textField_5 = new JTextField();
		add(textField_5, "6, 12, fill, default");
		textField_5.setColumns(10);

		JLabel lblNgyLpBbvp = new JLabel("Ngày lập BBVP");
		add(lblNgyLpBbvp, "8, 12, 3, 1, right, default");

		textField_11 = new JTextField();
		add(textField_11, "12, 12, fill, default");
		textField_11.setColumns(10);

		JLabel lblHnhViVphm = new JLabel("Hành vi v.phạm");
		add(lblHnhViVphm, "4, 14, right, default");

		textField_6 = new JTextField();
		add(textField_6, "6, 14, fill, default");
		textField_6.setColumns(10);

		JLabel lblPhtBSung = new JLabel("Phạt bổ sung");
		add(lblPhtBSung, "8, 14, 3, 1, right, default");

		textField_10 = new JTextField();
		add(textField_10, "12, 14, fill, default");
		textField_10.setColumns(10);

		JLabel lblBinPhpKhc = new JLabel("Biện pháp khắc phục");
		add(lblBinPhpKhc, "2, 16, 3, 1, right, default");

		textField_7 = new JTextField();
		add(textField_7, "6, 16, 7, 1, fill, default");
		textField_7.setColumns(10);

		JLabel lblTinPht = new JLabel("Tiền phạt");
		add(lblTinPht, "4, 18, right, default");

		textField_8 = new JTextField();
		add(textField_8, "6, 18, fill, default");
		textField_8.setColumns(10);
				
				JLabel lblng = new JLabel("(đồng)");
				lblng.setFont(new Font("Tahoma", Font.ITALIC, 11));
				add(lblng, "8, 18");
						
								JLabel lblNp = new JLabel("Đã nộp");
								add(lblNp, "10, 18, right, default");
						
								textField_9 = new JTextField();
								add(textField_9, "12, 18, fill, default");
								textField_9.setColumns(10);
						
						JLabel lblng_1 = new JLabel("(đồng)");
						lblng_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
						add(lblng_1, "14, 18");
	}

}
