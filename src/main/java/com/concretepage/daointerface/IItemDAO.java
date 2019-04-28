package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.Item;

public interface IItemDAO {

    List<Item> getAllItem();

    //Item getItemById(int itemID);   
    public List<Item> getAllItem(String top);

    public List<Item> getItemWithName(String name);

    public void addItem(Item item);

    public void updateItem(Item item);
    
    public void deleteItem(String code);

    public Item getItemById(String code);
    
}
