package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTextField;

import com.alee.laf.toolbar.WebToolBar;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import factory.ButtonFactory;
import factory.CommandFactory;
import factory.ImageFactory;

public class Panel002 extends JPanel {
	private static final long serialVersionUID = -4475011562305211512L;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private JPanel pnInfo;
	private JTextField textField;

	public Panel002() {
		setLayout(new BorderLayout(0, 0));

		pnInfo = new JPanel();
		pnInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin vi ph\u1EA1m", TitledBorder.LEADING, TitledBorder.TOP,
				null, SystemColor.textHighlight));
		add(pnInfo, BorderLayout.NORTH);

		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.PREF_COLSPEC,
				FormSpecs.PREF_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("pref:grow"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
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
				RowSpec.decode("default:grow"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,});
		pnInfo.setLayout(formLayout);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		pnInfo.add(panel, "2, 2, 1, 7, fill, fill");
				
						JLabel lblSQxp = new JLabel("Số QĐXP");
						pnInfo.add(lblSQxp, "4, 2, right, default");
		
				textField_1 = new JTextField();
				pnInfo.add(textField_1, "6, 2, fill, default");
				textField_1.setColumns(10);
				
						JLabel lblqxphc = new JLabel("/QĐ-XPHC,");
						lblqxphc.setFont(new Font("Tahoma", Font.PLAIN, 11));
						pnInfo.add(lblqxphc, "7, 2");
				
				JLabel lblSBb = new JLabel("Số BB");
				pnInfo.add(lblSBb, "8, 2, right, default");
						
								textField_11 = new JTextField();
								pnInfo.add(textField_11, "10, 2, fill, default");
								textField_11.setColumns(10);
				
						JLabel lblNgyQ = new JLabel("Ngày QĐ");
						pnInfo.add(lblNgyQ, "4, 4, right, default");
		
				textField_5 = new JTextField();
				pnInfo.add(textField_5, "6, 4, fill, default");
				textField_5.setColumns(10);
		
				JLabel lblNgyLpBbvp = new JLabel("Ngày lập BBVP");
				pnInfo.add(lblNgyLpBbvp, "7, 4, 2, 1, right, default");
						
								textField_12 = new JTextField();
								pnInfo.add(textField_12, "10, 4, fill, default");
								textField_12.setColumns(10);
				
						JLabel lblHTn = new JLabel("Họ tên");
						pnInfo.add(lblHTn, "4, 6, right, default");
		
				textField_7 = new JTextField();
				pnInfo.add(textField_7, "6, 6, fill, default");
				textField_7.setColumns(10);

		JLabel lblDnTc = new JLabel("Dân tộc");
		pnInfo.add(lblDnTc, "7, 6, 2, 1, right, default");
				
						JComboBox<String> comboBox_2 = new JComboBox<>();
						pnInfo.add(comboBox_2, "10, 6, fill, default");
		
				JLabel lblSCmt = new JLabel("Số CMT");
				pnInfo.add(lblSCmt, "4, 8, right, default");
				
						textField_2 = new JXTextField("(hoặc giấy phép lái xe)");
						textField_2.setToolTipText("");
						pnInfo.add(textField_2, "6, 8, fill, default");
						textField_2.setColumns(10);
		
				JLabel lblGiiTnh = new JLabel("Giới tính");
				pnInfo.add(lblGiiTnh, "7, 8, 2, 1, right, default");
		
				JComboBox<String> comboBox_1 = new JComboBox<>();
				pnInfo.add(comboBox_1, "10, 8, fill, default");

		textField_14 = new JTextField();
		textField_14.setEditable(false);
		pnInfo.add(textField_14, "2, 10, fill, default");
		textField_14.setColumns(10);
				
						JLabel lblaChThng = new JLabel("Đ.chỉ th.trú");
						pnInfo.add(lblaChThng, "4, 10, right, default");
				
						textField_4 = new JTextField();
						pnInfo.add(textField_4, "6, 10, fill, default");
						textField_4.setColumns(10);
		
				JLabel lblNmSinh = new JLabel("Năm sinh");
				pnInfo.add(lblNmSinh, "7, 10, 2, 1, right, default");
		
				JComboBox<String> comboBox = new JComboBox<>();
				pnInfo.add(comboBox, "10, 10, fill, default");

		JLabel lblHnhViVphm = new JLabel("Hành vi v.phạm");
		pnInfo.add(lblHnhViVphm, "4, 12, right, default");

		textField_6 = new JTextField();
		pnInfo.add(textField_6, "6, 12, fill, default");
		textField_6.setColumns(10);

		JLabel lblPhtBSung = new JLabel("Phạt bổ sung");
		pnInfo.add(lblPhtBSung, "7, 12, 2, 1, right, default");

		textField_10 = new JTextField();
		pnInfo.add(textField_10, "10, 12, fill, default");
		textField_10.setColumns(10);
				
						JLabel lblTinPht = new JLabel("Tiền phạt");
						pnInfo.add(lblTinPht, "4, 14, right, default");
				
				JPanel panel_2 = new JPanel();
				pnInfo.add(panel_2, "6, 14, fill, fill");
				panel_2.setLayout(new FormLayout(new ColumnSpec[] {
						ColumnSpec.decode("default:grow"),
						FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormSpecs.DEFAULT_COLSPEC,},
					new RowSpec[] {
						FormSpecs.DEFAULT_ROWSPEC,}));
				
						textField_8 = new JTextField();
						panel_2.add(textField_8, "1, 1");
						textField_8.setColumns(10);
						
								JLabel lblng = new JLabel("(đồng)");
								panel_2.add(lblng, "2, 1");
								lblng.setFont(new Font("Tahoma", Font.ITALIC, 11));
								
										JLabel lblNp = new JLabel("Đã nộp");
										panel_2.add(lblNp, "4, 1");
										
												textField_9 = new JTextField();
												panel_2.add(textField_9, "6, 1");
												textField_9.setColumns(10);
												
														JLabel lblng_1 = new JLabel("(đồng)");
														panel_2.add(lblng_1, "7, 1");
														lblng_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
				JLabel lblBinPhpKhc = new JLabel("B.pháp kh.phục");
				pnInfo.add(lblBinPhpKhc, "7, 14, 2, 1, right, default");
				
				textField = new JTextField();
				pnInfo.add(textField, "10, 14, fill, default");
				textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u vi ph\u1EA1m", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		JXTable table = new JXTable();
		scrollPane.setViewportView(table);

		WebToolBar webToolBar = new WebToolBar();
		webToolBar.setUndecorated(true);
		webToolBar.setShadeWidth(0);
		webToolBar.setSpacing(-2);
		webToolBar.setOrientation(SwingConstants.VERTICAL);
		panel_1.add(webToolBar, BorderLayout.EAST);

		JButton btnNewRecord = ButtonFactory.createButtonToolBar("Thêm dòng mới", CommandFactory.ADD_CMD,
				ImageFactory.getIcon(ImageFactory.NEW_ICON), null, true);
		webToolBar.add(btnNewRecord);

		JButton btnDeleteRecord = ButtonFactory.createButtonToolBar("Xóa dòng đã chọn", CommandFactory.DELETE_CMD,
				ImageFactory.getIcon(ImageFactory.DELETE_ICON), null, true);
		webToolBar.add(btnDeleteRecord);

		JButton btnRefresh = ButtonFactory.createButtonToolBar("Tải lại dữ liệu", CommandFactory.RELOAD_CMD,
				ImageFactory.getIcon(ImageFactory.REFRESH_ICON), null, true);
		webToolBar.add(btnRefresh);
	}

}
