package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.ArInvoice;

public interface IArInvoiceDAO {

    List<ArInvoice> getAllInvoices();

    ArInvoice getInvoiceById(int invID);
}
