import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double num1 = Double.parseDouble(request.getParameter("operand1"));
        String operators = request.getParameter("dropdownOperator");
        Double num2 = Double.parseDouble(request.getParameter("operand2"));
        String exceptionNotif = null;
        Double result = null;
        try {
            result = Calculator.calculate(num1, num2, operators);
        } catch (Exception exception) {
            exceptionNotif = exception.getMessage();
        }
        request.setAttribute("results", result);
        request.setAttribute("exceptions", exceptionNotif);
        request.setAttribute("num1",num1);
        request.setAttribute("num2",num2);
        request.setAttribute("operators",operators);
        request.getRequestDispatcher("/display_result.jsp").forward(request, response);
    }
}
