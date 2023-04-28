package com.training.controller;
<<<<<<< Updated upstream

import com.training.consts.ApiPath;
import com.training.dto.AccountDTO;
import com.training.repository.AccountRepository;
import com.training.service.AccountService;
=======
import com.training.consts.ApiPath;
import com.training.dto.AccountDTO;
import com.training.repository.AccountRepository;
import com.training.servcie.AccountService;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
<<<<<<< Updated upstream
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
=======
    AccountRepository accountRepository;
    @Autowired
    AccountService accountService;
    @PostMapping(value = ApiPath.ACCOUNT_CREATE)
    public AccountDTO newAccount(@RequestBody AccountDTO newAccount) {
        return accountService.save(newAccount);
    }

    @GetMapping(value = ApiPath.ACCOUNT_GET_ALL)
    public List<AccountDTO> getAllAccount() {
        return accountService.findAll();
>>>>>>> Stashed changes
    }

    @GetMapping(value = ApiPath.ACCOUNT_BY_ID)
    public AccountDTO getAccountById(@PathVariable Long id) {
<<<<<<< Updated upstream
        return service.findById(id);
=======
        return accountService.findById(id);
>>>>>>> Stashed changes
    }

    @PutMapping(value = ApiPath.ACCOUNT_UPDATE)
    public Integer updateAccount(@RequestBody AccountDTO newAccount) {
<<<<<<< Updated upstream
        return service.update(newAccount);
=======
        return accountService.update(newAccount);
>>>>>>> Stashed changes
    }

    @DeleteMapping(value = ApiPath.ACCOUNT_DELETE)
    public String deleteAccount(@RequestBody AccountDTO newAccount) {
<<<<<<< Updated upstream
        boolean isDelete = service.delete(newAccount);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
=======
        boolean isDelete = accountService.delete(newAccount);
        return isDelete ? "Delete success!!!" : "Delete fail!!!";
>>>>>>> Stashed changes
    }
}
