package com.zaio.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.zaio.DTO.TransactionType;

@Entity
public class TransactionRecord {
	@Id
	private Long transactionId;
	@Column
	private BigDecimal amount;
	@ManyToOne
	@JoinColumn
	private Account sourceAccount;
	@ManyToOne
	@JoinColumn
	private Wallet sourceWallet;
	@ManyToOne
	@JoinColumn
	private Account destinationAccount;
	@ManyToOne
	@JoinColumn
	private Wallet destinationWallet;
	@Column
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	@Column
	private LocalDateTime transactionDate;
	
	public TransactionRecord() {
		
	}
	
	public TransactionRecord(Long transactionId, BigDecimal amount, Account sourceAccount, Wallet sourceWallet,
			Account destinationAccount, Wallet destinationWallet, TransactionType transactionType,
			LocalDateTime transactionDate) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.sourceAccount = sourceAccount;
		this.sourceWallet = sourceWallet;
		this.destinationAccount = destinationAccount;
		this.destinationWallet = destinationWallet;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Wallet getSourceWallet() {
		return sourceWallet;
	}

	public void setSourceWallet(Wallet sourceWallet) {
		this.sourceWallet = sourceWallet;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public Wallet getDestinationWallet() {
		return destinationWallet;
	}

	public void setDestinationWallet(Wallet destinationWallet) {
		this.destinationWallet = destinationWallet;
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
}
