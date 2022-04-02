
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/Session")
public class Session extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//➀セッションの作成・取得
		HttpSession session = request.getSession();

		int i = 0;
		String str = null;

//➁セッションに前回の値があった場合は取出して i に格納
		if (session.getAttribute("session") != null) {

			i = (int) session.getAttribute("session");
			str = "holding a session";

		}

//➂加算
		i++;

		session.setAttribute("session", i);
		
		
		InetAddress ip;
		ip = InetAddress.getLocalHost();
		
		
		

//➄ブラウザへ表示
		PrintWriter pw = response.getWriter();

		pw.print("<html><body>");
		pw.print("<h1>");
		pw.print(i);
		pw.print("</h1>");
		if (i == 1)
			str = "holding a session";
		if (str != null) {

			pw.print("<p>");
			pw.print(str);
			pw.print("<br>");
			pw.print(ip.getHostAddress());
			pw.print("</p>");

		}
		pw.print("</body></html>");
		pw.flush();
		pw.close();

	}

}