package task2_PreraredStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobilePhone {
	
	public static final int article1 = 1111;
	public static final int article2 = 2222;
	public static final int article3 = 3212;
	
	public static void main(String args[]) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ReportedBook");
			stmt = conn.prepareStatement("Select * from MobilePhone WHERE ARTICLE=?");
			
			int articles[] = {article1,article2,article3};
			for (int i = 2; i >= 0; i--) {
				stmt.setInt(1, articles[i]);
				resultSet = stmt.executeQuery();
				while(resultSet.next()){
					int article = resultSet.getInt("ARTICLE");
					String nameOfProduct = resultSet.getString("NAME");
					int price = resultSet.getInt("PRICE");
					
					System.out.println("" + article + ": " + nameOfProduct + " - " + price + " rub;");
				} //while
			}//for
		} catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}//finally
	}//main
	
}
