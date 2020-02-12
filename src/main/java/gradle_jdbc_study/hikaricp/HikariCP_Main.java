package gradle_jdbc_study.hikaricp;

import java.sql.Connection;
import java.sql.SQLException;

import gradle_jdbc_study.dao.EmployeeDao;
import gradle_jdbc_study.dao.impl.EmployeeDaoImpl;
import gradle_jdbc_study.ds.MySqlDataSource;
import gradle_jdbc_study.dto.Employee;

public class HikariCP_Main {

	public static void main(String[] args) {
		try(Connection con = MySqlDataSource.getConnection()){
			//System.out.println(con);
			EmployeeDao dao = EmployeeDaoImpl.getInstance();
			//System.out.println(dao);
			Employee emp = new Employee(1003);
			Employee newEmp = dao.selectEmployeeByNo(emp);
			System.out.println(newEmp);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
