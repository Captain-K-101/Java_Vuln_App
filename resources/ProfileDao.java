import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Result;

public class ProfileDao {

	private String dburl="jdbc:mysql://localhost:3306/myDatabase";
	private String dbuname="nik";
	private String password="password";
	private String dbdriver="com.sql.jdbc.Driver";
	
	
	public void LoadDriver(String dbdriver) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con =null;
		try {
			con=DriverManager.getConnection(dburl,dbuname,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public String GetDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date(0));
		return date;
	}
	
	public String Profile(String username) throws SQLException {
		
		LoadDriver(dbdriver);
		Connection con = getConnection();
		String ans="";
		ResultSet rs,rs1,rs2,rs3,rs4;
		String query1="Select * from Stats where username='"+username+"'";
		rs1 = con.createStatement().executeQuery(query1);
		String query="";	
		if(rs1.next()==false) {
			System.out.println("CHECK1");
			query="Insert into stats(username,statpoint,date) values('"+username+"',1,'"+GetDate()+"') as a";
			con.createStatement().executeUpdate(query);
			ans="Reward Set";
		}else {
			String query2="Select DATE('"+rs1.getString("date")+"')<DATE('"+GetDate()+"')";
			rs2 = con.createStatement().executeQuery(query2);
			if(rs2.getInt("a")!=0) {
				query="UPDATE stats set statpoint=statpoint+1 where username='"+username+"'";
				con.createStatement().executeUpdate(query);
				query="UPDATE stats set date="+GetDate()+"where username='"+username+"'";
				con.createStatement().executeUpdate(query);
				ans="Reward Set";
			}else {
				ans="ALDREDY UPDATED TODAYS REWARD";
			}
		}

		return ans;
		
	}}
