<%@page import="Method.MethodKrs"%>
<%@page import="Method.*"%>
<%@page import="Servlet.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Halaman Mahasiswa</title>
        <link type="text/css" rel="stylesheet" href="css/mainstyle.css">
    </head>
    <body>
        <%
            String[] DataLogin = (String[]) session.getAttribute("DataLogin");
            ArrayList<MataKuliah> list = (ArrayList<MataKuliah>) session.getAttribute("mtkList");
            MethodMahasiswa mhs = (MethodMahasiswa) session.getAttribute("dataMhs");

            Mahasiswa_Control m = new Mahasiswa_Control();
            int username = Integer.parseInt(DataLogin[0]);
        %>  
        <div id="container">
            <div id=header>
                <logo>
                    <img src="images/logo.png" width="120" height="120" alt="logo"/>
                </logo>
                <h1 align="center">Universitas Sanata Dharma</h1>
                <h2 align="center">Halaman Mahasiswa</h2>
            </div>
            <div id="body"> 
                <form action="/ProjectWEB/Logout" method="POST" align="right">
                    <input type="submit" value="Logout" name="Logout" />
                </form>
                <h2 align="center" style="font-family: Arial; font-size: 16pt;
                    color: black" >Mahasiswa Login</h2>
                <table align="center" border="1" cellpadding="2">
                    <tr>
                        <th>NIM</th>
                        <th>Nama</th>
                        <th>Alamat</th>
                        <th>Email</th>
                    </tr>
                    <tr align="center">
                        <td><% out.println(mhs.getNim());%></td>                        
                        <td><% out.println(mhs.getNama());%></td>                        
                        <td><% out.println(mhs.getAlamat());%></td>                        
                        <td><% out.println(mhs.getEmail());%></td>                        
                    </tr>
                </table>
                <br>

                <h2 align="center" style="font-family: Arial; font-size: 16pt;
                    color: black">Tabel KRS </h2>
                <form action="/ProjectWEB/Mahasiswa" method="POST" align='center'>
                    <select name="matkul">
                        <% for (int i = 0; i < list.size(); i++) { %>
                        <option><%out.println(list.get(i).getKode_matkul() + " -- " + list.get(i).getNama_matkul()); %></option>
                        <% }%>
                    </select>
                    <input type="submit" value="Proses" />
                </form>

                <table align="center" border="1" cellpadding="2" width="800">
                    <thead>
                        <tr>
                            <th>Kode Mata Kuliah</th>
                            <th>Nama Mata Kuliah</th>
                            <th>SKS</th>
                            <th>Nama Dosen</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <% for (int i = 0; i < list.size(); i++) { %>
                        <tr>
                            <td><% out.println(list.get(i).getKode_matkul());%></td>
                            <td><% out.println(list.get(i).getNama_matkul());%></td>
                            <td><% out.println(list.get(i).getSks());%></td>
                            <td><% out.println(list.get(i).getNama_dosen());%></td>
                            <td>
                                <%
                                    if (m.cekStatusKRS(username, list.get(i).getKode_matkul())) {
                                %> <font color='blue'><b>Sudah Diambil</b></font>
                                <%} else {%>Tidak Diambil
                                <%}%>
                            </td>
                            <% }%>
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
