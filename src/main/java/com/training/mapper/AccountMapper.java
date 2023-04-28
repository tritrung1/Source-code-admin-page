package com.training.mapper;

import com.training.dto.AccountDTO;
import com.training.entity.Account;
import org.springframework.stereotype.Service;

@Service
<<<<<<< Updated upstream
public class AccountMapper extends AbstractMapper<Account, AccountDTO> {
    public AccountMapper() {
=======
public class AccountMapper extends AbstractMapper<Account, AccountDTO>{
    public AccountMapper(){
>>>>>>> Stashed changes
        super(Account.class, AccountDTO.class);
    }
}
