

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String Uname=request.getParameter("username");
		String Password=request.getParameter("password");
		String Password2=request.getParameter("password2");
		String email=request.getParameter("email");
		if(Uname.startsWith("admin")) {
			Uname.replace("admin", "");
		}
		if(Password.equals(Password2)) {
			Member member = new Member(Uname,Password,email);
			RegisterDao dao=new RegisterDao();
			String Res=dao.insert(member);
			Cookie ck=new Cookie("user","sonoo jaiswal");
			response.addCookie(ck);
			response.getWriter().println(Res);
		}else {
			response.getWriter().println("Error Invaild Password");
			System.out.println(Password);
			System.out.println(Password2);
		}

	}

}
