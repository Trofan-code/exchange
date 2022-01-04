package com.example.Exchange.service;


import com.example.Exchange.persistance.entity.AccountEntry;
import com.example.Exchange.persistance.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
//Написать клиент и сервер со следующими возможностями:
//1. ввод пароля;
//2. смена пароля;
//3. просмотр счетов; +
//4. просмотр остатка на счету; +
//5. снятие денег;
//6. обмен валют между счетами.

@Service
public class AccountService {
    private Long temp = 1L;

    @PostConstruct
    public void init() {
        accountRepository.findAll();
    }

    @Autowired
    private AccountRepository accountRepository;
    private AccountEntry accountEntry;

    public List<AccountEntry> getViewBankInfo() {
        return accountRepository.findAll();
    }

    public BigDecimal getBalance(Long id) {
        return findBalanceById(id).getBalance();
    }

    public AccountEntry withdrawMoney(AccountEntry accountEntryPost) {
        return operationWithWithdrawMoney(findBalanceById(accountEntryPost.getId()));
    }

    //------------------------------------------------------------------
    private AccountEntry findBalanceById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    private AccountEntry operationWithWithdrawMoney(AccountEntry accountEntryPost) {
        BigDecimal newBalance = accountEntry.getBalance().subtract(accountEntryPost.getBalance()).setScale(2, RoundingMode.HALF_UP);
        accountEntryPost.setBalance(newBalance);
        return accountEntryPost;
    }


}
