package com.concretepage.service;

import com.concretepage.iservice.ICustomerService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.daointerface.ICustomerDAO;
import com.concretepage.entity.Customer;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDAO DAO;

    @Override
    public List<Customer> getAllCustomer() {
        return DAO.getAllCustomer();
    }

    @Override
    public List<Customer> getAllCustomer(String top) {
        return DAO.getAllCustomer(top);
    }

    @Override
    public boolean addCustomer(Customer cust) {
        DAO.addCustomer(cust);
        return true;
    }

    @Override
    public void updateCustomer(Customer cust) {
        DAO.updateCustomer(cust);

    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return DAO.getCustomerWithName(name);
    }

    @Override
    public boolean deleteCustomer(String code) {
        DAO.deleteCustomer(code);
        return true;
    }

    @Override
    public Customer getCustomerById(String code) {
        return DAO.getCustomerById(code);
    }

}
