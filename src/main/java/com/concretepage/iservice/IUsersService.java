package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.Users;

public interface IUsersService {

    List<Users> getAllUsers();

    boolean addUser(Users user);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);

    //public List<Item> findItemByName(String name);

   //public List<Users> getAllItem(String top);

    boolean updateUser(Users user);
    
    boolean deleteUser(int id);

    public Users getUserById(int id);
}
