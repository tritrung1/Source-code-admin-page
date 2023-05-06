package com.training.service;

import com.training.dto.AccountDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AccountService extends BaseService<AccountDTO>{
//    public UserDetails loadUserByUsername (String accountName) throws UsernameNotFoundException;
}
