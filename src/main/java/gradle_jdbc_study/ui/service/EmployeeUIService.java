package gradle_jdbc_study.ui.service;

import java.util.List;

import gradle_jdbc_study.dao.DepartmentDao;
import gradle_jdbc_study.dao.EmployeeDao;
import gradle_jdbc_study.dao.impl.DepartmentDaoImpl;
import gradle_jdbc_study.dao.impl.EmployeeDaoImpl;
import gradle_jdbc_study.dto.Department;
import gradle_jdbc_study.dto.Employee;

public class EmployeeUIService {
	private EmployeeDao empDao;
	private DepartmentDao deptDao;
	public EmployeeUIService() {
		empDao = EmployeeDaoImpl.getInstance();
		deptDao = DepartmentDaoImpl.getInstance();
	}

	public List<Department> showDeptList() {
		//�޺��ڽ��� ä�� ����Ʈ
		return deptDao.selectDepartmentByAll();
	}

	public List<Employee> showManagerList(Department dept) {
		//�޺��ڽ��� ä�� ����Ʈ
		return empDao.selectEmployeeGroupByDno(dept);
	}
	
	
}
