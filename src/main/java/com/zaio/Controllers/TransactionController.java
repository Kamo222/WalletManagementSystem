package com.zaio.Controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.zaio.DTO.TransactionRequestDTO;
import com.zaio.MessageHandling.Response;
import com.zaio.Service.TransactionService;

@RestController
public class TransactionController {
	
	private TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
	
	@PostMapping("/api/transfer-money")
	public String transferMoney(@RequestBody TransactionRequestDTO transactionRequestDTO) {
		
		
		return "Money Transfer Successful";
	}
	
	@GetMapping("/api/done")
	public Object endPoint() {
		return new Response("done");
	}
}
