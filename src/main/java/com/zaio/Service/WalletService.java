package com.zaio.Service;

import com.zaio.DTO.WalletRequestDTO;
import com.zaio.Entity.Account;
import com.zaio.Entity.Wallet;
import com.zaio.MessageHandling.Response;
import com.zaio.Repositories.WalletRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    private final AccountService accountService;

    public WalletService(WalletRepository walletRepository, AccountService accountService) {
        this.walletRepository = walletRepository;
        this.accountService = accountService;
    }

    /* write your method for saveWallet in database with return type Object because you need to check whether Account exist or not in database
    if Account exist return new WalletRequestDTO else response error .*/

    // Tip :  You Need to Create method in AccountService *accountService.findById(walletRequestDTO.getAccountId())* to get Account Optional.
    public Object createWallet(WalletRequestDTO walletRequestDTO) {
    	
    	if(accountService.findById(walletRequestDTO.getAccountId()).isPresent()) {
    		
    		Wallet newWallet = new Wallet(walletRequestDTO.getWalletId(),
    										walletRequestDTO.getWalletName(),
    										walletRequestDTO.getBalance(),
    										LocalDateTime.now(),
    										null,
    										accountService.findById(walletRequestDTO.getAccountId()).get());
    		walletRepository.save(newWallet);
    		
    		WalletRequestDTO savedWalletRequestDTO = new WalletRequestDTO(
    				newWallet.getWalletid(),
    				newWallet.getWalletName(),
    				newWallet.getBalance(),
    				newWallet.getAccount().getAccountId());
    		
    		return savedWalletRequestDTO;
    	} else {
    		return new Response("Account does not exist");
    	}
    }
}
