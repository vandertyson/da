package com.concretepage.daointerface;
import java.util.List;
import com.concretepage.entity.DeliveryGrid;
public interface IDeliveryGridDAO {
    List<DeliveryGrid> getAllDeliveryGrids();
    DeliveryGrid getDeliveryGridById(int gridID);   
}
 