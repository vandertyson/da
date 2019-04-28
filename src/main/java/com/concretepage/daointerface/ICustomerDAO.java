package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.Customer;

public interface ICustomerDAO {

    List<Customer> getAllCustomer();

    void addCustomer(Customer cust);

    void updateCustomer(Customer cust);

    public void deleteCustomer(String code);

    public List<Customer> getAllCustomer(String top);

    public List<Customer> getCustomerWithName(String name);

    public Customer getCustomerById(String code);
}
