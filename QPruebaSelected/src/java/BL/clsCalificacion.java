
package BL;

import java.sql.*;
import java.util.*;

public class clsCalificacion {
    
    Connection conn= null;
    
    public clsCalificacion(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Models.clsCalificacion> getCalificacion(){
        
        List<Models.clsCalificacion> lstclsCalificacion = new ArrayList<Models.clsCalificacion>();
        
        try {
           
            PreparedStatement ps = conn.prepareStatement("{call spConsultarCalificacion()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();
                obclsCalificacion.setInCodigo(rs.getInt("caliId"));
                obclsCalificacion.setStDescripcion(rs.getString("caliDescripcion"));
                
                lstclsCalificacion.add(obclsCalificacion);
            };
            
        } 
        catch (Exception ex) 
        {
            
        }
        return lstclsCalificacion; 
    }
}
