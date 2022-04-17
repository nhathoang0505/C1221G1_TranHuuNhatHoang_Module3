package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product", "/"})
public class ProductServlet extends HttpServlet {
    IProductService iProductService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
//                showEditForm(request,response);
                break;
            case "delete":
//                showDeleteForm(request,response);
                break;
            case "view":
//                viewProducts(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 10000);
        String name = request.getParameter("addName");
        String type = request.getParameter("addType");
        int quantity = Integer.parseInt(request.getParameter("addQuantity"));

        Product product = new Product(id, name, type, quantity);
        this.iProductService.save(product);
        request.setAttribute("message","New product was created.");
        try {
            request.getRequestDispatcher("/product/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
//                showEditForm(request,response);
                break;
            case "delete":
//                showDeleteForm(request,response);
                break;
            case "view":
//                viewProducts(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        IProductService iProductService = new ProductServiceImpl();
        List<Product> productList = iProductService.getList();
        request.setAttribute("productLists", productList);
        try {
            request.getRequestDispatcher("/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

