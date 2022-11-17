package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomer() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query .... sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by id", Customer.class);
        //   execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        //  get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //  save/update the customer ,,,
        //  currentSession.save(theCustomer);

        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        //  get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //  now retrieve/read from database using the primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;

    }
}
