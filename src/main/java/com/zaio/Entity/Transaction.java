package com.zaio.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.zaio.DTO.TransactionType;

@Entity
public class Transaction {
	@Id
	private Long transactionId;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	private Wallet senderWallet;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	private Wallet receiverWallet;
	@Column
	private BigDecimal amount;
	@Column
	private TransactionType transactionType;
	@Column
	private LocalDateTime transactionDate;
	@Column
	private String description;
	
	public Transaction() {
		
	}
	
	public Transaction(Long transactionId, Wallet senderWallet, Wallet receiverWallet, BigDecimal amount,
			TransactionType transactionType, LocalDateTime transactionDate, String description) {
		super();
		this.transactionId = transactionId;
		this.senderWallet = senderWallet;
		this.receiverWallet = receiverWallet;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.description = description;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Wallet getSenderWallet() {
		return senderWallet;
	}

	public void setSenderWallet(Wallet senderWallet) {
		this.senderWallet = senderWallet;
	}

	public Wallet getReceiverWallet() {
		return receiverWallet;
	}

	public void setReceiverWallet(Wallet receiverWallet) {
		this.receiverWallet = receiverWallet;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
