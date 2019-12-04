package BL;
import Models.clsFuentePosibleCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clsPosiblesClientes {
    
    Connection conn= null;
    
    public clsPosiblesClientes(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public String deletePosibleCliente(Models.clsPosiblesClientes obclsPosiblesClientes){
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{call spEliminarPosibleCliente(?)}");
            ps.setInt(1, obclsPosiblesClientes.getInCodigo());
            ps.execute();
            
            return "Se realizo el proceso con exito";
        } 
        catch (Exception ex) 
        {
            return ex.getMessage();
        }
    }
    
    public String createPosiblesClientes(Models.clsPosiblesClientes obclsPosiblesClientes){
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{ call spInsertarPosiblesClientes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            ps.setString(1, obclsPosiblesClientes.getStEmpresa());
            ps.setString(2, obclsPosiblesClientes.getStNombre());
            ps.setString(3, obclsPosiblesClientes.getStApellidos());
            ps.setString(4, obclsPosiblesClientes.getStTitulo());
            ps.setString(5, obclsPosiblesClientes.getStCorreoElectronico());
            ps.setString(6, obclsPosiblesClientes.getStTelefono());
            ps.setString(7, obclsPosiblesClientes.getStFax());
            ps.setString(8, obclsPosiblesClientes.getStMovil());
            ps.setString(9, obclsPosiblesClientes.getStSitioWeb());
            ps.setInt(10, obclsPosiblesClientes.getObclsFuentePosibleCliente().getInCodigo());
            ps.setInt(11, obclsPosiblesClientes.getObclsEstadoPosibleCliente().getInCodigo());
            ps.setInt(12, obclsPosiblesClientes.getObclsSector().getInCodigo());
            ps.setInt(13, obclsPosiblesClientes.getInCantidadEmpleados());
            ps.setDouble(14, obclsPosiblesClientes.getDbIngresosAnuales());
            ps.setInt(15, obclsPosiblesClientes.getObclsCalificacion().getInCodigo());
            ps.setString(16, String.valueOf(obclsPosiblesClientes.getChNoParticipacionCorreoElectronico()));
            ps.setString(17, obclsPosiblesClientes.getStIDSkype());
            ps.setString(18, obclsPosiblesClientes.getStTwitter());
            ps.setString(19, obclsPosiblesClientes.getStCorreoElectronicoSecundario());
            
            ps.execute();
            
            return "Se realizo el proceso con exito";
        } 
        catch (Exception ex) 
        {
            return ex.getMessage();
        }
    }
    
    public String uptadePosiblesClientes(Models.clsPosiblesClientes obclsPosiblesClientes){
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{ call spModificarPosibleCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            ps.setInt(1, obclsPosiblesClientes.getInCodigo());
            ps.setString(2, obclsPosiblesClientes.getStEmpresa());
            ps.setString(3, obclsPosiblesClientes.getStNombre());
            ps.setString(4, obclsPosiblesClientes.getStApellidos());
            ps.setString(5, obclsPosiblesClientes.getStTitulo());
            ps.setString(6, obclsPosiblesClientes.getStCorreoElectronico());
            ps.setString(7, obclsPosiblesClientes.getStTelefono());
            ps.setString(8, obclsPosiblesClientes.getStFax());
            ps.setString(9, obclsPosiblesClientes.getStMovil());
            ps.setString(10, obclsPosiblesClientes.getStSitioWeb());
            ps.setInt(11, obclsPosiblesClientes.getObclsFuentePosibleCliente().getInCodigo());
            ps.setInt(12, obclsPosiblesClientes.getObclsEstadoPosibleCliente().getInCodigo());
            ps.setInt(13, obclsPosiblesClientes.getObclsSector().getInCodigo());
            ps.setInt(14, obclsPosiblesClientes.getInCantidadEmpleados());
            ps.setDouble(15, obclsPosiblesClientes.getDbIngresosAnuales());
            ps.setInt(16, obclsPosiblesClientes.getObclsCalificacion().getInCodigo());
            ps.setString(17, String.valueOf(obclsPosiblesClientes.getChNoParticipacionCorreoElectronico()));
            ps.setString(18, obclsPosiblesClientes.getStIDSkype());
            ps.setString(19, obclsPosiblesClientes.getStTwitter());
            ps.setString(20, obclsPosiblesClientes.getStCorreoElectronicoSecundario());
            
            ps.execute();
            
            return "Se realizo el proceso con exito";
        } 
        catch (Exception ex) 
        {
            return ex.getMessage();
        }
    }
    
    public  List<Models.clsPosiblesClientes> getPosiblesClientes(){
        
        List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
        
        try 
        {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarPosiblesClientes()}");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
                obclsPosiblesClientes.setInCodigo(rs.getInt("poclCodigo"));
                obclsPosiblesClientes.setStEmpresa(rs.getString("poclEmpresa"));
                obclsPosiblesClientes.setStNombre(rs.getString("poclNombres"));
                obclsPosiblesClientes.setStApellidos(rs.getString("poclApellidos"));
                obclsPosiblesClientes.setStTitulo(rs.getString("poclTitulo"));
                obclsPosiblesClientes.setStCorreoElectronico(rs.getString("poclCorreo"));
                obclsPosiblesClientes.setStTelefono(rs.getString("poclTelefono"));
                obclsPosiblesClientes.setStFax(rs.getString("poclFax"));
                obclsPosiblesClientes.setStMovil(rs.getString("poclMovil"));
                obclsPosiblesClientes.setStSitioWeb(rs.getString("poclSitioWeb"));
                
                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
                obclsFuentePosibleCliente.setInCodigo(rs.getInt("fuenId"));
                obclsFuentePosibleCliente.setStDescripcion(rs.getString("fuenDescripcion"));
                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
                
                Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
                obclsEstadoPosibleCliente.setInCodigo(rs.getInt("esclId"));
                obclsEstadoPosibleCliente.setStDescripcion(rs.getString("esclDescripcion"));
                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
                
                Models.clsSector obclsSector = new Models.clsSector();
                obclsSector.setInCodigo(rs.getInt("sectId"));
                obclsSector.setStDescripcion(rs.getString("sectDescripcion"));
                obclsPosiblesClientes.setObclsSector(obclsSector);
                
                obclsPosiblesClientes.setInCantidadEmpleados(rs.getInt("poclCantidadEmpleados"));
                obclsPosiblesClientes.setDbIngresosAnuales(rs.getDouble("poclIngresosAnuales"));
                
                Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();
                obclsCalificacion.setInCodigo(rs.getInt("caliId"));
                obclsCalificacion.setStDescripcion(rs.getString("caliDescripcion"));
                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);
                
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico(rs.getString("poclNoParticipacionCorreoElectronico").charAt(0));
                obclsPosiblesClientes.setStIDSkype(rs.getString("poclIDSkype"));
                obclsPosiblesClientes.setStTwitter(rs.getString("poclTwitter"));
                obclsPosiblesClientes.setStCorreoElectronicoSecundario(rs.getString("poclCorreoSecundario"));
                
                lstclsPosiblesClientes.add(obclsPosiblesClientes);
                
            }
            
        } 
        catch (Exception ex) 
        {
            
        }
        return lstclsPosiblesClientes;
    }
}
