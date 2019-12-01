package com.springboot.demo.jms.jpa.dao;

import com.springboot.demo.jms.jpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jim
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUsername(String username);
}
