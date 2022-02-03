

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if(session.getAttribute("JSess")!=null) {
			response.sendRedirect(request.getContextPath()+"/Profile");
		}else {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if(session.getAttribute("JSess")!=null) {
			response.sendRedirect(request.getContextPath()+"/Profile");
		}
		String Username= request.getParameter("username");
		String Password= request.getParameter("password");
		LoginDao logg=new LoginDao();
		try {
			String[] logged=logg.Login(Username,Password);
			System.out.println(logged[0]);
			if(logged[0]!="0") {
				session.setAttribute("JSess", true);
				session.setAttribute("values", logged[1]+":"+logged[2]+":"+logged[3]);
				response.sendRedirect(request.getContextPath()+"/Profile.jsp");
			}else {
				response.getWriter().println("INVALID USERNAME OR PASSWORD");
			}

			
		} catch (SQLException e) {
			response.getWriter().println("501 Server err");
			e.printStackTrace();
		}
	}

}
