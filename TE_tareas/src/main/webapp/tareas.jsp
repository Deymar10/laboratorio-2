<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AGREGAR TAREA </h1>
        <form action="NuevaTarea" method="POST">
            <tr>
                <td>id</td>
                <td><input type = "text" name ="id" value=""></td>
            </tr>
            <tr>
                <td>tarea</td>
                <td><input type = "text" name ="tarea" value=""></td>
            </tr>
            <tr>
                <td></td>
                <td><input type = "submit" value="Agregar"></td>
            </tr>            
        </form>
    </body>
</html>
