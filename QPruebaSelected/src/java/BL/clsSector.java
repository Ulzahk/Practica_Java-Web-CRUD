
package BL;

import java.sql.*;
import java.util.*;

public class clsSector {
    
    Connection conn = null;
    
    public clsSector(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Models.clsSector> getSector(){
        
        List<Models.clsSector> lstclsSector = new ArrayList<Models.clsSector>();
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{call spConsultarSectores}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsSector obclsSector = new Models.clsSector();
                obclsSector.setInCodigo(rs.getInt("sectId"));
                obclsSector.setStDescripcion(rs.getString("sectDescripcion"));
                
                lstclsSector.add(obclsSector);
            }
        } 
        catch (Exception e) 
        {
            
        }
        return lstclsSector;
    }
    
}
