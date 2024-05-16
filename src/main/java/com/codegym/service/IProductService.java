package com.codegym.service;


import com.codegym.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(long id);

    List<Product> findByName(String name);

    void update(long id, Product product);

    void remove(long id);
}
