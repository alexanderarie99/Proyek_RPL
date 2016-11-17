import Servlet.*;
import Method.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class Mahasiswa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        Mahasiswa_panggil mhs = new Mahasiswa_panggil();
        
        if(session.getAttribute("DataLogin")!=null){
           String[] DataLogin=(String[]) session.getAttribute("DataLogin");
            if(DataLogin[2].equals("mahasiswa")){
                try {
                    MethodMahasiswa mhsList = mhs.dataMhs(Integer.parseInt(DataLogin[0]));
                    ArrayList<MataKuliah> mtkList = mhs.listMat();
                        session.setAttribute("dataMhs", mhsList);
                        session.setAttribute("mtkList", mtkList);
                        request.getRequestDispatcher("Mahasiswa.jsp").forward(request, response);
                } catch (Exception ex) {  
                }
            }
        } else {
            response.sendRedirect("/ProjectWEB/Home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String[] DataLogin;
        Mahasiswa_Control mhs = new Mahasiswa_Control();
        String matkul=request.getParameter("matkul").substring(0, 4);
        
        if(session.getAttribute("DataLogin")!=null){
            DataLogin=(String[]) session.getAttribute("DataLogin");
            int username=Integer.parseInt(DataLogin[0]);
            
            if(DataLogin[2].equals("mahasiswa")){
                try {
                    if(mhs.cekStatusKRS(username, matkul)==true){
                        mhs.hapustKrs(username, matkul);
                    }else{
                        mhs.insertKrs(username, matkul);
                    }
                } catch (Exception ex) {
                    
                }
                response.sendRedirect("/ProjectWEB/Mahasiswa");
            }
        }else{
            response.sendRedirect("/ProjectWEB/Home");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
