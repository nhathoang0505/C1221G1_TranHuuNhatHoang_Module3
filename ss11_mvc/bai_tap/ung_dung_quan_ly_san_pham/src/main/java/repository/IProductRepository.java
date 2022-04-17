package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepository extends ICrudProduct<Product> {

    void save(Product product);
}
