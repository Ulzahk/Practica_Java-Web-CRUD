<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Posibles Clientes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

    </head>
    <body>
        <%
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            if (request.getAttribute("obclsPosiblesClientes") != null) {
                obclsPosiblesClientes = (Models.clsPosiblesClientes) request.getAttribute("obclsPosiblesClientes");
            }

            List<Models.clsPosiblesClientes> lstclsPosiblesClientes
                    = new ArrayList<Models.clsPosiblesClientes>();

            //Existencia de la variable de sesion
            if (request.getAttribute("lstclsPosiblesClientes") != null) {
                //Casting para un tipo de dato a la variable session
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) request.getAttribute("lstclsPosiblesClientes");
            }

            if (request.getAttribute("stMensaje") != null
                    && request.getAttribute("stTipo") != null) {


        %>
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>

        <input type="text" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>

        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;

            swal("Mensaje", mensaje, tipo);
        </script>
        <%
            }
        %>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand" href="index.jsp">Practica: Java Web CRUD</a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">
                        <i class="far fa-list-alt"></i>
                        <span>Index</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">
                        <i class="fas fa-power-off"></i>
                        <span>Salir</span>
                    </a>
                </li>
            </ul>
        </nav>

        <div class="container">
            <div class="card mx-auto mt-5 border-info">
                <div class="card-header bg-info text-white">
                    <a href="index.jsp" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <form action="PosiblesClientesController" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <!--COLUMNA-->
                                <div class="col-md-6"> 
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-info" name="btnModificar"/>
                                    <input type="text" name="codigoModificar" id="codigoModificar" value="<%= obclsPosiblesClientes.getInCodigo()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <h1><b>Formulario de Posible Cliente</b></h1>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label for="lblEmpresa">Empresa:</label>
                                    <input type="text" class="form-control" name="txtEmpresa" placeholder="Empresa"
                                           value="<%= obclsPosiblesClientes.getStEmpresa() != null ? obclsPosiblesClientes.getStEmpresa() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblNombre">Nombre:</label>
                                    <input type="text" class="form-control" name="txtNombre" placeholder="Nombre"
                                           value="<%= obclsPosiblesClientes.getStNombre() != null ? obclsPosiblesClientes.getStNombre() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblApellidos">Apellidos:</label>
                                    <input type="text" class="form-control" name="txtApellidos" placeholder="Apellidos"
                                           value="<%= obclsPosiblesClientes.getStApellidos() != null ? obclsPosiblesClientes.getStApellidos() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblTitulo">Titulo:</label>
                                    <input type="text" class="form-control" name="txtTitulo" placeholder="Titulo" 
                                           value="<%= obclsPosiblesClientes.getStTitulo() != null ? obclsPosiblesClientes.getStTitulo() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label for="lblCorreoElectronico">Correo Electronico:</label>
                                    <input type="email" class="form-control" name="txtCorreoElectronico" placeholder="Correo Electronico"
                                           value="<%= obclsPosiblesClientes.getStCorreoElectronico() != null ? obclsPosiblesClientes.getStCorreoElectronico() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblTelefono">Teléfono:</label>
                                    <input type="text" class="form-control" name="txtTelefono" placeholder="Telefono"
                                           value="<%= obclsPosiblesClientes.getStTelefono() != null ? obclsPosiblesClientes.getStTelefono() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblFax">Fax:</label>
                                    <input type="text" class="form-control" name="txtFax" placeholder="Fax"
                                           value="<%= obclsPosiblesClientes.getStFax() != null ? obclsPosiblesClientes.getStFax() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblMovil">Movil:</label>
                                    <input type="text" class="form-control" name="txtMovil" placeholder="Movil"
                                           value="<%= obclsPosiblesClientes.getStMovil() != null ? obclsPosiblesClientes.getStMovil() : ""%>">
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label for="lblSitioWeb">Sitio Web:</label>
                                    <input type="text" class="form-control" name="txtSitioWeb" placeholder="Sitio Web"
                                           value="<%= obclsPosiblesClientes.getStSitioWeb() != null ? obclsPosiblesClientes.getStSitioWeb() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblFuentePosibleCliente">Fuente de Posible Cliente:</label>
                                    <select class="form-control" name="ddlFuentePosibleCliente">                                   
                                        <%
                                            List<Models.clsFuentePosibleCliente> lstclsFuentePosibleCliente = new ArrayList<Models.clsFuentePosibleCliente>();

                                            if (request.getAttribute("lstclsFuentePosibleCliente") != null) {
                                                lstclsFuentePosibleCliente = (List<Models.clsFuentePosibleCliente>) request.getAttribute("lstclsFuentePosibleCliente");
                                            }

                                            for (Models.clsFuentePosibleCliente elem : lstclsFuentePosibleCliente) {


                                        %>
                                        <option value="<%=elem.getInCodigo()%>"
                                                <%=obclsPosiblesClientes.getObclsFuentePosibleCliente() != null ? obclsPosiblesClientes.getObclsFuentePosibleCliente().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>  
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblEstadoPosibleCliente">Estado de Posible Cliente:</label>
                                    <select class="form-control" name="ddlEstadoPosibleCliente">
                                        <%
                                            List<Models.clsEstadoPosibleCliente> lstclsEstadoPosibleCliente = new ArrayList<Models.clsEstadoPosibleCliente>();

                                            if (request.getAttribute("lstclsEstadoPosibleCliente") != null) {
                                                lstclsEstadoPosibleCliente = (List<Models.clsEstadoPosibleCliente>) request.getAttribute("lstclsEstadoPosibleCliente");
                                            }

                                            for (Models.clsEstadoPosibleCliente elem : lstclsEstadoPosibleCliente) {


                                        %>
                                        <option value="<%=elem.getInCodigo()%>"
                                                <%=obclsPosiblesClientes.getObclsEstadoPosibleCliente() != null ? obclsPosiblesClientes.getObclsEstadoPosibleCliente().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>  
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblSector">Sector:</label>
                                    <select class="form-control" name="ddlSector">                                   
                                       <%
                                            List<Models.clsSector> lstclsSector = new ArrayList<Models.clsSector>();

                                            if (request.getAttribute("lstclsSector") != null) {
                                                lstclsSector = (List<Models.clsSector>) request.getAttribute("lstclsSector");
                                            }

                                            for (Models.clsSector elem : lstclsSector) {


                                        %>
                                        <option value="<%=elem.getInCodigo()%>"
                                                <%=obclsPosiblesClientes.getObclsSector()!= null ? obclsPosiblesClientes.getObclsSector().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>  
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label for="lblCantidadEmpleados">Cantidad de empleados:</label>
                                    <input type="number" class="form-control" name="txtCantidadEmpleados" placeholder="Cantidad de empleados"
                                           value="<%= obclsPosiblesClientes.getInCantidadEmpleados() != 0 ? obclsPosiblesClientes.getInCantidadEmpleados() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblIngresosAnuales">Ingresos anuales:</label>
                                    <input type="number" class="form-control" name="txtIngresosAnuales" placeholder="Ingresos anuales"
                                           value="<%= obclsPosiblesClientes.getDbIngresosAnuales() != 0 ? obclsPosiblesClientes.getDbIngresosAnuales() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblCalificacion">Calificación:</label>
                                    <select class="form-control" name="ddlCalificacion">
                                       <%
                                            List<Models.clsCalificacion> lstclsCalificacion = new ArrayList<Models.clsCalificacion>();

                                            if (request.getAttribute("lstclsCalificacion") != null) {
                                                lstclsCalificacion = (List<Models.clsCalificacion>) request.getAttribute("lstclsCalificacion");
                                            }

                                            for (Models.clsCalificacion elem : lstclsCalificacion) {


                                        %>
                                        <option value="<%=elem.getInCodigo()%>"
                                                <%=obclsPosiblesClientes.getObclsCalificacion() != null ? obclsPosiblesClientes.getObclsCalificacion().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>  
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblNoParticipacionCorreoElectronico">
                                        <input type="checkbox"  name="chkNoParticipacionCorreoElectronico"
                                               <%= obclsPosiblesClientes.getChNoParticipacionCorreoElectronico() == 'S' ? "checked" : ""%>/>
                                        No participación correo electronico
                                    </label>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label for="lblIDSkype">ID de Skype:</label>
                                    <input type="text" class="form-control" name="txtIDSkype" placeholder="ID de Skype"
                                           value="<%= obclsPosiblesClientes.getStIDSkype() != null ? obclsPosiblesClientes.getStIDSkype() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label for="lblTwitter">Twitter:</label>
                                    <input type="text" class="form-control" name="txtTwitter" placeholder="Twitter"
                                           value="<%= obclsPosiblesClientes.getStTwitter() != null ? obclsPosiblesClientes.getStTwitter() : ""%>"/>
                                </div>
                                <div class="col-md-6">
                                    <label for="lblCorreoElectronicoSecundario">Correo electronico secundario:</label>
                                    <input type="text" class="form-control" name="txtCorreoElectronicoSecundario" placeholder="Correo electronico secundario"
                                           value="<%= obclsPosiblesClientes.getStCorreoElectronicoSecundario() != null ? obclsPosiblesClientes.getStCorreoElectronicoSecundario() : ""%>"/>
                                </div>
                            </div>
                        </div>

                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <!--COLUMNA-->
                                <div class="col-12">
                                    <b>
                                        <i class="fas fa-clipboard-list"></i>
                                        Registros: <%=lstclsPosiblesClientes.size()%>
                                    </b>
                                </div>
                            </div>
                        </div>

                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <!--COLUMNA-->
                                <div class="col-12">
                                    <table class="table table-bordered table-responsive">
                                        <!--FILA-->
                                        <tr>
                                            <!--COLUMNA-->
                                            <td>Empresa</td>
                                            <td>Nombre</td>
                                            <td>Apellidos</td>
                                            <td>Titulo</td>
                                            <td>Correo Electronico</td>
                                            <td>Teléfono</td>
                                            <td>Fax</td>
                                            <td>Movil</td>
                                            <td>Sitio Web</td>
                                            <td>Fuente de Posible Cliente</td>
                                            <td>Estado de Posible Cliente</td>
                                            <td>Sector</td>
                                            <td>Cantidad de Empleados</td>
                                            <td>Ingresos Anuales</td>
                                            <td>Calificacion</td>
                                            <td>No Participacion de Correo Electronico</td>
                                            <td>ID de Skype</td>
                                            <td>Twitter</td>
                                            <td>Correo Electronico Secundario</td>
                                            <td>Opciones</td>
                                        </tr>
                                        <%
                                            for (Models.clsPosiblesClientes elem : lstclsPosiblesClientes) {

                                        %>
                                        <tr>
                                            <!--COLUMNA-->
                                            <td><%=elem.getStEmpresa()%></td>
                                            <td><%=elem.getStNombre()%></td>
                                            <td><%=elem.getStApellidos()%></td>
                                            <td><%=elem.getStTitulo()%></td>
                                            <td><%=elem.getStCorreoElectronico()%></td>
                                            <td><%=elem.getStTelefono()%></td>
                                            <td><%=elem.getStFax()%></td>
                                            <td><%=elem.getStMovil()%></td>
                                            <td><%=elem.getStSitioWeb()%></td>
                                            <td><%=elem.getObclsFuentePosibleCliente().getStDescripcion()%></td>
                                            <td><%=elem.getObclsEstadoPosibleCliente().getStDescripcion()%></td>
                                            <td><%=elem.getObclsSector().getStDescripcion()%></td>
                                            <td><%=elem.getInCantidadEmpleados()%></td>
                                            <td><%=elem.getDbIngresosAnuales()%></td>
                                            <td><%=elem.getObclsCalificacion().getStDescripcion()%></td>
                                            <td><%=elem.getChNoParticipacionCorreoElectronico()%></td>
                                            <td><%=elem.getStIDSkype()%></td>
                                            <td><%=elem.getStTwitter()%></td>
                                            <td><%=elem.getStCorreoElectronicoSecundario()%></td>
                                            <td class="text-center">
                                                <a class="btn btn-warning btn-sm mb-2" 
                                                   href="PosiblesClientesController?stOpcion=M&codigoSeleccionado=<%=elem.getInCodigo()%>">
                                                    <i class="fas fa-edit" style="font-size:15px;"></i>
                                                </a>
                                                <a class="btn btn-danger btn-sm"
                                                   href="PosiblesClientesController?stOpcion=E&codigoSeleccionado=<%=elem.getInCodigo()%>">
                                                    <i class="fas fa-trash-alt" style="font-size: 17px;"></i>
                                                </a>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </table>                                   
                                </div>
                            </div>
                        </div>   
                    </form>
                </div>
            </div>
        </div>
        <script>
            $('a.btn-danger').click(function(event){
                event.preventDefault();
                
                var r=confirm("¿Esta seguro que quiere eliminar este registro?");
                if(r== true){
                    window.location = this.href;
                }else{
                    alert("El registro se mantiene intacto");
                }
            });   
        </script>
    </body>
</html>
