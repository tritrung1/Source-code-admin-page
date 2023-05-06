package com.training.service;

import com.training.entity.Account;
import com.training.repository.Login;
import com.training.service.impl.AccountServiceImpl;
import com.training.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private Login login;

    @Override
    public UserDetails loadUserByUsername (String accountName) throws UsernameNotFoundException {
        Account account = this.login.findUserAccount(accountName);

        if (account == null) {
            System.out.println("Account Not Found!" + accountName);
            throw new UsernameNotFoundException("Account" + accountName + "was not found in database");
        }

        System.out.println("Found account: " + account);

        // ROLE_LEADER, ROLE_SUPPLIER, ROLE_ADMIN,...
        List<String> roleNames = this.login.getRoleNames(account.getId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(account.getAccountName(), account.getEncryptedPassword(), grantList);

        return userDetails;
    }

}
