package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone", "dien thoai", "1000"));
        productList.add(new Product(2, "samsung", "dien thoai", "500"));
        productList.add(new Product(3, "LG", "dien thoai", "300"));
    }

    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return getList().stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(Product product) {
        productList.remove(product);
    }

    @Override
    public void editProduct(Product product) {
        System.out.println(product);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(product.getId())) {
                productList.set(i, product);
                System.out.println(productList.get(i));
                break;
            }
        }
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        List<Product> searchProductList = new ArrayList<>();
        for (Product product : productList) {
            if ((product.getName()).toLowerCase().contains(keyword.toLowerCase())) {
                searchProductList.add(product);
            }
        }
        return searchProductList;
    }
}
