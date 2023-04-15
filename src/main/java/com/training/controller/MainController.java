package com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

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

    @RequestMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("direction","container/add-product");
        return "index";
    }

    @GetMapping("/edit-product")
    public String editProduct(Model model) {
        model.addAttribute("direction", "container/edit-product");
        return "index";
    }
}
