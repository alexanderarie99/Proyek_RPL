package Method;
import java.sql.*;
public class LoginStatus {
    Connection connection;
    DataBaseConnection database = new DataBaseConnection();
    public String[] CekLogin(String username, String password) throws SQLException{
        String[] data=new String[3];
        connection = null;
        PreparedStatement stmt;
        ResultSet resultSet;
        try {
            connection = database.getConnection();
            stmt = connection.prepareStatement("SELECT NIM, Password from "
                    + "MAHASISWA WHERE nim= ? and password= ?");
            stmt.setInt(1, Integer.parseInt(username));
            stmt.setString(2, password);
            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                data[0]=username;
                data[1]=password;
                data[2]="mahasiswa";
            }
        }catch (SQLException | NumberFormatException e){
            
        }
        try{
            connection = database.getConnection();
            stmt = connection.prepareStatement("SELECT KODE_DOSEN, "
                    + "Password from DOSEN "
                    + "WHERE KODE_DOSEN= ? and password= ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            resultSet = stmt.executeQuery();
            
            if(resultSet.next()){
                data[0]=username;
                data[1]=password;
                data[2]="admin";
            }
        }catch (SQLException e){
            
        }
        return data;
    }
}
