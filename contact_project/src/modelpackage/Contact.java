package modelpackage;

import java.sql.*;
import java.sql.Connection;

public class Contact {
	
	public static Connection getConnection() {
	    Connection conn = null;
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      String user = "root";
	      String password = "8857@Tiwari";
	      String url = "jdbc:mysql://localhost:3306/swabhav techlabs";
	      conn = DriverManager.getConnection(url,user,password);
	    } catch (Exception e) {
	      System.err.println(e);
	    }
	    return conn;
	  }

	

	public void displayValues() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement sel = conn.prepareStatement("Select * from Contact");

			ResultSet res = sel.executeQuery();

			while (res.next()) {
				System.out.println(res.getString("fname") + "," + res.getString("lname") + "," + res.getLong("number")
						+ "," + res.getString("email"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Displaying Values");
		}
	}

	public void insertValues() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement ins = conn.prepareStatement("insert into Contact(fname,lname,number,email)\r\n"
					+ "values(\"Jyoti\",\"Tiwari\",7355192891,\"tiwari20jyoti@gmail.com\");");
			PreparedStatement ins1 = conn.prepareStatement("insert into Contact(fname,lname,number,email)\r\n"
					+ "values(\"Ravi\",\"Tiwari\",884593848,\"ravi10@gmail.com\");");
			ins.executeUpdate();
			ins1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Insertion completed");
		}
	}

	public void updateValues() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement upd = conn.prepareStatement("update Contact set fname=\"ABC\" where number=7355192891;");
			upd.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Updation completed");
		}
	}

	public void deleteValues() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement del = conn.prepareStatement("delete from  Contact where number=884593848");
			del.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Deletion completed");
		}
	}
	
	
	}


