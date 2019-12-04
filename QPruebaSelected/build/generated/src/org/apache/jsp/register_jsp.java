package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Register</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");


            if(request.getAttribute("stMensaje")!=null 
                    && request.getAttribute("stTipo")!=null){
                
            
        
      out.write("\n");
      out.write("        <input type=\"text\" hidden=\"\" id=\"txtMensaje\" value=\"");
      out.print(request.getAttribute("stMensaje"));
      out.write("\"/>\n");
      out.write("        \n");
      out.write("        <input type=\"text\" hidden=\"\" id=\"txtTipo\" value=\"");
      out.print(request.getAttribute("stTipo"));
      out.write("\"/>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            var mensaje = document.getElementById(\"txtMensaje\").value;\n");
      out.write("            var tipo = document.getElementById(\"txtTipo\").value;\n");
      out.write("            \n");
      out.write("            swal(\"Mensaje\", mensaje, tipo);\n");
      out.write("        </script>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"card o-hidden border-0 shadow-lg my-5\">\n");
      out.write("                <div class=\"card-body p-0\">\n");
      out.write("                    <!-- Nested Row within Card Body -->\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <div class=\"p-5\">\n");
      out.write("                                <div class=\"text-center\">\n");
      out.write("                                    <h1 class=\"h4 text-gray-900 mb-4\">Crear Cuenta</h1>\n");
      out.write("                                </div>\n");
      out.write("                                <form class=\"user\" action=\"LoginController\" method=\"POST\">\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                        <div class=\"col-sm-12\">\n");
      out.write("                                            <label for=\"lblLogin\">Login: </label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"txtLogin\" placeholder=\"Ingrese login\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                        <div class=\"col-sm-12\">\n");
      out.write("                                            <label for=\"lblPassword\">Password: </label>\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" name=\"txtPassword\" placeholder=\"Ingrese password\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form group\">\n");
      out.write("                                        <div class=\"form row\">\n");
      out.write("                                            <div class=\"col-sm-12\">\n");
      out.write("                                                <label for=\"lblConfirmarPassword\">Confirmar Password</label>\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" name=\"txtConfirmarPassword\" placeholder=\"Repita password\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <br>\n");
      out.write("                                    <input type=\"submit\" name=\"btnRegistrar\" class=\"btn btn-primary btn-block\" value=\"Aceptar\"/>\n");
      out.write("                                    <hr>\n");
      out.write("                                </form>\n");
      out.write("                                <hr>\n");
      out.write("                                <div class=\"text-center\">\n");
      out.write("                                    <a class=\"small\" href=\"login.jsp\">Login</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
