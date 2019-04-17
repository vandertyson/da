package com.concretepage.daointerface;
import java.util.List;
import com.concretepage.entity.ArGrid;
public interface IArGridDAO {
    List<ArGrid> getAllArGrids();
    ArGrid getArGridById(int gridID);   
}
 