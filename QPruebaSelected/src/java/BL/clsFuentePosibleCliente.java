
package BL;

import java.sql.*;
import java.util.*;

public class clsFuentePosibleCliente {
    
    Connection conn = null;
    
    public clsFuentePosibleCliente(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
        
    }
    
    public List<Models.clsFuentePosibleCliente> getFuentePosibleCliente(){
        
        List<Models.clsFuentePosibleCliente> lstclsFuentePosibleCliente = new ArrayList<Models.clsFuentePosibleCliente>();
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{call spConsultarFuentes}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
                obclsFuentePosibleCliente.setInCodigo(rs.getInt("fuenId"));
                obclsFuentePosibleCliente.setStDescripcion(rs.getString("fuenDescripcion"));
                
                lstclsFuentePosibleCliente.add(obclsFuentePosibleCliente);  
            }
        } 
        catch (Exception ex) {
            
        }
        return lstclsFuentePosibleCliente;
    }
    
}
