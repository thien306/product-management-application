package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        DecimalFormat df = new DecimalFormat("#,###.##");

        // Định dạng giá của từng sản phẩm
        for (Product product : productList) {
            product.setPriceFormatted(df.format(product.getPrice()));
        }

        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        product.setId((long) (Math.random() * 1000));
        productService.save(product);
        redirectAttributes.addAttribute("success", "New product added successfully");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String updateProduct(@PathVariable long id, Model model) {
        Product product = productService.findById(id);
        DecimalFormat df = new DecimalFormat("#,###.##");
        product.setPriceFormatted(df.format(product.getPrice()));
        model.addAttribute("product", product);
        return "/update";
    }


    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes) {
        // Chuyển đổi priceFormatted thành price
        try {
            DecimalFormat df = new DecimalFormat();
            product.setPrice(df.parse(product.getPriceFormatted()).doubleValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        productService.update(product.getId(), product);
        redirectAttributes.addAttribute("success", "Product update successful");
        return "redirect:/products";
    }


    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addAttribute("success", "Product deletion successful");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String ShowProduct(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.findByName(name));
        model.addAttribute("name", name);
        return "/index";
    }

}
