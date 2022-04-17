package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    void add(Product product);

    Product findById(int id);

    void remove(Product product);

    void editProduct(Product product);

    List<Product> searchProduct(String keyword);
}
