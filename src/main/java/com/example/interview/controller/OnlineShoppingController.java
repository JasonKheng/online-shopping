package com.example.interview.controller;

import com.example.interview.model.Product;
import com.example.interview.service.ProductService;
import com.example.interview.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/interview")
public class OnlineShoppingController {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD_HASH = "741f67765bef6f01f37bf5cb1724509a83409324efa6ad2586d27f4e3edea296"; //"hashedpassword"

    @Autowired
    private ProductService productService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password) throws NoSuchAlgorithmException {
        if (ADMIN_USERNAME.equals(username) && SecurityUtil.hashPassword(password).equals(ADMIN_PASSWORD_HASH)) {
            return "success";
        }

        return "failed";
    }

    @GetMapping("/product")
    public String showProductPage() {
        return "product";
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public Product addProduct(@RequestParam String name, @RequestParam String price) throws Exception {
        Product result = productService.addProduct(name, price);
        System.out.println("Product Added Successfully, ID: "  + result.getId());
        return result;
    }

    @PostMapping("/listProduct")
    public String listProduct(Model model) throws Exception {
        List<Product> products =  productService.getAllProducts();
        products.stream().forEach(item -> {
            try {
                item.setPrice(SecurityUtil.decryptPrice(item.getPrice()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        model.addAttribute("products", products);
        return "list";
    }

    @PostMapping("/updateProduct")
    @ResponseBody
    public Product updateProduct(@RequestParam Long id, @RequestParam String name, @RequestParam String price) throws Exception {
        Product result = productService.updateProduct(id, name, price);
        System.out.println("Product Updated Successfully");
        return result;
    }

    @PostMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "Product Deleted Successfully";
    }
}
