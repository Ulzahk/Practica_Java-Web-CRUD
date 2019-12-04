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

        <title>Index</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


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
                    <a class="nav-link" href="PosiblesClientesController?btnConsultar=true">
                        <i class="fas fa-users"></i>
                        <span>Posibles Clientes</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">
                        <i class="far fa-list-alt"></i>
                        <span>Salir</span>
                    </a>
                </li>

                <!-- Dropdown 
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        Perfil
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="PosibleClientesController?btnConsultar=true">Tablas Perfil</a>
                        <a class="dropdown-item" href="#">Link 2</a>
                        <a class="dropdown-item" href="login.jsp">Salir</a>
                    </div>
                </li> -->
            </ul>
        </nav>




        <div class="container mt-4">
            <h1 class="text-center">Index</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="PosiblesClientesController?btnConsultarIndex=true" class="btn btn-secondary">Cargar Registros</a>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center table-responsive">
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


                        <tr>
                            <!--COLUMNA-->
                            <td><b>Empresa</b></td>
                            <td><b>Nombre</b></td>
                            <td><b>Apellidos</b></td>
                            <td><b>Titulo</b></td>
                            <td><b>Correo Electronico</b></td>
                            <td><b>Teléfono</b></td>
                            <td><b>Fax</b></td>
                            <td><b>Movil</b></td>
                            <td><b>Sitio Web</b></td>
                            <td><b>Fuente de Posible Cliente</b></td>
                            <td><b>Estado de Posible Cliente</b></td>
                            <td><b>Sector</b></td>
                            <td><b>Cantidad de Empleados</b></td>
                            <td><b>Ingresos Anuales</b></td>
                            <td><b>Calificacion</b></td>
                            <td><b>No Participacion de Correo Electronico</b></td>
                            <td><b>ID de Skype</b></td>
                            <td><b>Twitter</b></td>
                            <td><b>Correo Electronico Secundario</b></td>
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
                        </tr>                        
                        <%
                            }
                        %>
                    </table>   
                </div>
            </div>
        </div>
    </body>
</html>
