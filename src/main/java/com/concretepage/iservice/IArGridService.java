package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.ArGrid;

public interface IArGridService {
     List<ArGrid> getAllArGrids();
     ArGrid getArGridById(int gridID);
//     boolean addArticle(Article article);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);
}
