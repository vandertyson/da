package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.SaleEmployee;

public interface ISaleEmployeeDAO {

    List<SaleEmployee> getAllSaleEmployees();

    SaleEmployee getSaleEmployeeById(int empID);
    
    void addSaleEmployee(SaleEmployee semp);
    
}
