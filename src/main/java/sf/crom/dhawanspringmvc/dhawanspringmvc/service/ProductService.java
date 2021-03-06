package sf.crom.dhawanspringmvc.dhawanspringmvc.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Product;

import java.util.List;


public interface ProductService {
    List<Product> listAllProducts();

    Product getProductById(Integer Id);

    Product saveOrUpdateProduct(Product product);

    List<Product> deleteProduct(Integer Id);
}
