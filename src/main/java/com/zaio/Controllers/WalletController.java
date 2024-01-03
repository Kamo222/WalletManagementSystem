package com.zaio.Controllers;

import com.zaio.DTO.WalletRequestDTO;
import com.zaio.Service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    /* write your function for @PostMapping("/create-wallet") annotation maps the method createWallet to handle
    HTTP POST requests with the "/api/create-wallet" endpoint */
    
    @PostMapping("/create-wallet")
    public Object createWallet(@RequestBody WalletRequestDTO walletRequestDTO) {
    	
    	
    	return walletService.createWallet(walletRequestDTO);
    }
}
