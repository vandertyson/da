package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.ArInvoice;
import com.concretepage.entity.Transport;

public interface IArInvoiceService {

    List<ArInvoice> getAllInvoices();

    ArInvoice getInvoiceById(int invID);
//     boolean addArticle(Article article);
//     void updateArticle(Article article);
//     void deleteArticle(int articleId);

    public Long getNewInvoiceID();

    public void addnewInvoice(ArInvoice inv);

    public List<Transport> getAllTransports();

    public void updateInvoice(ArInvoice inv);

    public void deleteInvoice(Integer id);
}
