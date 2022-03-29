<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            int contador = 0;
            Cookie[] cooki = request.getCookies();
            if (cooki != null) {
                for (Cookie c : cooki) {
                    if (c.getName().equals("aplicacion")) {
                        contador = Integer.parseInt(c.getValue());
                        
                        }
                    }
                }
            if (contador == 0) {
        %>
        <h1>Bienvenido a nuestro sitio Web</h1>
        <%
        } else {
        %>
        <h2>Gracias por visitarnos nuevamente</h2>
        <%
            }
        %>

        <a href="BienvenidoServlet">Cuantas visitas realizo a esta pagina</a>
    </body>
</html>
