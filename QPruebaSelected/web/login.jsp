<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        
        <script>
            function mensaje()
            {
                swal("Buen trabajo","Se realizo el procreso con exito","success")
            }
        </script>
    </head>
    <body class="bg-dark">
        <!--SCRIPTLETS-->
        <%
            if(request.getAttribute("stError")!=null )
            {   
            
        %>
        <!--Parte Especial-->
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stError")%>"/>
        <script>
            var stMensaje = document.getElementById("txtMensaje").value;
            swal("Mensaje", stMensaje, "error");
        </script>
        <%
            }
        %>
        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4"><b>¡Bienvenido de Nuevo!</b></h1>
                                        </div>
                                        <form action="LoginController" method="POST">
                                            <div class="form-group">
                                                <label for="lblEmail">Email:</label>
                                                <input type="email" class="form-control form-control-user" name="txtEmail" aria-describedby="emailHelp" placeholder="Ingrese email">
                                            </div>
                                            <div class="form-group">
                                                <label for="lblPassword">Contraseña:</label>
                                                <input type="password" class="form-control form-control-user" name="txtPassword" placeholder="Ingrese contraseña">
                                            </div>
                                            <input name="btnAutenticar" type="submit" class="btn btn-primary btn-block" value="Aceptar"/> 
                                           
                                        </form>
                                        <hr>
                                        <div class="text-center">
                                            <a class="small" href="register.jsp">¡Crear Cuenta Nueva!</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
