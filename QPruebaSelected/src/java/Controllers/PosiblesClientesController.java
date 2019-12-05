/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.clsPosiblesClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PRACTICANTE
 */
public class PosiblesClientesController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        //Validación Boton Guardar
        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);
        } else if (request.getParameter("btnModificar") != null) {
            btnModificar(request, response);
        } else if (request.getParameter("btnCancelar") != null) {

        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarModificar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                btnEliminar(request, response);
            }
        } else if (request.getParameter("btnConsultar") != null) {
            //Todos los posibles clientes
            BL.clsPosiblesClientes bl_obclsPosiblesClientes = new BL.clsPosiblesClientes();
            request.setAttribute("lstclsPosiblesClientes", bl_obclsPosiblesClientes.getPosiblesClientes());

            //Lista desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());

            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
        } else if (request.getParameter("btnConsultarIndex") != null){
            //Todos los posibles clientes
            BL.clsPosiblesClientes bl_obclsPosiblesClientes = new BL.clsPosiblesClientes();
            request.setAttribute("lstclsPosiblesClientes", bl_obclsPosiblesClientes.getPosiblesClientes());

            //Lista desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());

            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.clsPosiblesClientes bl_clsPosiblesClientes = new BL.clsPosiblesClientes();

            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();

            //Asignación de atributos o propiedades
            if (request.getParameter("codigoModificar") != null) {
                obclsPosiblesClientes.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }
            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesClientes.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesClientes.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesClientes.setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesClientes.setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsPosiblesClientes.setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesClientes.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                obclsPosiblesClientes.setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                obclsPosiblesClientes.setStMovil(request.getParameter("txtMovil"));
            }

            if (request.getParameter("txtSitioWeb") != null) {
                obclsPosiblesClientes.setStSitioWeb(request.getParameter("txtSitioWeb"));
            }

            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                //Modelo Externo
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));

                //Asignación al modelo padre
                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }

            if (request.getParameter("ddlEstadoPosibleCliente") != null) {

                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));

                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }

            if (request.getParameter("ddlSector") != null) {

                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));

                obclsPosiblesClientes.setObclsSector(obclsSector);
            }

            if (request.getParameter("txtCantidadEmpleados") != null) {
                obclsPosiblesClientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            } else {
                obclsPosiblesClientes.setInCantidadEmpleados(0);
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                obclsPosiblesClientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            } else {
                obclsPosiblesClientes.setDbIngresosAnuales(0);
            }

            if (request.getParameter("ddlCalificacion") != null) {

                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));

                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);
            }

            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';

                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico('N');
            }

            if (request.getParameter("txtIDSkype") != null) {
                obclsPosiblesClientes.setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                obclsPosiblesClientes.setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                obclsPosiblesClientes.setStCorreoElectronicoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }

            //Definir parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsPosiblesClientes.uptadePosiblesClientes(obclsPosiblesClientes));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsPosiblesClientes", bl_clsPosiblesClientes.getPosiblesClientes());
            
            //Lista desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());
            
            //Redirecciono y envio los valores
            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
             //Todos los posibles clientes
            BL.clsPosiblesClientes bl_obclsPosiblesClientes = new BL.clsPosiblesClientes();
            request.setAttribute("lstclsPosiblesClientes", bl_obclsPosiblesClientes.getPosiblesClientes());
            
             //Lista desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());
            
            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
        }
    }

    public void btnEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.clsPosiblesClientes bl_clsPosiblesClientes = new BL.clsPosiblesClientes();
            //Modelo que estamos trabajando
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            if (request.getParameter("codigoSeleccionado") != null) {

                obclsPosiblesClientes.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }

            request.setAttribute("stMensaje", bl_clsPosiblesClientes.deletePosibleCliente(obclsPosiblesClientes));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsPosiblesClientes", bl_clsPosiblesClientes.getPosiblesClientes());

            //Lista desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());

            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.clsPosiblesClientes bl_clsPosiblesClientes = new BL.clsPosiblesClientes();

            //Lista de objetos donde esta la información guardada
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
            //Modelo que estamos trabajando
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            lstclsPosiblesClientes = bl_clsPosiblesClientes.getPosiblesClientes();

            for (Models.clsPosiblesClientes elem : lstclsPosiblesClientes) {
                if (elem.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPosiblesClientes = elem;
                    break;
                }
            }

            //Lista desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());

            request.setAttribute("obclsPosiblesClientes", obclsPosiblesClientes);
            request.setAttribute("lstclsPosiblesClientes", lstclsPosiblesClientes);
            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            BL.clsPosiblesClientes bl_obclsPosiblesClientes = new BL.clsPosiblesClientes();

            //Definicion de Modelos
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();

            //Asignación de atributos o propiedades
            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesClientes.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesClientes.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesClientes.setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesClientes.setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsPosiblesClientes.setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesClientes.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                obclsPosiblesClientes.setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                obclsPosiblesClientes.setStMovil(request.getParameter("txtMovil"));
            }

            if (request.getParameter("txtSitioWeb") != null) {
                obclsPosiblesClientes.setStSitioWeb(request.getParameter("txtSitioWeb"));
            }

            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                //Modelo Externo
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));

                //Asignación al modelo padre
                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }

            if (request.getParameter("ddlEstadoPosibleCliente") != null) {

                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));

                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }

            if (request.getParameter("ddlSector") != null) {

                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));

                obclsPosiblesClientes.setObclsSector(obclsSector);
            }

            if (request.getParameter("txtCantidadEmpleados") != null) {
                obclsPosiblesClientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            } else {
                obclsPosiblesClientes.setInCantidadEmpleados(0);
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                obclsPosiblesClientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            } else {
                obclsPosiblesClientes.setDbIngresosAnuales(0);
            }

            if (request.getParameter("ddlCalificacion") != null) {

                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));

                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);
            }

            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';

                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico('N');
            }

            if (request.getParameter("txtIDSkype") != null) {
                obclsPosiblesClientes.setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                obclsPosiblesClientes.setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                obclsPosiblesClientes.setStCorreoElectronicoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }

            //Definir parametros desde el controlador
            request.setAttribute("stMensaje", bl_obclsPosiblesClientes.createPosiblesClientes(obclsPosiblesClientes));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsPosiblesClientes", bl_obclsPosiblesClientes.getPosiblesClientes());

            //Listas desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());

            //Redirecciono y envio los valores
            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);

        } catch (Exception ex) {

            //Definir parametros desde el controlador
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
             //Todos los posibles clientes
            BL.clsPosiblesClientes bl_obclsPosiblesClientes = new BL.clsPosiblesClientes();
            request.setAttribute("lstclsPosiblesClientes", bl_obclsPosiblesClientes.getPosiblesClientes());
            
             //Lista desplegables
            BL.clsCalificacion bl_obclsCalificacion = new BL.clsCalificacion();
            BL.clsEstadoPosibleCliente bl_obclsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_obclsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_obclsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificacion", bl_obclsCalificacion.getCalificacion());
            request.setAttribute("lstclsEstadoPosibleCliente", bl_obclsEstadoPosibleCliente.getEstadoPosibleClientes());
            request.setAttribute("lstclsFuentePosibleCliente", bl_obclsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSector", bl_obclsSector.getSector());

            //Redirecciono y envio los valores
            request.getRequestDispatcher("posiblesclientes.jsp").forward(request, response);
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
