package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomer();
}
