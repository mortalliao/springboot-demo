package com.springboot.demo.jms.jpa.web;

import com.springboot.demo.jms.jpa.dao.CustomerRepository;
import com.springboot.demo.jms.jpa.domain.Customer;
import com.springboot.demo.jms.jpa.service.CustomerServiceInAnnotation;
import com.springboot.demo.jms.jpa.service.CustomerServiceInCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jim
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    @Autowired
    private CustomerServiceInCode customerServiceInCode;

    @Autowired
    private CustomerServiceInAnnotation customerServiceInAnnotation;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/code")
    public Customer createInCode(@RequestBody Customer customer) {
        return customerServiceInCode.create(customer);
    }

    @PostMapping("annotation")
    public Customer createInAnno(@RequestBody Customer customer) {
        return customerServiceInAnnotation.create(customer);
    }

    @GetMapping("")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
