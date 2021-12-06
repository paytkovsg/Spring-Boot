package ru.gd.springbootapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gd.springbootapp.dto.Product;
import ru.gd.springbootapp.service.ProductService;


@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAll());
        return "Product_list";
    }

    @GetMapping("/info/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "Product_info";
    }


    @GetMapping("/add")
    public String getProductFormAdd(){
        return "Product_form_add";
    }


    @PostMapping("/add")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/all";
    }
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
        return "redirect:/all";
    }
}
