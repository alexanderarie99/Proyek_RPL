<%@page import="Method.*"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/mainstyle.css">
        <title>Kartu KRS</title>
    </head>
    <body>

        <div id="container">
            <div id="header">
                <logo>
                    <img src="images/logo.png" width="120" height="120" alt="logo"/>
                </logo>
                <h1 align="center">Universitas Sanata Dharma</h1>
                <h2 align="center">Kartu KRS Mahasiswa</h2>
            </div>
            <div id="body">   
                <%
                    ArrayList<MataKuliah> list = new ArrayList<>();
                    list = (ArrayList<MataKuliah>) session.getAttribute("kartukrs");
                %>
                <form action="Logout" method="POST" align="right">
                    <input type="submit" value="Logout" name="Logout" />
                </form>
                <form action="Admin" method="GET" align="right">
                                    <input type="submit" value="Back" name="Back" />
                                </form>
                <table align="center" border="1" cellpadding="2" width="800">
                    <thead>
                        <tr>
                            <th>Kode Mata Kuliah</th>
                            <th>Mata Kuliah</th>
                            <th>Dosen Pengampu</th>
                            <th>SKS</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <%int total = 0;%>
                        <% for (int i = 0; i < list.size(); i++) { %>
                        <tr>
                            <td><% out.println(list.get(i).getKode_matkul());%></td>
                            <td><% out.println(list.get(i).getNama_matkul());%></td>                            
                            <td><% out.println(list.get(i).getNama_dosen());%></td>
                            <td><% out.println(list.get(i).getSks());%></td>
                            <% total += list.get(i).getSks();%>

                            <%}%>

                        </tr>
                        <tr><td colspan="3"><b>Total sks :</b> </td>
                            <td><b><%=total%></b></td>
                        </tr>
                    </tbody>
                </table>
                        
            </div>
            <div id="footer">
                 <p>Universitas Sanata Dharma &COPY; 2016</p>
            </div>
        </div>
    </body>
</html>
