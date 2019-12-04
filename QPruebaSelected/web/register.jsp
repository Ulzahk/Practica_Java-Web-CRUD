
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Register</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </head>
    <body class="bg-dark">
        <%

            if(request.getAttribute("stMensaje")!=null 
                    && request.getAttribute("stTipo")!=null){
                
            
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
        <div class="container">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        
                        <div class="col-lg-12">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4"><b>Registrar Nueva Cuenta</b></h1>
                                </div>
                                <form class="user" action="LoginController" method="POST">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <label for="lblLogin">Usuario: </label>
                                            <input type="text" class="form-control" name="txtLogin" placeholder="Ingrese usuario">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <label for="lblPassword">Contraseña: </label>
                                            <input type="password" class="form-control" name="txtPassword" placeholder="Ingrese contraseña">
                                        </div>
                                    </div>
                                    <div class="form group">
                                        <div class="form row">
                                            <div class="col-sm-12">
                                                <label for="lblConfirmarPassword">Confirmar Contraseña: </label>
                                                <input type="password" class="form-control" name="txtConfirmarPassword" placeholder="Repita contraseña">
                                                <!--Estado-->
                                                <input type="number" hidden="" name="inEstado" value="1"/>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <input type="submit" name="btnRegistrar" class="btn btn-primary btn-block" value="Aceptar"/>
                                    <hr>
                                </form>
                                <div class="text-center">
                                    <a class="small" href="login.jsp">Iniciar Sesión</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
