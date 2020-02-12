package gradle_jdbc_study.ds;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import gradle_jdbc_study.util.LogUtil;

public class MySqlDataSourceTest {

	@Test
	public void testGetConnection() {
		try(Connection con = MySqlDataSource.getConnection();){
			LogUtil.prnLog(con);
			Assert.assertNotNull(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
