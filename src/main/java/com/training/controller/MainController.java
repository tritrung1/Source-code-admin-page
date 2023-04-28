package com.training.controller;
import com.training.dto.CategoryDTO;
import com.training.dto.NewsDTO;
import com.training.dto.NotificationDTO;
import com.training.dto.ProductDTO;
import com.training.service.*;
import com.training.dto.OrderDTO;
import com.training.dto.AccountDTO;
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
    @Autowired
    AccountService accountService;
    @Autowired
    OrderService orderService;
    @Autowired
    FeedbackService feedbackService;

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
    // start account
    @GetMapping("/accounts")
    public String accounts(Model model) {
        List<AccountDTO> accounts = accountService.findAll();
        model.addAttribute("direction","container/accounts");
        model.addAttribute("accountList", accounts );
        return "index";
    }

    @PostMapping("/update-account")
    public String updateAccount(@ModelAttribute("accountDTO")AccountDTO accountDTO) {
        accountService.save(accountDTO);
        return "redirect:/accounts";
    }

    @GetMapping (value = "/update-account-form/{id}")
    public String updateAccountForm(Model model, @PathVariable(value ="id") Long id)  {
        model.addAttribute("direction", "container/update-account");

        AccountDTO accountDTO = accountService.findById(id);

        model.addAttribute("accountDTO", accountDTO);
        return "index";
    }
    @PostMapping(value = "/create-account")
    public String createAccount(@ModelAttribute("accountDTO")AccountDTO accountDTO) {
        accountService.save(accountDTO);
        return "redirect:/accounts";
    }

    @GetMapping(value = "/create-account-form")
    public String createAccountForm(Model model) {
        model.addAttribute("direction", "container/create-account");
        AccountDTO accountDTO = new AccountDTO();
        model.addAttribute("accountDTO", accountDTO);
        return "index";
    }

    @RequestMapping(value = "/delete-account/{id}")
    public String deleteAccount(@PathVariable(value ="id") Long id) {
        AccountDTO createAccount = accountService.findById(id);
        accountService.delete(createAccount);
        return "redirect:/accounts";
    }

    // end account
    @RequestMapping("/post-manage")
    public String postManage(Model model) {
        model.addAttribute("direction","container/post-manage");
        return "index";
    }

    @RequestMapping("/order-list-manage")
    public String orderList(Model model) {
        model.addAttribute("direction","container/order-list-manage");
        model.addAttribute("orders", orderService.findAll());
        return "index";
    }

    @RequestMapping("/notification-manage")
    public String notification(Model model) {
        model.addAttribute("direction","container/notification-manage");

        List<NotificationDTO> notifications = notificationService.findAll();
        model.addAttribute("notifications", notifications);

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

    @RequestMapping(value = "/detailFeedback", method = RequestMethod.GET)
    public String showUpdateForm(Model model, @RequestParam Long orderId) {
        OrderDTO order = orderService.findById(orderId);
        model.addAttribute("order",order);
        model.addAttribute("direction", "container/feedback");
        model.addAttribute("feedbacks", feedbackService.findAll());
        return "index";
    }

//    @RequestMapping(value = "/detailFeedback", method = RequestMethod.GET)
//    public String showUpdateForm(Model model, @RequestParam Long orderId) {
//        OrderDTO order = orderService.findById(orderId);
//        model.addAttribute("order",order);
//        model.addAttribute("direction", "container/feedback");
//        model.addAttribute("feedbacks", feedbackService.findAll());
//        return "index";
//    }

//    @RequestMapping(value = "/detailFeedback", method = RequestMethod.GET)
//    public String showUpdateForm(Model model, @RequestParam Long orderId) {
//        OrderDTO order = orderService.findById(orderId);
//        model.addAttribute("order",order);
//        model.addAttribute("direction", "container/feedback");
//        model.addAttribute("feedbacks", feedbackService.findAll());
//        return "index";
//    }
}