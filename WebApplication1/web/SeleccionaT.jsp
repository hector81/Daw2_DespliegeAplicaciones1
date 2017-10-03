<%-- 
    Document   : SeleccionaT
    Created on : 25-feb-2017, 21:42:27
    Author     : user
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seleccionar Tabla</title>
        <script>
            function capturarResultadoSelect(tabla1) {
                localStorage.setItem("tabla1", tabla1);
            }

            window.onload = function inicio() {
                tablaSeleccionar1 = document.getElementById("tabla1");
                //Elegimos la tabla
                tablaElegida1 = tablaSeleccionar1.options[tablaSeleccionar1.selectedIndex].value;
                localStorage.setItem("tabla1", tablaElegida1);//enviamos
            }
        </script>
    </head>
    <body>
        <%
        String base="";
        base = request.getParameter("BASE");
        %>
        <p>Elige tabla</p>
        <p><%=base%></p>
        <form method="post" action="Modificar.html">
            <select id="tabla" onchange="capturarResultadoSelect(this.value)">
                <%
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://127.0.0.1:3306";
                        String username = "root";
                        Connection conn = DriverManager.getConnection(url, username, "");
                        String consultaTabla = "SELECT table_name FROM information_schema.tables where table_schema='" + base+"';";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(consultaTabla);
                        while (rs.next()) {
                %>
                <option value="<%=rs.getString("table_name")%>"><%=rs.getString("table_name")%><option>        
                    <%
                        }

                    %>
            </select>
            <input type="submit" value="Enviar">
            <%                    
                    rs.close();
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </form>
    </body>
</html>
