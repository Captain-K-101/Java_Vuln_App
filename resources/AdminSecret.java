

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminSecret
 */
@WebServlet("/Admin")
public class AdminSecret extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSecret() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String val=(String)request.getParameter("Token");
		if(val!=null) {
		try {
			byte[] decodedString = Base64.getDecoder().decode(val.getBytes("UTF-8"));
			InputStream targetStream = new ByteArrayInputStream(decodedString);
			ObjectInputStream in = new ObjectInputStream(targetStream);
			Serializations s= (Serializations) in.readObject();
			System.out.println(targetStream);
			if(s.Name.startsWith("admin")) {
				response.getWriter().append("Welcome Admin The Flag is FLAG{FF}");
			}else {
				System.out.println(s.Name+":"+s.rank);
				response.getWriter().append("Not Admin Enough");
			}
	        in.close();
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			response.getWriter().append("Plz insert Token");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
