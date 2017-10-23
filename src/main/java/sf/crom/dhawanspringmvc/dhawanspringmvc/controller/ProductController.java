package sf.crom.dhawanspringmvc.dhawanspringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Product;
import sf.crom.dhawanspringmvc.dhawanspringmvc.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public String getListOfProducts(Model model){
        List<Product> products = productService.listAllProducts();
        model.addAttribute("products",products);
        return "product";

    }
}
