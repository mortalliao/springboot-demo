package com.springboot.demo.jms.jpa.service;

import com.springboot.demo.jms.jpa.dao.CustomerRepository;
import com.springboot.demo.jms.jpa.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jim
 */
@Service
public class CustomerServiceInAnnotation {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
}
