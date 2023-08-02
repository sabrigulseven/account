package com.sabrigulseven.account.repository;

import com.sabrigulseven.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
