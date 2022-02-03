

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileStuff
 */
@WebServlet("/ProfileStuff")
public class ProfileStuff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileStuff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		if(type.equals("dailyreward")) {
			String username = request.getParameter("name");
			System.out.println(username);
			String data="";
			ProfileDao pd=new ProfileDao();
			try {
				 data=pd.Profile(username);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().println("{\"data\":'"+data+"'}");
		}else {
			String username = request.getParameter("name");
			Serializations Data=new Serializations(username, "user");
				try {		
					FileOutputStream fileOut =new FileOutputStream("/tmp/employee.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(Data);
			         out.close();
			         fileOut.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	}

}
