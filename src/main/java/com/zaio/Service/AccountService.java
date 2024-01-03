package com.zaio.Service;

import com.zaio.DTO.AccountDTO;
import com.zaio.DTO.AccountRequestDTO;
import com.zaio.DTO.UserDTO;
import com.zaio.DTO.WalletDTO;
import com.zaio.Entity.Account;
import com.zaio.Entity.User;
import com.zaio.Entity.Wallet;
import com.zaio.MessageHandling.Response;
import com.zaio.MessageHandling.UserNotFoundException;
import com.zaio.Repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final UserService userService;

    public AccountService(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    /* write your function for saveAccount in database with return type Object because you need to check whether user exist or not in database
    if user exist return new AccountRequestDTO else response error (Copy and Paste Previous one and Update it with the requirments)*/
    
    public Optional<Account> findById(Long id){
    	return accountRepository.findById(id);
    }
    
    public Object saveAccount(AccountRequestDTO accountRequestDTO) {
    	
    	if(accountRepository.findById(accountRequestDTO.getAccountId()).isPresent()) {
    		return new Response("Account Exists");
    	} else {
    		if(userService.findById(accountRequestDTO.getUserId()).isPresent()) {
    			Account newAccount = new Account(accountRequestDTO.getAccountId(),
						accountRequestDTO.getAccountName(),
						LocalDateTime.now(), null,
						userService.findById(accountRequestDTO.getUserId()).get(),
						null,
						new BigDecimal(0));
    					
    					Account savedAccount = accountRepository.save(newAccount);
    					
    					AccountRequestDTO savedAccountRequest = new AccountRequestDTO(savedAccount.getAccountId(),
    																				savedAccount.getAccountName(),
    																				savedAccount.getUser().getUserId());
    			return savedAccountRequest;
    		} else {
    			return new Response("User does not exist");
    		}
    		
    		
    	}
    }
    
    public Object getAccountByUser(Long userId) {
    	if(accountRepository.findById(userId).isPresent()) {
    		Account account = accountRepository.findById(userId).get();
    		User user = userService.findById(account.getUser().getUserId()).get();
    		UserDTO userDTO = new UserDTO(user.getUserId(), user.getUsername(), user.getEmail(), user.getPhoneNumber());
    		List <WalletDTO> walletDTO = account
    				.getWallets()
    				.stream()
    				.map( wallet -> new WalletDTO(wallet.getWalletid(),wallet.getWalletName(), wallet.getBalance()))
    				.toList();
    				//new WalletDTO(
    				//private Long walletId;
    				//private String walletName;
    				//private BigDecimal balance;
    				//);
    		
    						
    		AccountDTO foundAccount = new AccountDTO(
    				account.getAccountId(),
    				account.getAccountName(),
    				account.getTotalAmount(),
    				walletDTO,
    				userDTO
    				);
    		return foundAccount;
    	}
    	
    	return new Response("Account doesn't exist");
    }
}
