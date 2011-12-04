package task1_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MobilePhone {
	
	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ReportedBook");
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("Select * from MobilePhone");
			
			while(resultSet.next()){
				int article = resultSet.getInt("ARTICLE");
				String nameOfProduct = resultSet.getString("NAME");
				int price = resultSet.getInt("PRICE");
				
				System.out.println("" + article + ": " + nameOfProduct + " - " + price + " rub;");
			}//while
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
