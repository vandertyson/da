package com.concretepage.iservice;

import com.concretepage.entity.ContactPerson;
import java.util.List;

import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.SqGrid;
import com.concretepage.entity.Stat;
import com.concretepage.entity.Transport;
import org.springframework.http.ResponseEntity;

public interface ISalesQuotationService {

    List<SalesQuotation> getAllQuotation();

    List<Transport> getAllTransports();

    SalesQuotation getQuotationById(int quotID);

    public Long getNewQuottionID();

    public void addnewQuotation(SalesQuotation quot);

    public void updateQuotation(SalesQuotation qot);

    public void deleteQuotation(int id);

    public List<ContactPerson> getAllContacts();

    public Boolean confirmQuotation(Integer quot_id, String stat);

    public List<SalesQuotation> getAllQuotation(String Status);

    public List<SalesQuotation> getQuotByCustomer(String code);

    public List<Stat> countQuot();
}
