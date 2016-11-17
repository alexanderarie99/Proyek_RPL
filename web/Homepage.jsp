<%@page import="Servlet.*"%>
<%@page import="Method.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>KRS Online</title>
        <link type="text/css" rel="stylesheet" href="css/mainstyle.css">
    </head>
    <body>
        <% ArrayList<MataKuliah> list = new ArrayList<>();
            list = (ArrayList<MataKuliah>) session.getAttribute("mtkList");
        %>
        <div id="container">
            <div id="header">
                <logo>
                    <img src="images/logo.png" width="120" height="120" alt="logo"/>
                </logo>
                <h1 align="center">Universitas Sanata Dharma</h1>
                <h2 align="center">KRS ONLINE</h2>
            </div>
            <div id="body">
                <form action="/ProjectWEB/Home" method="POST" align="right">
                    <input type="text" name="username" value="" size="10"/>
                    <input type="password" name="password" value="" size="10"/>
                    <input type="submit" value="Login" name="login" />
                </form>

                <h2 align="center" style="font-family: Arial; font-size: 16pt;
                    color: black">Daftar Mata Kuliah </h2>
                <table border="1" cellpadding="2" width="800" align="center">
                    <thead>
                        <tr>
                            <th>Kode Mata Kuliah</th>
                            <th>Nama Mata Kuliah</th>
                            <th>SKS</th>
                            <th>Nama Dosen</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < list.size(); i++) { %>
                        <tr>
                            <td><% out.println(list.get(i).getKode_matkul());%></td>
                            <td><% out.println(list.get(i).getNama_matkul());%></td>
                            <td><% out.println(list.get(i).getSks());%></td>
                            <td><% out.println(list.get(i).getNama_dosen());%></td>
                            <% }%>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div id="footer" >
                <p>Universitas Sanata Dharma &COPY; 2016</p>
            </div>
        </div>
</html>
