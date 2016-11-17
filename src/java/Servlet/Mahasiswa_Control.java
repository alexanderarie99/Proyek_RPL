package Servlet;
import Method.*;
import java.sql.*;
public class Mahasiswa_Control {  
    Connection connection;
    DataBaseConnection database = new DataBaseConnection();
    public void insertKrs(int nim, String kode_matkul)
            throws SQLException {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO KRS VALUES (? , ?)";
        connection = database.getConnection();
        stmt = connection.prepareStatement(sql);
        stmt.setInt(1, nim);
        stmt.setString(2, kode_matkul);
        stmt.executeUpdate();
    }
    public void hapustKrs(int nim, String kode_matkul)
            throws SQLException {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM KRS WHERE NIM=? AND KODE_MATKUL=?";
        connection = database.getConnection();
        stmt = connection.prepareStatement(sql);
        stmt.setInt(1, nim);
        stmt.setString(2, kode_matkul);
        stmt.executeUpdate();
    }
    public boolean cekStatusKRS(int NIM, String kode_matkul)
            throws SQLException {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        String sql = "SELECT NIM, KODE_MATKUL FROM KRS WHERE NIM= ? AND "
                + "KODE_MATKUL= ?";
        connection = database.getConnection();
        stmt = connection.prepareStatement(sql);
        stmt.setInt(1, NIM);
        stmt.setString(2, kode_matkul);
        stmt.executeQuery();
        resultSet = stmt.executeQuery();
        return resultSet.next();
    } 
}
