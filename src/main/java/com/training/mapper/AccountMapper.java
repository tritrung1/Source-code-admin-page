package com.training.mapper;

import com.training.dto.AccountDTO;
import com.training.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper extends AbstractMapper<Account, AccountDTO> {
    public AccountMapper() {
        super(Account.class, AccountDTO.class);
    }
}
