package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;

import java.util.List;

/**
 * Created by User on 01.09.2016.
 */
public class ProductDaoImpl1 implements ProductDao {
    public Long addProduct(Product product) {
        System.out.println("Impl2");
        return null;
    }
    public void updateProduct (Product product) {

    }
    public Product getProduct(Long productId) {
        return null;
    }
    public void deleteProduct (Long productId) {

    }
    public List<Product> findProduct () {
        return null;
    }
}
