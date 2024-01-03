package com.zaio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaio.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
