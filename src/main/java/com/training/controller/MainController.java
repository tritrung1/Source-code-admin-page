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
        model.addAttribute("direction","components/init");
        return "index";
    }

    @RequestMapping("/products")
    public String products(Model model) {
        model.addAttribute("direction","components/product");
        return "index";
    }

    @RequestMapping("/accounts")
    public String accounts(Model model) {
        model.addAttribute("direction","components/accounts");
        return "index";
    }

    @RequestMapping("/post-manage")
    public String postManage(Model model) {
        model.addAttribute("direction","components/post-manage");
        return "index";
    }

    @RequestMapping("/order-list-manage")
    public String orderList(Model model) {
        model.addAttribute("direction","components/order-list-manage");
        return "index";
    }

    @RequestMapping("/notification-manage")
    public String notification(Model model) {
        model.addAttribute("direction","components/notification-manage");
        return "index";
    }

    @RequestMapping("/create-account")
    public String createAccount(Model model) {
        model.addAttribute("direction","components/accounts");
        return "index";
    }

    @RequestMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("direction","components/add-product");
        return "index";
    }

}
