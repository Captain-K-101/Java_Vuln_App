import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	private String dburl="jdbc:mysql://localhost:3306/myDatabase";
	private String dbuname="****";
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
	
	public String insert(Member member) {
		
		LoadDriver(dbdriver);
		Connection con = getConnection();
		String res="data entered successfully";
		String sql="insert into users(username,password,email) values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res="Data Error";
		}
		return res;
		
	}
}
