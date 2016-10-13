package ru.sbertech.tradehouse;

import ru.sbertech.tradehouse.business.CustomerManager;
import ru.sbertech.tradehouse.business.CustomerOrderManager;
import ru.sbertech.tradehouse.business.ProductManager;
import ru.sbertech.tradehouse.dao.*;
import ru.sbertech.tradehouse.domain.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anton on 8/29/16.
 */
public class Starter
{
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        ProductDao dao = new ProductDaoImpl();
        pm.setDao(dao);

        for(int i=0; i<10; i++) {
            Product product = new Product();
            product.setProductName("ProductName 0" + i);
            pm.addProduct(product);
        }

        List<Product> result = pm.findProduct();
        for(Product p : result) {
            System.out.println(p.getProductName());
        }

//        CustomerManager cm = new CustomerManager();
//        CustomerDao daoCm = new CustomerDaoImpl();
//        cm.setDao(daoCm);
//        cm.addCustomer(new Customer());

//        Product p = new Product();
//        p.setProductId(99L);
//        p.setProductName("TestProduct_01");
//
//        System.out.println(p);
//
//        Product p1 = new Product();
//        p1.setProductId(199L);
//        p1.setProductName("SuperTestProduct_01");
//        System.out.println(p1);
//
//        Product htp = new HiTechProduct();
//
//        htp.setProductId(888L);
//        htp.setProductName("HiTech Name Product");
//        htp.setPower(120.0);
//        System.out.println(htp.toString());

        CustomerOrder co = new CustomerOrder();
        Customer c = new Customer();
        c.setCustomerId("1");
        co.setCustomer(c);
        co.setCustomerDate(new Date());

        List<CustomerOrderItem> items = new ArrayList<>();
        List<Product> products = pm.findProduct();
        for(Product p : products) {
            CustomerOrderItem item = new CustomerOrderItem();
            item.setCustomerOrder(co);
            item.setProduct(p);
            item.setPrice(99.9);
            item.setQuantity(1);
            items.add(item);
        }
        co.setItems(items);

        CustomerOrderManager com = new CustomerOrderManager();
        com.setDao(new CustomerOrderDaoImpl());
        Long coId = com.addCustomerOrder(co);
        System.out.println(coId);
    }
}
