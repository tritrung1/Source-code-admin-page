package com.training.controller;

import com.training.dto.CategoryDTO;
import com.training.dto.NewsDTO;
import com.training.dto.NotificationDTO;
import com.training.dto.ProductDTO;
import com.training.service.CategoryService;
import com.training.service.NewsService;
import com.training.service.NotificationService;
import com.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    NewsService newsService;
    @Autowired
    NotificationService notificationService;
    @GetMapping("/login")
    public String login() {
        return "login_file";
    }

    @RequestMapping(value = {"/", "/index"})
    public String getInit(Model model) {
        model.addAttribute("direction","container/init");
        return "index";
    }

    @RequestMapping("/products")
    public String products(Model model) {
        model.addAttribute("direction","container/products");

        List<ProductDTO> products = productService.findAll();
        model.addAttribute("products", products);

        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        return "index";
    }

    @RequestMapping("/accounts")
    public String accounts(Model model) {
        model.addAttribute("direction","container/accounts");
        return "index";
    }

    @RequestMapping("/post-manage")
    public String postManage(Model model) {
        model.addAttribute("direction","container/post-manage");
        return "index";
    }

    @RequestMapping("/order-list-manage")
    public String orderList(Model model) {
        model.addAttribute("direction","container/order-list-manage");
        return "index";
    }

    @RequestMapping("/notification-manage")
    public String notification(Model model) {
        model.addAttribute("direction","container/notification-manage");

        List<NotificationDTO> notifications = notificationService.findAll();
        model.addAttribute("notifications", notifications);

        return "index";
    }

    @RequestMapping("/create-account")
    public String createAccount(Model model) {
        model.addAttribute("direction","container/create-account");
        return "index";
    }

    @GetMapping("/update-account")
    public String updateAccount(Model model) {
        model.addAttribute("direction", "container/update-account");
        return "index";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("direction","container/add-product");
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO", productDTO);
        return "index";
    }
    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute("productDTO") ProductDTO productDTO) {
        productService.save(productDTO);
        return "redirect:/products";
    }

    @GetMapping("/edit-product")
    public String editProduct(Model model) {
        model.addAttribute("direction", "container/edit-product");
        return "index";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable(value ="id") Long id) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productService.delete(productDTO);
        return "redirect:/products";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("direction", "container/news");

        List<NewsDTO> news = newsService.findAll();
        model.addAttribute("news", news);

        return "index";
    }
}