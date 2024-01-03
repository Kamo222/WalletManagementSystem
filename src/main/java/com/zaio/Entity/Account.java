package com.zaio.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {
    @Id
	private Long accountId;
    @Column
    private String accountName;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @OneToOne
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private List<Wallet> wallets;
    @Column
    private BigDecimal totalAmount;
	
    public Account() {
		
	}
    
    public Account(Long accountId, String accountName, LocalDateTime createdAt, LocalDateTime updatedAt, User user,
			List<Wallet> wallets, BigDecimal totalAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.wallets = wallets;
		this.totalAmount = totalAmount;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccoutid(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(List<Wallet> wallets) {
		this.wallets = wallets;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
    
	
	
    /* Copy and Paste Previous One */

    /* Delete totalAmount */

    /* Create List<Wallet> wallets */
    /* Tip : Add @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY) */
    /* Read : How FetchType.LAZY works. why we are using CascadeType.ALL */
}

