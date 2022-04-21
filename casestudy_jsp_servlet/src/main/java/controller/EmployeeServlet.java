package controller;

import model.Division;
import model.EducationDegree;
import model.Employee;
import model.Position;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionServiceImpl;
import service.impl.EducationDegreeImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {


//        ICustomerService customerService = new CustomerServiceImpl();
//    ICustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
//    Customer customer = new Customer();

    IEmployeeService employeeService = new EmployeeServiceImpl();
    IPositionService positionService = new PositionServiceImpl();
    IEducationDegreeService educationDegreeService = new EducationDegreeImpl();
    IDivisionService divisionService = new DivisionServiceImpl();
    Employee employee = new Employee();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                createEmployee(request, response);
//                break;
//            case "edit":
//                try {
//                    updateEmployee(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
//            case "delete":
//                deleteEmployee(request, response);
//                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                showCreateForm(request, response);
//                break;
//            case "edit":
//                try {
//                    showEditForm(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
//            case "delete":
//                break;
//            case "view":
////                viewProduct(request, response);
//                break;
//            case "search":
//                searchEmployeeByName(request, response);
//                break;
            default:
                System.out.println("list");
                listEmployee(request, response);
                break;
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.getList();
        request.setAttribute("employeesList", employeeList);
        List<Position> positionList = positionService.getList();
        request.setAttribute("positionsList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.getList();
        request.setAttribute("educationDegreesList", educationDegreeList);
        List<Division> divisionList = divisionService.getList();
        request.setAttribute("divisionsList", divisionList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
