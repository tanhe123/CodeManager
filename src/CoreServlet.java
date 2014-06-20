import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tan on 14-6-19.
 */
@WebServlet(urlPatterns = "/CoreServlet")
public class CoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*        String source = "function helloSyntaxHighlighter()\n" +
                "{\n" +
                "\treturn \"hi!\";\n" +
                "}";
        String type = "js";*/

        //     request.setAttribute("source", source);
        //   request.setAttribute("type", type);


        request.getRequestDispatcher("/display.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username") + " " + request.getParameter("password")
        + request.getParameter("remember"));
    }
}
