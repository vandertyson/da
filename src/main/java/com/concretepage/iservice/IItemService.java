package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.Item;

public interface IItemService {

    List<Item> getAllItem();

    boolean addItem(Item item);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);

    public List<Item> findItemByName(String name);

    public List<Item> getAllItem(String top);

    boolean updateItem(Item item);
    
    boolean deleteItem(String code);
}
