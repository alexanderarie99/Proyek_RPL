/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Method.MahasiswaKrs;
import Servlet.Mahasiswa_panggil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KartuKRS extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        Servlet.Krs_Control mhs = new Servlet.Krs_Control();
        int nim=0;
        nim=Integer.parseInt(request.getParameter("NIM"));
        
        if(session.getAttribute("DataLogin")!=null){
           String[] DataLogin=(String[]) session.getAttribute("DataLogin");
            if(DataLogin[2].equals("admin")){
                try {
                        ArrayList<Method.MataKuliah> krsList = mhs.kartukrs(nim);
                        session.setAttribute("kartukrs", krsList);
                        request.getRequestDispatcher("kartuKrs.jsp").forward(request, response);
                } catch (Exception ex) {}
            }
            }else{
                response.sendRedirect("/ProjectWEB/Home");
            }

    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                
        
        }
        
   

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


