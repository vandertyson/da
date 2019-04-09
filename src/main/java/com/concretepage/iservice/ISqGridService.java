package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.SqGrid;

public interface ISqGridService {
     List<SqGrid> getAllSqGrid();
     SqGrid getSqGridById(int gridID);
//     boolean addArticle(Article article);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);
}
