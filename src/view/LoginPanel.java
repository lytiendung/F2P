package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXHyperlink;

import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.LoginController;
import factory.CommandFactory;
import factory.ImageFactory;
import java.awt.Insets;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = -1952081005312416343L;
	private WebTextField txtUser;
	private WebPasswordField txtPass;
	private JButton btnLoggin;
	private JXHyperlink btnConfig;

	public LoginPanel(final LoginController control) {
		setLayout(new BorderLayout(0, 0));

		this.setName(CommandFactory.PANEL_LOGIN);

		JPanel subPanel = new JPanel();
		subPanel.setBorder(new EmptyBorder(10, 3, 9, 3));
		add(subPanel, BorderLayout.SOUTH);
		subPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblVersion = new JLabel("Phiên bản 1.0 - 12/2015");
		subPanel.add(lblVersion, BorderLayout.WEST);

		btnConfig = new JXHyperlink();
		btnConfig.setClickedColor(Color.BLUE);
		btnConfig.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConfig.setText("Tùy chỉnh cài đặt");
		btnConfig.setActionCommand("config");
		btnConfig.addActionListener(control);
		btnConfig.setFocusable(false);
		btnConfig.setIcon(ImageFactory.getIcon(ImageFactory.SETTINGS_ICON));
		btnConfig.setVerticalAlignment(SwingConstants.TOP);
		subPanel.add(btnConfig, BorderLayout.EAST);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"), },
				new RowSpec[] { RowSpec.decode("default:grow"), RowSpec.decode("default:grow"), }));

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(0);
		panel.add(panel_6, "1, 1, fill, bottom");

		JLabel lblUser = new JLabel("Tài khoản");
		panel_6.add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/user.png")));

		txtUser = new WebTextField();
		txtUser.setFieldMargin(new Insets(2, 5, 2, 2));
		panel_6.add(txtUser);
		txtUser.setInputPrompt("Nhập tên tài khoản");
		txtUser.setActionCommand("key");
		txtUser.addActionListener(control);
		txtUser.addFocusListener(control);
		txtUser.setColumns(27);
		txtUser.setPreferredHeight(36);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "1, 2, fill, fill");
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setVgap(0);
		panel_5.add(panel_7, BorderLayout.NORTH);

		JLabel lblPass = new JLabel("Mật khẩu");
		panel_7.add(lblPass);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/key.png")));
		lblPass.setPreferredSize(lblUser.getPreferredSize());

		txtPass = new WebPasswordField();
		txtPass.setFieldMargin(new Insets(2, 5, 2, 2));
		txtPass.setInputPrompt("Nhập mật khẩu...");
		panel_7.add(txtPass);
		txtPass.setActionCommand("pass");
		txtPass.addActionListener(control);
		txtPass.addFocusListener(control);
		txtPass.setColumns(27);
		txtPass.setPreferredHeight(36);

		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("top:default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		btnLoggin = new JButton("Đăng nhập");
		panel_8.add(btnLoggin, "3, 4, left, default");
		btnLoggin.setActionCommand(CommandFactory.LOGIN_CMD);
		btnLoggin.addActionListener(control);
		btnLoggin.setFocusable(false);
		btnLoggin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoggin.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/locked.png")));

		JButton btnExit = new JButton("Thoát");
		panel_8.add(btnExit, "1, 4, right, default");
		btnExit.setFocusable(false);
		btnExit.setActionCommand(CommandFactory.EXIT_CMD);
		btnExit.addActionListener(control);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/cancel.png")));
		btnExit.setPreferredSize(btnLoggin.getPreferredSize());

		JSeparator separator = new JSeparator();
		panel_8.add(separator, "1, 6, 3, 1");

		subPanel.setOpaque(false);
		panel.setOpaque(false);
		panel_5.setOpaque(false);
		panel_6.setOpaque(false);
		panel_7.setOpaque(false);
		panel_8.setOpaque(false);
	}

	public String getUser() {
		return this.txtUser.getText().toLowerCase();
	}

	public char[] getPass() {
		return this.txtPass.getPassword();
	}

	public void setText() {
		this.txtPass.setText("");
		this.txtPass.requestFocus();
	}

	public JTextField getTxtUser() {
		return this.txtUser;
	}

	public JPasswordField getPassField() {
		return this.txtPass;
	}

	public JButton getBtnLoggin() {
		return this.btnLoggin;
	}

	private Image background = new ImageIcon(getClass().getResource("/images/backgrounds/bg6.jpg")).getImage();

	public void setBackground(Image img) {
		this.background = img;
	}

	public Image getImage() {
		return this.background;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);
	}

}
