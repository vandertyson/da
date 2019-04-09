package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.SoGrid;

public interface ISoGridService {
     List<SoGrid> getAllSoGrid();
     SoGrid getSoGridById(int gridID);
//     boolean addArticle(Article article);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);
}
