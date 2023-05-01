package com.training.controller;
import com.training.dto.*;
import com.training.entity.Post;
import com.training.entity.Product;
import com.training.mapper.ProductMapper;
import com.training.service.*;
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
    @Autowired
    PriceService priceService;
    @Autowired
    ImportService importService;
    @Autowired
    PostService postService;
    @Autowired
    ProductMapper productMapper;

    @GetMapping("/login")
    public String login() {
        return "login_file";
    }

    @RequestMapping(value = {"/", "/index"})
    public String getInit(Model model) {
        model.addAttribute("direction", "container/init");
        return "index";
    }

    @RequestMapping("/products")
    public String products(Model model) {
        model.addAttribute("direction", "container/products");

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
        model.addAttribute("direction", "container/accounts");
        model.addAttribute("accountList", accounts);
        return "index";
    }

    @PostMapping("/update-account")
    public String updateAccount(@ModelAttribute("accountDTO") AccountDTO accountDTO) {
        accountService.save(accountDTO);
        return "redirect:/accounts";
    }

    @GetMapping(value = "/update-account-form/{id}")
    public String updateAccountForm(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("direction", "container/update-account");

        AccountDTO accountDTO = accountService.findById(id);

        model.addAttribute("accountDTO", accountDTO);
        return "index";
    }
    @PostMapping(value = "/create-account")
    public String createAccount(@ModelAttribute("accountDTO") AccountDTO accountDTO) {
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
    public String deleteAccount(@PathVariable(value = "id") Long id) {
        AccountDTO createAccount = accountService.findById(id);
        accountService.delete(createAccount);
        return "redirect:/accounts";
    }

    @GetMapping("/post-manage")
    public String postManage(Model model) {
        model.addAttribute("direction", "container/post-manage");
        List<PostDTO> postDTOs = postService.findByStatusEqualsIgnoreCase();
        model.addAttribute("listPost", postDTOs);

        return "index";
    }

    @GetMapping("/post-manage/approved/{id}")
    public String acceptPost(@PathVariable Long id) {
        PostDTO postDTO = postService.findById(id);
        postDTO.setStatus("approved");
        postService.save(postDTO);
        return "redirect:/post-manage";
    }

    @PostMapping("/post-manage/rejected/{id}")
    public String rejectPost(@PathVariable Long id, @RequestParam String rejectMsg) {
        PostDTO postDTO = postService.findById(id);
        postDTO.setReason(rejectMsg);
        postDTO.setStatus("rejected");
        postService.save(postDTO);
        return "redirect:/post-manage";
    }

    @RequestMapping("/order-list-manage")
    public String orderList(Model model) {
        model.addAttribute("direction", "container/order-list-manage");
        model.addAttribute("orders", orderService.findAll());
        return "index";
    }

    @RequestMapping("/notification-manage")
    public String notification(Model model) {
        model.addAttribute("direction", "container/notification-manage");

        List<NotificationDTO> notifications = notificationService.findAll();
        model.addAttribute("notifications", notifications);

        return "index";
    }


    @GetMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("direction","container/add-product");
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productForm", productDTO);

        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "index";
    }
    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute("productForm") ProductDTO productDTO) {
        productDTO = productService.save(productDTO);

        //save price in same time with product
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductCode(productDTO.getProductCode());
        priceDTO.setPrice(productDTO.getPrice());
        priceService.save(priceDTO);
        //save import in same time with product
        ImportDTO importDTO = new ImportDTO();
        importDTO.setProductCode(productDTO.getProductCode());
        importDTO.setImportQuantity(productDTO.getImportQuantity());
        importService.save(importDTO);

        //save Post
        PostDTO postDTO = new PostDTO();
        postDTO.setProduct(productMapper.convertDTOToEntity(productDTO));
        postDTO.setStatus("pending");
        postService.save(postDTO);

        return "redirect:/products";
    }

    @GetMapping("/edit-product/{id}")
    public String editProduct(Model model, @PathVariable(value ="id") Long id) {
        model.addAttribute("direction", "container/edit-product");
        ProductDTO productDTO = productService.findById(id);
        model.addAttribute("editProductForm", productDTO);
        model.addAttribute("pageTitle", "Edit Product " + productDTO.getProductName() );

        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "index";
    }

    @PostMapping("/save-edit-product")
    public String saveProduct(Model model, @ModelAttribute("productDTO") ProductDTO productDTO, @RequestParam Long id) {
        model.addAttribute("pageTitle", "Edit Product " + productDTO.getProductName());
        productService.save(productDTO);
        ProductDTO check = productService.findById(id);
        if (Double.compare(productDTO.getPrice(), check.getPrice()) != 0) {
            //save price in same time with product
            PriceDTO priceDTO = new PriceDTO();
            priceDTO.setProductCode(productDTO.getProductCode());
            priceDTO.setPrice(productDTO.getPrice());
            priceService.save(priceDTO);
        }
        if (Double.compare(productDTO.getImportQuantity(), check.getImportQuantity()) != 0) {
            //save import in same time with product
            ImportDTO importDTO = new ImportDTO();
            importDTO.setProductCode(productDTO.getProductCode());
            importDTO.setImportQuantity(productDTO.getImportQuantity());
            importService.save(importDTO);
        }
        return "redirect:/products";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable(value ="id") Long id) {
        ProductDTO productDTO = productService.findById(id);
        productService.delete(productDTO);
        return "redirect:/products";
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable(value ="id") Long id) {
        CategoryDTO categoryDTO = categoryService.findById(id);
        categoryService.delete(categoryDTO);
        return "redirect:/products";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("direction", "container/news");

        List<NewsDTO> news = newsService.findAll();
        model.addAttribute("news", news);

        return "index";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String showListFeedback(Model model) {
        List<FeedbackDTO> feedbackDTOs = feedbackService.findByStatus();
        model.addAttribute("direction", "container/feedback");
        model.addAttribute("feedbacks", feedbackDTOs);
        return "index";
    }

    @RequestMapping(value = "/answer-feedback", method = RequestMethod.POST)
    public String saveAnswer(@RequestParam Long id, @RequestParam String reply) {
        FeedbackDTO feedbackDTO = feedbackService.findById(id);

        feedbackDTO.setActive(false);
        feedbackDTO.setReply(reply);
        feedbackService.save(feedbackDTO);

        return "redirect:/feedback";
    }

}