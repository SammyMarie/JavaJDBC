package starter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.lang.System.*;

public class MysqlTest {
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "oluwafemi1984";
	private static final String CONN_STRING =
			"jdbc:mysql://localhost/explorecalifornia";
	
	public static void main(String[] args) throws SQLException {
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = null;
		try{
		conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		out.println("Connected!");
		}catch(SQLException se){
			err.println(se);
		}finally{
			if(conn != null)
				conn.close();
		}
	}
}