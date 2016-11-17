<%@page import="Servlet.*"%>
<%@page import="Method.*"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import="java.util.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/mainstyle.css">
        <title>Halaman Admin</title>
    </head>
    <%
        ArrayList<MahasiswaKrs> list = new ArrayList<>();
        list = (ArrayList<MahasiswaKrs>) session.getAttribute("krslist");
        MethodDosen dsn = (MethodDosen) session.getAttribute("dataDsn");
    %>
    <div id="container">
        <div id="header">
            <logo>
                <img src="images/logo.png" width="120" height="120" alt="logo"/>
            </logo>
            <h1 align="center">Universitas Sanata Dharma</h1>
            <h2 align="center">Halaman Admin</h2>
        </div>
        <div id="body">
            <form action="/ProjectWEB/Logout" method="POST" align="right">
                <input type="submit" value="Logout" name="Logout" />
                <h2 align="center">Dosen Login</h2>
                <table align="center" border="1" cellpadding="2">
                    <tr>
                        <th>Kode Dosen</th>
                        <th>Nama</th>
                        <th>Alamat</th>
                        <th>Email</th>
                    </tr>
                    <tr align="center">
                        <td><% out.println(dsn.getKode_dosen());%></td>                        
                        <td><% out.println(dsn.getNama());%></td>                        
                        <td><% out.println(dsn.getAlamat());%></td>                        
                        <td><% out.println(dsn.getEmail());%></td>                        
                    </tr>
                </table>
                <br>
                <h2 align="center">Daftar Mahasiswa KRS</h2>


                <table align="center" border="1" cellpadding="1" width="800">
                    <thead>
                        <tr>
                            <th>NIM</th>
                            <th>Nama Mahasiswa</th>
                            <th>Total SKS</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < list.size(); i++) { %>
                        <tr align="center">
                            <td><% out.println(list.get(i).getNim());%></td>
                            <td><% out.println(list.get(i).getNama());%></td>
                            <td><% out.println(list.get(i).getTotalSks());%></td>
                            <td align='center'><a href="/ProjectWEB/KartuKRS?NIM=<%=list.get(i).getNim()%>" >Detail</a></td>
                            <% }%>
                        </tr>
                    </tbody>
                </table>
            </form>


        </div>
        <div id="footer">
            <p>Universitas Sanata Dharma &COPY; 2016</p>
        </div>
    </div>
</body>
</html>
