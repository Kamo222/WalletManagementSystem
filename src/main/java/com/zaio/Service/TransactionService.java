package com.zaio.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaio.DTO.TransactionRequestDTO;
import com.zaio.Entity.Transaction;
import com.zaio.Repositories.TransactionRepository;

@Service
public class TransactionService {
	
	private TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}
	
	public Transaction findTransaction(Long id) {
		return transactionRepository.findById(id).get();
	}
	
	public List<Transaction> findAllTransaction(Long id) {
		return transactionRepository.findAll();
	}
	
	public Boolean transferMoney(TransactionRequestDTO transactionRequestDTO) {
		
		
		return true;
	}
	
	
}
