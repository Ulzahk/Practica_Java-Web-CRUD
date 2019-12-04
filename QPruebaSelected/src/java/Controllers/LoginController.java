
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRACTICANTE
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        if(request.getParameter("btnAutenticar")!=null){
            btnAutenticar(request, response);
        }else if(request.getParameter("btnRegistrar")!=null){
            btnRegistrar(request, response);
        }
        
       
    }
    
    public void btnRegistrar(HttpServletRequest request,
            HttpServletResponse response)throws ServletException, IOException{
        try {
            String stMensaje="";
            if(request.getParameter("txtLogin") == null){
                stMensaje +="Ingrese login,";
            }
            if(request.getParameter("txtPassword") == null){
                stMensaje +="Ingrese password,";
            }
            if(request.getParameter("txtConfirmarPassword") == null){
                stMensaje +="Ingrese password";
            }
            if(request.getParameter("txtPassword")!= null && request.getParameter("txtConfirmarPassword")== null){
                if(!request.getParameter("txtPassword").equals(request.getParameter("txtConfirmarPassword"))){
                    stMensaje += "El password ingresado no coincide con  las confirmación";
                }
            }
            if(!stMensaje.equals("")){
                throw new Exception(stMensaje.substring(0, stMensaje.length() -1));
            }
            
            BL.clsLogin obclsLogin = new BL.clsLogin();
            Models.clsLogin obclsLoginModel = new Models.clsLogin();
            
            obclsLoginModel.setStEmail(request.getParameter("txtLogin"));
            obclsLoginModel.setStPassword(request.getParameter("txtPassword"));
            obclsLoginModel.setInEstado(Integer.parseInt(request.getParameter("inEstado")));
            
            if(!obclsLogin.addUsuario(obclsLoginModel).equals("OK")){
                throw new Exception ("Se produjo un error durante el procedimiento");
            }else
            {
                request.setAttribute("stMensaje", "Se realizo el proceso con exito");
                request.setAttribute("stTipo", "success");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } 
        catch (Exception ex) 
        {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
    
    public void btnAutenticar(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
        
        try 
        {
            String stMensaje="";
            
            if(request.getParameter("txtEmail").equals("")) 
            {
                stMensaje += " Ingrese Login,";
            }
            if(request.getParameter("txtPassword").equals(""))
            {
                stMensaje += " Ingrese password,";
            }
            
            if(!stMensaje.equals(""))
            {
                throw new Exception(stMensaje.substring(0,stMensaje.length()-1));
            }
            //Instanciando objeto
            Models.clsLogin obclsLogin = new Models.clsLogin();
            
            //Asignando propiedades
            obclsLogin.setStEmail(request.getParameter("txtEmail").toString());
            obclsLogin.setStPassword(request.getParameter("txtPassword").toString());
            
            //Instanciando controlador
            BL.clsLogin  obBLclsLogin = new BL.clsLogin();
            
            //Invoco
            boolean blBandera = obBLclsLogin.validarLogin(obclsLogin);
            
            if(blBandera)
            {
                //Direccionamiento JSP
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else
            {
                throw new Exception("Email o password incorrecto");
            }
            
        } 
        catch (Exception ex) 
        {
            //Envio de parametros o valores
            request.setAttribute("stError",ex.getMessage());
            //Direccionamiento SERVLET
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
