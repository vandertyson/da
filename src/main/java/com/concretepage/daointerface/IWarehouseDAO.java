package com.concretepage.daointerface;

import com.concretepage.entity.Item;
import java.util.List;
import com.concretepage.entity.Warehouse;

public interface IWarehouseDAO {

    List<Warehouse> getAllWarehouses();

    //Item getItemById(int itemID);   
    //public List<Item> getAllItem(String top);

    //public List<Item> getItemWithName(String name);

    public void addWarehouse(Warehouse whs);

    public void updateWarehouse(Warehouse whs);
    
    public void deleteWarehouse(String code);

    public Warehouse getWarehouseByCode(String code);
    
    public List<Warehouse> getWarehouseWithName(String name);
    
    public List<Warehouse> getAllWarehouses(String top);
    
}
