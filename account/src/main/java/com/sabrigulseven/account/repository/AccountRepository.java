package com.sabrigulseven.account.repository;

import com.sabrigulseven.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
