package sf.crom.dhawanspringmvc.dhawanspringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Product;
import sf.crom.dhawanspringmvc.dhawanspringmvc.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public String getListOfProducts(Model model) {
        List<Product> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "product";

    }

    @RequestMapping("/product/{Id}")
    public String getProductById(@PathVariable Integer Id, Model model) {
        model.addAttribute("products", productService.getProductById(Id));
        return "product";
    }

    @RequestMapping("/product/new")
    public String createNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "newProduct";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        Product savedproduct = productService.saveOrUpdateProduct(product);
        return "redirect:/product/" + savedproduct.getId();
    }

    @RequestMapping("/product/edit/{Id}")
    public String updateProduct(@PathVariable Integer Id, Model model) {
        model.addAttribute("product", productService.getProductById(Id));
        return "newProduct";
    }

    @RequestMapping("/product/delete/{Id}")
    public String deleteProduct(@PathVariable Integer Id, Model model) {
        model.addAttribute("products", productService.deleteProduct(Id));
        return "product";
    }

}
