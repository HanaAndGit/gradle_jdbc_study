package gradle_jdbc_study.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import gradle_jdbc_study.dto.Department;
import gradle_jdbc_study.ui.exception.InvalidCheckException;


@SuppressWarnings("serial")
public class DepartmentPanel extends AbsItemPanel<Department> {
	private JLabel lblNo;
	private JTextField tfNo;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblFloor;
	private JTextField tfFloor;

	public DepartmentPanel() {
		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "부서관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 0));
		
		lblNo = new JLabel("\uBD80\uC11C\uBC88\uD638");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);
		
		lblName = new JLabel("\uBD80\uC11C\uBA85");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
		
		lblFloor = new JLabel("\uC704\uCE58");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		add(tfFloor);
	}

	@Override
	public Department getItem() {
		validCheck();
		int deptNo = Integer.parseInt(tfNo.getText().trim());
		String deptName = tfName.getText().trim();
		int floor =  Integer.parseInt(tfFloor.getText().trim());
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public void setItem(Department item) {
		tfNo.setText(item.getDeptNo()+"");
		tfName.setText(item.getDeptName());
		tfFloor.setText(item.getFloor() +"");
	}

	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		tfFloor.setText("");		
	}
	@Override
	public void validCheck() {
		//둘 중 하나라도 공백이라면
		if(tfNo.getText().contentEquals("") || tfName.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
		
	}

}
