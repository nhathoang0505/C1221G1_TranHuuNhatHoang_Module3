package controller;

import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    ICustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    Customer customer = new Customer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                try {
                    updateCustomer(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            customerService.deleteCustomer(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer customerType = Integer.valueOf(request.getParameter("type"));
        String customerName = request.getParameter("name");
        String customerBirthday = request.getParameter("birthday");
        Byte customerGender = Byte.valueOf(request.getParameter("gender"));
        String customerCard = request.getParameter("idcard");
        String customerPhone = request.getParameter("phone");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("address");

        Customer updateCustomer = new Customer(id, customerType, customerName, customerBirthday, customerGender, customerCard, customerPhone, customerEmail, customerAddress);
        customerService.updateCustomer(updateCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = null;
        Integer customerType = Integer.valueOf(request.getParameter("type"));
        String customerName = request.getParameter("name");
        String customerBirthday = request.getParameter("birthday");
        Byte customerGender = Byte.valueOf(request.getParameter("gender"));
        String customerCard = request.getParameter("card");
        String customerPhone = request.getParameter("phone");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("address");
        customer = new Customer(id, customerType, customerName, customerBirthday, customerGender, customerCard, customerPhone, customerEmail, customerAddress);
        customerService.add(customer);
        try {
            response.sendRedirect("/customers");
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
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
//            case "delete":
//                break;
//            case "view":
////                viewProduct(request, response);
//                break;
            case "search":
                searchCustomerByName(request, response);
                break;
            default:
                System.out.println("list");
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.selectCustomer(id);
//        User existingUser = userRepository.getUserById(id);
        List<CustomerType> customerTypeList = customerTypeService.getList();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");

        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);

        //User existingUser = userDAO.selectUser(id);

    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search");
        List<Customer> customerList = customerService.searchByName(keyword);
        request.setAttribute("customersList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.getList();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.getList();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.getList();
        request.setAttribute("customersList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.getList();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
