package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Iphone13", "Dien thoai", 1));
        productList.add(new Product(2, "Macbook", "laptop", 1));
        productList.add(new Product(3, "airpods", "tai nghe", 1));
    }


    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }
}
