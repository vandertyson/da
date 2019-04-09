package com.concretepage.daointerface;
import java.util.List;
import com.concretepage.entity.SqGrid;
public interface ISqGridDAO {
    List<SqGrid> getAllSqGrid();
    SqGrid getSqGridById(int gridID);   
}
 