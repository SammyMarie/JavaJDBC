package starter.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

import static java.lang.System.*;

public class Tours {
	
	public static void displayData(ResultSet rs, int nRows) throws SQLException{
		
		if(nRows == 0){
			out.println("No tours were found");
		}else{
			out.println("Number of tours: " + nRows);
			rs.beforeFirst();
			
			while (rs.next()) {
				StringBuffer buf = new StringBuffer();
			
				buf.append("Tour " + rs.getInt("tourId") + ": ");
				buf.append(rs.getString("tourName"));
			
				double price = rs.getDouble("price");
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String formattedPrice = nf.format(price);
			
				buf.append(" (" + formattedPrice + ")");
			
				out.println(buf.toString());
			}
		}
	}
}
