
package BL;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class clsLogin 
{
    clsConexion obclsConexion = new clsConexion();
    Connection conn = null;
    
    public clsLogin(){
        
        conn = obclsConexion.getConexion();
    }
    
    public boolean  validarLogin(Models.clsLogin obclsLogin)
    {
        try 
        {
            PreparedStatement ps = conn.prepareStatement("{call spConsultarUsuario (?,?)}");
            ps.setString(1, obclsLogin.getStEmail());
            ps.setString(2, obclsLogin.getStPassword());
            
            ResultSet rs = ps.executeQuery();
            
            boolean blExiste= false;
            
            while(rs.next())
            {
                blExiste = true;
            }
            return blExiste; 
        } 
        catch (Exception ex) 
        {
            return false;
        }
    }
    
    public String addUsuario(Models.clsLogin obclsLogin){
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into practica_usuarios (usuaLogin, usuaPassword, estaCodigo) values (?,?,?)");
            ps.setString(1, obclsLogin.getStEmail());
            ps.setString(2, obclsLogin.getStPassword());
            ps.setInt(3, obclsLogin.getInEstado());

            ps.execute();
            return "OK";
        } 
        catch (Exception ex) 
        {   
            return ex.getMessage();
        }finally{
            obclsConexion.closeConexion(conn);
        }
    }
}
