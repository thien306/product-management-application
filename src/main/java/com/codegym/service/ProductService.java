package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductService implements IProductService {

    private static final Map<Long, Product> products;

    static {
        products = new HashMap<>();
        products.put(1L, new Product(1, "iphone 15 pro max", 44990000, "điện thoại iphone 15 pro max 1TB"));
        products.put(2L, new Product(2, "iphone 15 pro max", 37990000, "điện thoại iphone 15 pro max 512GB"));
        products.put(3L, new Product(3, "iphone 15 pro max", 30990000, "điện thoại iphone 15 pro max 256GB"));
        products.put(4L, new Product(4, "iphone 15 pro", 41890000, "điện thoại iphone 15 pro 1TB"));
        products.put(5L, new Product(5, "iphone 15 pro", 44990000, "điện thoại iphone 15 pro 512GB"));
        products.put(6L, new Product(6, "iphone 15 pro", 44990000, "điện thoại iphone 15 pro 256GB"));
        products.put(7L, new Product(7, "iphone 15 pro", 44990000, "điện thoại iphone 15 pro 128GB"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(long id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }


    @Override
    public void update(long id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(long id) {
        products.remove(id);
    }
}
