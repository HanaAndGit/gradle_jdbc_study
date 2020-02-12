package gradle_jdbc_study.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import gradle_jdbc_study.dto.Employee;
import gradle_jdbc_study.ui.service.LoginService;

public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tftNo;
	private JButton btnLogin;
	private JButton btnCancel;
	private LoginService service;
	private MainFrame main;
	
	
	public static Employee loginEmp;
	private JPasswordField tfPasswd;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//select Look and Feel
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		service = new LoginService();
		initialize();
		
	}

	private void initialize() {
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uB85C\uADF8\uC778", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 10, 0));
		
		JPanel pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("�����ȣ");
		pContent.add(lblNo);
		
		tftNo = new JTextField();
		pContent.add(tftNo);
		tftNo.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPasswd = new JLabel("��й�ȣ");
		panel.add(lblPasswd);
		
		tfPasswd = new JPasswordField();
		panel.add(tfPasswd);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		btnLogin = new JButton("�α���");
		btnLogin.addActionListener(this);
		panel_1.add(btnLogin);
		
		btnCancel = new JButton("���");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnLogin) {
			btnLoginActionPerformed(e);
		}
	}
	protected void btnLoginActionPerformed(ActionEvent e) {
		int empNo = Integer.parseInt(tftNo.getText().trim());
		String passwd =tfPasswd.getText();
		System.out.println(empNo + " : " + passwd);
		loginEmp = service.login(new Employee(empNo, passwd));
		if(loginEmp==null) {
			JOptionPane.showMessageDialog(null, "�����ȣ Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
			return;
		}
		JOptionPane.showMessageDialog(null, loginEmp.getEmpName() + "�� �ݰ����ϴ�.");
		if(main == null) {
			main = new MainFrame();
			main.setLoginFrame(this);
		}
		dispose();
		main.loginNameRefresh();
		main.setVisible(true);
		
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		clearTf();
	}

	public void clearTf() {
		tftNo.setText("");
		tfPasswd.setText("");
	}
}
