package controller;

import model.*;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionServiceImpl;
import service.impl.EducationDegreeImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
                createEmployee(request, response);
                break;
//            case "edit":
//                try {
//                    updateEmployee(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
            case "delete":
                try {
                    deleteEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

        private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
            int id = Integer.parseInt(request.getParameter("id"));
            employeeService.deleteEmployee(id);
            try {
                response.sendRedirect("/employees");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer employeeId = null;
        String employeeName = request.getParameter("name");
        String employeeBirthday = request.getParameter("birthday");
        String employeeCard = request.getParameter("card");
        Double employeeSalary = Double.valueOf(request.getParameter("salary"));
        String employeePhone = request.getParameter("phone");
        String employeeEmail = request.getParameter("email");
        String employeeAddress = request.getParameter("address");
        Integer employeePositionId = Integer.valueOf(request.getParameter("position"));
        Integer employeeEducationDegreeId = Integer.valueOf(request.getParameter("education"));
        Integer employeeDivisionId = Integer.valueOf(request.getParameter("division"));
        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeCard, employeeSalary, employeePhone, employeeEmail,
                employeeAddress, employeePositionId, employeeEducationDegreeId, employeeDivisionId);
        employeeService.add(employee);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
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
            case "create":
                showCreateForm(request, response);
                break;
//            case "edit":
//                try {
//                    showEditForm(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
//            case "view":
////                viewProduct(request, response);
//                break;
            case "search":
                searchEmployeeByNamePositionEmail(request, response);
                break;
            default:
                System.out.println("list");
                listEmployee(request, response);
                break;
        }
    }

//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee existingEmployee = employeeService.selectEmployee(id);
//        List<Position> positionList = positionService.getList();
//        request.setAttribute("positionsList", positionList);
//        List<EducationDegree> educationDegreeList = educationDegreeService.getList();
//        request.setAttribute("educationDegreesList", educationDegreeList);
//        List<Division> divisionList = divisionService.getList();
//        request.setAttribute("divisionsList", divisionList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
//
//        Object existingCustomer;
//        request.setAttribute("customer", existingCustomer);
//        dispatcher.forward(request, response);
//
//        //User existingUser = userDAO.selectUser(id);
//
//    }

    private void searchEmployeeByNamePositionEmail(HttpServletRequest request, HttpServletResponse response) {
        String keywordName = request.getParameter("searchName");
        String keywordPosition = request.getParameter("searchPosition");
        String keywordEmail = request.getParameter("searchEmail");
        System.out.println(keywordName+keywordPosition+keywordEmail);
        List<Employee> employeeList = employeeService.searchByNamePositionEmail(keywordName,keywordPosition,keywordEmail);
        request.setAttribute("employeesList", employeeList);
        List<Position> positionList = positionService.getList();
        request.setAttribute("positionsList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.getList();
        request.setAttribute("educationDegreesList", educationDegreeList);
        List<Division> divisionList = divisionService.getList();
        request.setAttribute("divisionsList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.getList();
        request.setAttribute("positionsList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.getList();
        request.setAttribute("educationDegreesList", educationDegreeList);
        List<Division> divisionList = divisionService.getList();
        request.setAttribute("divisionsList", divisionList);
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
