package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.DeliveryGrid;

public interface IDeliveryGridService {
     List<DeliveryGrid> getAllDeliveryGrids();
     DeliveryGrid getDeliveryGridById(int gridID);
//     boolean addArticle(Article article);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);
}
