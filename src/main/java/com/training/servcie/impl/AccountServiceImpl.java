package com.training.servcie.impl;
import com.training.dto.AccountDTO;
import com.training.entity.Account;
import com.training.mapper.AccountMapper;
import com.training.repository.AccountRepository;
import com.training.servcie.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts == null || accounts.size() == 0 ? new ArrayList<>()
                : accounts.stream().map(item -> accountMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO findById(Long id) {
        Optional<Account> accounts = accountRepository.findById(id);
        return accounts != null && accounts.isPresent() ? accountMapper.convertEntityToDTO(accounts.get())
                : new AccountDTO();
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        if (accountDTO == null) return new AccountDTO();
        Account account = accountRepository.save(accountMapper.convertDTOToEntity(accountDTO));
        return account == null ? new AccountDTO() : accountMapper.convertEntityToDTO(account);
    }

    @Override
    public int update(AccountDTO accountDTO) {
        if (accountDTO == null || accountDTO.getId() == null) return -1;
        Optional<Account> account = accountRepository.findById(accountDTO.getId());
        if (account != null && account.isPresent()) {
            //update
            Account accountUpdate = accountRepository.save(accountMapper.convertDTOToEntity(accountDTO));
            return accountUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(AccountDTO accountDTO) {
        try {
            if (accountDTO == null || accountDTO.getId() == null) return false;
            Optional<Account> account  = accountRepository.findById(accountDTO.getId());
            if (account != null && account.isPresent()) {
                //delete
                accountRepository.delete(account.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
