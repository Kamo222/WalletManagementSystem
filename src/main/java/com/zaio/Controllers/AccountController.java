package com.zaio.Controllers;

import com.zaio.DTO.AccountRequestDTO;
import com.zaio.Entity.Account;
import com.zaio.MessageHandling.UserNotFoundException;
import com.zaio.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /* write your function for @PostMapping("/create-account") annotation maps the method createAccount to handle
    HTTP POST requests with the "/api/create-account endpoint ( Updating your Previous One ) */
    @PostMapping("/create-account")
    public Object createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
    	return accountService.saveAccount(accountRequestDTO);
    	//return "Successful";
    }
    
    @GetMapping("/getAccount/{id}")
    public Object getAccountByUserName(@PathVariable Long id) {
    	
    	
    	return accountService.getAccountByUser(id);
    }
}


