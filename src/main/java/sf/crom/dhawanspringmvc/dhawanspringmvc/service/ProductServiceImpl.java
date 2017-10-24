package sf.crom.dhawanspringmvc.dhawanspringmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Product;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    HashMap<Integer, Product> products;

    ProductServiceImpl() {
        initProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer Id) {
        return products.get(Id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        if (!product.getDescription().isEmpty()) {
            if (product.getId() == null) {
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);
            return product;
        } else {
            throw new RuntimeException("Product cannot be null");
        }

    }

    @Override
    public List<Product> deleteProduct(Integer Id) {
        Product deleteProduct = products.get(Id);
        if (deleteProduct != null) {
            products.remove(Id);
            return new ArrayList<>(products.values());
        } else {
            throw new RuntimeException("Cannot delete anything that does not exists");
        }
    }

    public Integer getNextKey() {
        return Collections.max(products.keySet()) + 1;
    }

    public void initProducts() {
        products = new HashMap<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setPrice(BigDecimal.valueOf(1.1));
        p1.setDescription("First Product");
        p1.setImageURL("/first product");

        Product p2 = new Product();
        p2.setId(2);
        p2.setPrice(BigDecimal.valueOf(2.2));
        p2.setDescription("Second Product");
        p2.setImageURL("/second product");

        Product p3 = new Product();
        p3.setId(3);
        p3.setPrice(BigDecimal.valueOf(3.3));
        p3.setDescription("Third Product");
        p3.setImageURL("/third product");

        Product p4 = new Product();
        p4.setId(4);
        p4.setPrice(BigDecimal.valueOf(4.4));
        p4.setDescription("Four Product");
        p4.setImageURL("/fourth product");

        products.put(1, p1);
        products.put(2, p2);
        products.put(3, p3);
        products.put(4, p4);

    }


}
