package com.zaio.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
public class Wallet {

    /* Create Your Fields */
	@Id
	private Long walletid;
	@Column
	private String walletName;
	@Column
	private BigDecimal balance;
	@Column
	private LocalDateTime createdAt;
	@Column
	private LocalDateTime updatedAt;
	@ManyToOne
	private Account account;
    // Getters and setters, constructors, and other methods as needed
	
	public Wallet() {
		
	}
	
	public Wallet(Long walletid, String walletName, BigDecimal balance, LocalDateTime createdAt,
			LocalDateTime updatedAt, Account account) {
		super();
		this.walletid = walletid;
		this.walletName = walletName;
		this.balance = balance;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.account = account;
	}
	public Long getWalletid() {
		return walletid;
	}
	public void setWalletid(Long walletid) {
		this.walletid = walletid;
	}
	public String getWalletName() {
		return walletName;
	}
	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
    
}
