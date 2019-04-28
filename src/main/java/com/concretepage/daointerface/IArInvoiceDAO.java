package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.ArInvoice;
import com.concretepage.entity.Transport;

public interface IArInvoiceDAO {

    List<ArInvoice> getAllInvoices();

    ArInvoice getInvoiceById(int invID);

    List<Transport> getAllTransports();

    public void deleteInvoice(int id);
}
