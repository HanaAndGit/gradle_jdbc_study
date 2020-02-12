package gradle_jdbc_study.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gradle_jdbc_study.dto.Department;
import gradle_jdbc_study.ui.content.EmployeePanel;
import gradle_jdbc_study.ui.list.TitleTblPanel;
import gradle_jdbc_study.ui.service.EmployeeUIService;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private LoginFrame loginFrame;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblLoginName;
	private JButton btnLogout;
	private JButton btnTitle;
	private JButton btnDepartment;
	private JButton btnEmployee;
	private TestTableFrame testFrame;
	private static TitleTblPanel titleP;

	public MainFrame() {
		initialize();
	}
	

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		//loginNameRefresh();
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblLoginName = new JLabel("이름");
		lblLoginName.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 26));
		panel.add(lblLoginName);
		
		btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(this);
		panel.add(btnLogout);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnTitle = new JButton("\uC9C1\uCC45 \uC815\uBCF4");
		btnTitle.addActionListener(this);
		panel_1.add(btnTitle);
		
		btnDepartment = new JButton("\uBD80\uC11C \uC815\uBCF4");
		btnDepartment.addActionListener(this);
		panel_1.add(btnDepartment);
		
		btnEmployee = new JButton("사원 정보");
		btnEmployee.addActionListener(this);
		panel_1.add(btnEmployee);
	}


	public void loginNameRefresh() {
		System.out.println(loginFrame.loginEmp.getEmpName());
		lblLoginName.setText(loginFrame.loginEmp.getEmpName());
	}

	
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmployee) {
			btnEmployeeActionPerformed(e);
		}
		if (e.getSource() == btnDepartment) {
			btnDepartmentActionPerformed(e);
		}
		if (e.getSource() == btnTitle) {
			btnTitleActionPerformed(e);
		}
		if (e.getSource() == btnLogout) {
			btnLogoutActionPerformed(e);
		}
	}


	private void logOut() {
		loginFrame.loginEmp = null; //로그아웃 했으니까 null
		dispose();
		loginFrame.setVisible(true);
		loginFrame.clearTf();
	}
	protected void btnLogoutActionPerformed(ActionEvent e) {
		logOut();
	}
	protected void btnTitleActionPerformed(ActionEvent e) {
		testFrame.titleTableFrame();
		
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		testFrame.DeptTableFrame();
		
	}
	protected void btnEmployeeActionPerformed(ActionEvent e) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 350, 450);
		//콤보박스에 부서 목록 넣기
		EmployeeUIService service = new EmployeeUIService();
		List<Department> list = service.showDeptList();
		EmployeePanel tp = new EmployeePanel();
		tp.setCmbDeptList(list);
		tp.getCmbDept().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					JOptionPane.showMessageDialog(null, e.getItem());
					tp.setCmbManagerList(service.showManagerList((Department)(e.getItem())));
				}
				
			}
		});
//		tp.setService(service);
		frame.getContentPane().add(tp);
		frame.setVisible(true);
	}
}
