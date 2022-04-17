package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> getList() {
        List<Product> productList = iProductRepository.getList();
        return productList;
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }
}
