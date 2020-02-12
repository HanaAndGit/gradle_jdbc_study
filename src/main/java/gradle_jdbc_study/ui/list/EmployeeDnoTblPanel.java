package gradle_jdbc_study.ui.list;

import java.util.Date;

import javax.swing.SwingConstants;

import gradle_jdbc_study.dto.Department;
import gradle_jdbc_study.dto.Employee;
import gradle_jdbc_study.dto.Title;



@SuppressWarnings("serial")
public class EmployeeDnoTblPanel extends AbstractTblPanel<Employee> {
	public EmployeeDnoTblPanel() {
	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(50, 150, 50);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"부서번호", "부서명", "위치"};
	}

	@Override
	protected Object[] toArray(Employee item) {
		return new Object[] {
				item.getEmpNo(),
				item.getEmpName(),
				item.getTitle().getTitleNo(),
				item.getManager().getEmpNo(),
				item.getSalary(),
				item.getDept().getDeptNo(),
				item.getPasswd(),
				item.getHireDate()
				/* String.format("%d", item.getFloor()) */};
	}

	@Override
	public void updateRow(Employee item, int updateIdx) {
		model.setValueAt(item.getEmpNo(), updateIdx, 0);//학생번호
		model.setValueAt(item.getEmpName(), updateIdx, 1);
		model.setValueAt(item.getTitle().getTitleNo(), updateIdx, 2);
		model.setValueAt(item.getManager().getEmpNo(), updateIdx, 3);
		model.setValueAt(item.getSalary(), updateIdx, 4);
		model.setValueAt(item.getDept().getDeptNo(), updateIdx, 5);
		model.setValueAt(item.getPasswd(), updateIdx, 6);
		model.setValueAt(item.getHireDate(), updateIdx, 7);
	}
	@Override
	public Employee getSelectedItem() {
		int selectedIdx = getSelectedRowIdx();
		int empNo = (int) model.getValueAt(selectedIdx, 0);
		String empName = (String) model.getValueAt(selectedIdx, 1);
		Title title = (Title) model.getValueAt(selectedIdx, 2);
		Employee manager = (Employee) model.getValueAt(selectedIdx, 3);
		int salary = (int) model.getValueAt(selectedIdx, 4);
		Department dept = (Department) model.getValueAt(selectedIdx, 5);
		String passwd = (String) model.getValueAt(selectedIdx, 6);
		Date hireDate = (Date) model.getValueAt(selectedIdx, 7);
		return new Employee(empNo, empName, title, manager, salary, dept, passwd, hireDate);
	}




}
