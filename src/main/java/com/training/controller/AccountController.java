package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.AccountDTO;
import com.training.repository.AccountRepository;
import com.training.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    AccountService service;

    @PostMapping(value = ApiPath.ACCOUNT_CREATE)
    public AccountDTO newAccount(@RequestBody AccountDTO newAccount) {
        return service.save(newAccount);
    }

    @GetMapping(value = ApiPath.ACCOUNT_GET_ALL)
    public List<AccountDTO> getAllAccounts() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.ACCOUNT_BY_ID)
    public AccountDTO getAccountById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.ACCOUNT_UPDATE)
    public Integer updateAccount(@RequestBody AccountDTO newAccount) {
        return service.update(newAccount);
    }

    @DeleteMapping(value = ApiPath.ACCOUNT_DELETE)
    public String deleteAccount(@RequestBody AccountDTO newAccount) {
        boolean isDelete = service.delete(newAccount);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}
