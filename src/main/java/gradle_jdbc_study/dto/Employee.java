package gradle_jdbc_study.dto;

import java.util.Arrays;
import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dept;
	private String password;
	private Date hire_date;
	private byte[] pic;
	
	
	
	public Employee(int empNo) {
		super();
		this.empNo = empNo;
	}



	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept,
			String password, Date hire_date) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
		this.password = password;
		this.hire_date = hire_date;
	}



	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept,
			String password, Date hire_date, byte[] pic) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
		this.password = password;
		this.hire_date = hire_date;
		this.pic = pic;
	}
	
	



	public int getEmpNo() {
		return empNo;
	}



	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + empNo;
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + Arrays.hashCode(pic);
		result = prime * result + salary;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empNo != other.empNo)
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (!Arrays.equals(pic, other.pic))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return String.format(
				"Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, dept=%s, password=%s, hire_date=%s, pic=%s]",
				empNo, empName, title, manager.getEmpNo(), salary, dept.getDeptNo(), password, hire_date, String.format("%1$tF %1$tT", hire_date), 
				pic != null?pic.length:null);
	}





	
	
	
	
	
	
}
