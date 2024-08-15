package com.admin.service;

import com.admin.model.Product;

import java.util.*;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Laptop", 1000.0, "High-performance laptop", "Dell"));
        products.put(2, new Product(2, "Smartphone", 700.0, "Latest model smartphone", "Samsung"));
        products.put(3, new Product(3, "Headphones", 150.0, "Noise-cancelling headphones", "Sony"));
        products.put(4, new Product(4, "Monitor", 300.0, "24-inch 4K monitor", "LG"));
        products.put(5, new Product(5, "Keyboard", 50.0, "Mechanical keyboard", "Corsair"));
        products.put(6, new Product(6, "Mouse", 40.0, "Wireless mouse", "Logitech"));
        products.put(7, new Product(7, "Smartwatch", 250.0, "Water-resistant smartwatch", "Apple"));
        products.put(8, new Product(8, "Tablet", 500.0, "10-inch tablet", "Microsoft"));
        products.put(9, new Product(9, "Printer", 200.0, "Laser printer", "HP"));
        products.put(10, new Product(10, "Camera", 1200.0, "DSLR camera", "Canon"));
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
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product searchByName(String name) {
        for (Product product : products.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}
