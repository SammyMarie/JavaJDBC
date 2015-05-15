package starter.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.*;

public class States {
	public static void displayData(ResultSet rs) throws SQLException{
		while(rs.next()){
			String stateFullName = rs.getString("stateId") + ": " + rs.getString("stateName");
			out.println(stateFullName);
		}
	}
}
