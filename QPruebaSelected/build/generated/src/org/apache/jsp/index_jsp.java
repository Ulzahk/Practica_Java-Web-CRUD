package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Index</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n");
      out.write("            <!-- Brand -->\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Logo</a>\n");
      out.write("\n");
      out.write("            <!-- Links -->\n");
      out.write("            <ul class=\"navbar-nav\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"PosiblesClientesController?btnConsultar=true\">\n");
      out.write("                        <i class=\"fas fa-users\"></i>\n");
      out.write("                        <span>Posibles Clientes</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"#\">Link 2</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <!-- Dropdown -->\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">\n");
      out.write("                        Dropdown link\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"PosibleClientesController?btnConsultar=true\">Prueba 1</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Link 2</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"login.jsp\">Salir</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container mt-4\">\n");
      out.write("            <h1 class=\"text-center\">Index</h1>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"card border-info\">\n");
      out.write("                <div class=\"card-header bg-info text-white\">\n");
      out.write("                    <a href=\"nomina.htm\" class=\"btn btn-secondary\"><i class=\"fas fa-arrow-left\"></i></a>\n");
      out.write("                    <a href=\"agregarempleados.htm\" class=\"btn btn-secondary\">Agregar Registro</a>\n");
      out.write("                    <form action=\"\" method=\"post\">\n");
      out.write("                        <div class=\"input-group mt-3\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"Buscar\" placeholder=\"Buscar en Servisoft S.A.\"/>\n");
      out.write("                            <div class=\"input-group-append\">\n");
      out.write("                                <button type=\"submit\" Value=\"Buscar\" class=\"btn btn-secondary\"><i class=\"fas fa-search\"></i> Buscar</button> \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <table border=\"1\" class=\"table table-bordered table-striped table-hover text-center\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th class=\"align-middle\">Tipo Documento</th>\n");
      out.write("                                <th class=\"align-middle\">Documento</th>\n");
      out.write("                                <th class=\"align-middle\">Nombre</th>\n");
      out.write("                                <th class=\"align-middle\">Teléfono</th>\n");
      out.write("                                <th class=\"align-middle\">Cargo</th>\n");
      out.write("                                <th class=\"align-middle\">Centro de Costos</th>\n");
      out.write("                                <th class=\"align-middle\">Acciones</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"align-middle\"></td>\n");
      out.write("                                <td class=\"align-middle\"></td>\n");
      out.write("                                <td class=\"align-middle\"></td>\n");
      out.write("                                <td class=\"align-middle\"></td>\n");
      out.write("                                <td class=\"align-middle\"></td>\n");
      out.write("                                <td class=\"align-middle\"></td>\n");
      out.write("                        <c:forEach var=\"dato\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${datos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  begin=\"\" end=\"\">\n");
      out.write("                            <td class=\"align-middle\">\n");
      out.write("                            </td>\n");
      out.write("                        </c:forEach>\n");
      out.write("                        </tr>\n");
      out.write("                        </tbody>  \n");
      out.write("                        <tbody>\n");
      out.write("                        <c:forEach var=\"dato\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${datos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"align-middle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.Tipo_documento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td class=\"align-middle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.Documento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td class=\"align-middle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.Nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td class=\"align-middle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.Telefono}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td class=\"align-middle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.Cargo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td class=\"align-middle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.CCostos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td class=\"align-middle\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </c:forEach>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>   \n");
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
