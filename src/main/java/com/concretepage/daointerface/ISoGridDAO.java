package com.concretepage.daointerface;
import java.util.List;
import com.concretepage.entity.SoGrid;
public interface ISoGridDAO {
    List<SoGrid> getAllSoGrid();
    SoGrid getSoGridById(int gridID);   
}
 