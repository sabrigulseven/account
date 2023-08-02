package com.sabrigulseven.account.repository;

import com.sabrigulseven.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
