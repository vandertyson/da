package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.Customer;

public interface ICustomerService {

    List<Customer> getAllCustomer();
    //Article getArticleById(int articleId);

    boolean addCustomer(Customer cust);

    void updateCustomer(Customer cust);

    boolean deleteCustomer(String code);

    public List<Customer> getAllCustomer(String top);

    public List<Customer> findCustomerByName(String name);
}
