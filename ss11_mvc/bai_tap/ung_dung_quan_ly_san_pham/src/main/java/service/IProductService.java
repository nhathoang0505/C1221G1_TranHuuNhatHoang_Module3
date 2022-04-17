package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    void save(Product product);
}
