package com.concretepage.daointerface;

import com.concretepage.entity.ContactPerson;
import java.util.List;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;

public interface ISalesQuotationDAO {

    List<SalesQuotation> getAllQuotation();

    SalesQuotation getQuotationById(int quotID);

    List<Transport> getAllTransports();

    List<ContactPerson> getAllContacts();

    public void deleteQuotation(int id);

}
