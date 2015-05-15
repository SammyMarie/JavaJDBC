package starter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import starter.tables.States;
import starter.tables.Tours;
import static java.lang.System.*;

public class MainDBLoader {
	
	private static final String query = "SELECT tourId, tourname, price FROM tours WHERE price <= ?";
	
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
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				) {
			stmt.setDouble(1, maxPrice);
			rs = stmt.executeQuery();
				//States.displayData(rs);
				//Tours.displayData(rs);
				
			
		} catch (SQLException e) {
			DBUtil.processException(e);
		} 
	}
}