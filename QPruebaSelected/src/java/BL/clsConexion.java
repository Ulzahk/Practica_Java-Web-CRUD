package BL;
import java.sql.DriverManager;
import java.sql.Connection;

public class clsConexion {
    Connection conn = null;
    String stServidor, stUsuario, stPassword, stDB = "";
    
    public clsConexion(){
        try {
            
            stServidor="suServidor";
            stUsuario="suUsuario";
            stPassword="suContraseña";
            stDB = "suBasedeDatos";
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String stConexion = "jdbc:sqlserver://"+stServidor+";databaseName="+stDB;
            
            conn = DriverManager.getConnection(stConexion, stUsuario, stPassword);
            
        } 
        catch (Exception ex) {
            
        }
    }
    
    public Connection getConexion(){
        return conn;
    }
    
    public void closeConexion(Connection conn){
        
        try {
            conn.close();
        } 
        catch (Exception e) {
            
        }
    }
}
