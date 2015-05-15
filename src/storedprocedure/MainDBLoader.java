package storedprocedure;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import starter.tables.States;
import starter.tables.Tours;
import static java.lang.System.*;

public class MainDBLoader {
	
	private static final String query = "{call GetToursByPrice(?)}";
	
	public static void main(String[] args) throws SQLException {
		
		double maxPrice;
		try{
			maxPrice = InputClass.getDoubleInput("Enter a maximum price: ");
		}catch(NumberFormatException nfe){
			err.println("Error: invalid number");
			return;
		}
		
		ResultSet rs = null;
		
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				CallableStatement stmt = conn.prepareCall(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				) {
			stmt.setDouble(1, maxPrice);
			rs = stmt.executeQuery();
			stmt.registerOutParameter("total", Types.INTEGER);
			
			int nRows = stmt.getInt("total");
				//States.displayData(rs);
				Tours.displayData(rs, nRows);
				
			
		} catch (SQLException e) {
			DBUtil.processException(e);
		} 
	}
}