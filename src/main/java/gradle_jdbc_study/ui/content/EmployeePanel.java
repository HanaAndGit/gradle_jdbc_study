package gradle_jdbc_study.ui.content;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gradle_jdbc_study.dto.Department;
import gradle_jdbc_study.dto.Employee;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class EmployeePanel extends AbsItemPanel<Employee>{
	private JTextField tfNo;
	private JTextField tfName;
	private JComboBox<Department> cmbDept;
	private JComboBox<Employee> cmbManager;
	

	public EmployeePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		add(pWest, BorderLayout.WEST);
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("사원 번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblNo);
		
		tfNo = new JTextField();
		pCenter.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("사원명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		pCenter.add(tfName);
		
		JLabel lblDept = new JLabel("부서");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblDept);
		
		cmbDept = new JComboBox();
		pCenter.add(cmbDept);
		
		JLabel lblMng = new JLabel("직속상사");
		lblMng.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblMng);
		
		cmbManager = new JComboBox<>();
		pCenter.add(cmbManager);

	}
	
	public void setCmbDeptList(List<Department> list) {
		//외부에서 리스트를 받아서 모델을 이용해서 콤보박스 채워넣기
		DefaultComboBoxModel<Department> model = new DefaultComboBoxModel<Department>(new Vector<>(list));
		cmbDept.setModel(model);
		cmbDept.setSelectedIndex(-1);
	}
	
	public void setCmbManagerList(List<Employee> mngList) {
		//외부에서 리스트를 받아서 모델을 이용해서 콤보박스 채워넣기
		DefaultComboBoxModel<Employee> model = new DefaultComboBoxModel<Employee>(new Vector<>(mngList));
		cmbManager.setModel(model);
		cmbManager.setSelectedIndex(-1);
	}
	
	@Override
	public Employee getItem() {
		validCheck();
		return null;
	}

	@Override
	public void setItem(Employee item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearTf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validCheck() {
		// TODO Auto-generated method stub
		
	}

	public JComboBox<Department> getCmbDept() {
		return cmbDept;
	}

	public JComboBox<Employee> getCmbManager() {
		return cmbManager;
	}

	
}
