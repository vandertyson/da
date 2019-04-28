package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.Users;

public interface IUsersDAO {

    List<Users> getAllUsers();

    //Item getItemById(int itemID);   
    //public List<Item> getAllItem(String top);

    //public List<Item> getItemWithName(String name);

    public void addUser(Users user);

    public void updateUser(Users user);
    
    public void deleteUser(int id);

    public Users getUserById(int id);
    
}
