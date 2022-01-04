package com.example.Exchange.controller;


import com.example.Exchange.persistance.entity.AccountEntry;
import com.example.Exchange.service.AccountService;
import com.sun.istack.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;


@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping( "/item" )
    public String getStockItem() {
        return "It's working...!";
    }

    @GetMapping("/accounts")
    public List<AccountEntry> getViewBankInfo(){
        return accountService.getViewBankInfo();
    }

    @GetMapping("/accounts/{id}/balance")
    public BigDecimal getBalanceInfo( @PathVariable @NotNull Long id){
        return accountService.getBalance(id);
    }
    @PostMapping("/postbody")
    public String postBody(@RequestBody AccountEntry accountEntry ) {
        return "Hello balance " + accountService.getBalance(accountEntry.getId());
    }
    @PostMapping("/account/withdraw")
    public AccountEntry withdrawMoney(@RequestBody AccountEntry accountEntry ){
        return accountService.withdrawMoney(accountEntry);
    }
    //@RequestMapping(value = "/test", method =   RequestMethod.POST)
    //	public PostResponse Test(@RequestBody PostRequest inputPayload) {
    //		PostResponse response = new PostResponse();
    //		response.setId(inputPayload.getId()*100);
    //		response.setMessage("Hello " + inputPayload.getName());
    //		response.setExtra("Some text");
    //		return response;
    //	}

}
