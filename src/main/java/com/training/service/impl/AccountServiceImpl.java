package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.AccountDTO;
import com.training.entity.Account;
import com.training.mapper.AccountMapper;
import com.training.repository.AccountRepository;
import com.training.service.AccountService;
import com.training.utils.EncryptedPasswordUtils;
import com.training.utils.S3Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    EncryptedPasswordUtils changePasswordToEncryptedPassword;

    @Override
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts == null || accounts.size() == 0 ? new ArrayList<>()
                : accounts.stream().map(item -> accountMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account != null && account.isPresent() ? accountMapper.convertEntityToDTO(account.get())
                : new AccountDTO();
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        if (accountDTO == null) return new AccountDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        accountDTO.setAccountUuid(uuid.toString());

        String password = changePasswordToEncryptedPassword.encryptedPassword(accountDTO.getEncryptedPassword());
        accountDTO.setEncryptedPassword(password);

        String endpointUrl = ".s3.ap-southeast-1.amazonaws.com";
        String accessKey = "AKIA2OF4S3RX2ATER4PL";
        String secretKey = "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";
        String bucketName = "java-mock-project-2023";
        File file = new File("E:\\research\\download.jpg");
        String fileName = String.valueOf(System.currentTimeMillis()) + "_" + file.getName();
        String fileUrl = "https://" + bucketName + endpointUrl + "/" + fileName;
        try {
            S3Utils.uploadFileTos3bucket(accessKey, secretKey, bucketName, fileName, file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        accountDTO.setAccountImgPath(fileUrl);
        accountDTO.setAccountImg(fileName);

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
            Optional<Account> account = accountRepository.findById(accountDTO.getId());
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

//    @Override
//    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
//        Principal principal = new Principal();
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        String roleNames = accountRepository.getRoleNames();
//
//    }
}
