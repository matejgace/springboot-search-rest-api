package mg.java.springbootsearchrestapi.service;

import mg.java.springbootsearchrestapi.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
