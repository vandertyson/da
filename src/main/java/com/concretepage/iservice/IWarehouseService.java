package com.concretepage.iservice;

import com.concretepage.entity.Item;
import java.util.List;

import com.concretepage.entity.Warehouse;

public interface IWarehouseService {

    List<Warehouse> getAllWarehouses();

    boolean addWarehouse(Warehouse whs);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);

    //public List<Item> findItemByName(String name);

   //public List<Users> getAllItem(String top);

    boolean updateWarehouse(Warehouse whs);
    
    boolean deleteWarehouse(String code);

    public Warehouse getWarehouseByCode(String code);
    
    public List<Warehouse> findWarehouseByName(String name);

    public List<Warehouse> getAllWarehouses(String top);
}
