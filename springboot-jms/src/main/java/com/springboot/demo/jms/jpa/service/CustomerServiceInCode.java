package com.springboot.demo.jms.jpa.service;

import com.springboot.demo.jms.jpa.dao.CustomerRepository;
import com.springboot.demo.jms.jpa.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author Jim
 */
@Service
public class CustomerServiceInCode {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public Customer create(Customer customer) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = transactionManager.getTransaction(def);

        try {
            customerRepository.save(customer);
            simulateError();
            transactionManager.commit(transactionStatus);
            return customer;
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }
    }

    private void simulateError() {
        throw new RuntimeException("some Data error.");
    }
}
