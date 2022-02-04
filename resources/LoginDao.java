import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Result;

public class LoginDao {

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
	
	public String[] Login(String username,String password) throws SQLException {
		
		LoadDriver(dbdriver);
		Connection con = getConnection();
		String[] ans = new String[10];
		String res="";
		String Name=null;
		String Email=null;
		String id=null;
		String query="SELECT * FROM users WHERE username='"+username+"' and password='"+password+"';";
		ResultSet rs;
		try {
			rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				Name=rs.getString("username");
				Email=rs.getString("email");
				id=rs.getString("id");
				ans[0]="1";
				ans[1]=Name;
				ans[2]=Email;
				ans[3]= id;
				
			}
			if(Email!=null && Name!=null) {
				ans[0]="1";
				res="Name="+Name+" and Email="+Email;
			}else {
				ans[0]="0";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ans;
		
	}}
