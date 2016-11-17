package Servlet;
import Method.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Krs_Control {
    Connection connection;
    DataBaseConnection database = new DataBaseConnection();
    
    public ArrayList<MethodKrs> listKrs() throws SQLException {
        connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<MethodKrs> krsList = new ArrayList<MethodKrs>();
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT * FROM KRS");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            MethodKrs krs = new MethodKrs();
            krs.setKode_matkul(resultSet.getString("kode_matkul"));
            krs.setNim(resultSet.getInt("nim"));
            krsList.add(krs);
        }
        return krsList;
    }
   
    public ArrayList<MahasiswaKrs> mhsKrs() throws SQLException {
        connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<MahasiswaKrs> krsList = new ArrayList<MahasiswaKrs>();
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT DISTINCT i.NIM, MAHASISWA.NAMA,\n"
                + "(SELECT SUM(m.SKS) FROM MATAKULIAH m, KRS k WHERE m.KODE_MATKUL = k.KODE_MATKUL "
                + "and k.NIM=i.NIM GROUP BY k.NIM) as \"Total SKS\"\n"
                + "FROM KRS i, MAHASISWA WHERE MAHASISWA.NIM = i.NIM ORDER BY i.NIM");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            MahasiswaKrs krs = new MahasiswaKrs();
            krs.setNim(resultSet.getInt("nim"));
            krs.setNama(resultSet.getString("nama"));
            krs.setTotalSks(resultSet.getInt("Total SKS"));

            krsList.add(krs);
        }
        return krsList;
    }

    public ArrayList<MataKuliah> kartukrs(int nim) throws SQLException {
        connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<MataKuliah> kartukrs = new ArrayList<MataKuliah>();
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT m.*, d.NAMA_DOSEN FROM MATAKULIAH m, DOSEN d, KRS k, MAHASISWA mah "
                + "WHERE d.KODE_DOSEN=m.KODE_DOSEN and m.KODE_MATKUL = k.KODE_MATKUL "
                + "and mah.NIM = k.NIM  and mah.NIM=?");
        statement.setInt(1, nim);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
              MataKuliah kartu = new MataKuliah();
            kartu.setKode_matkul(resultSet.getString("kode_matkul"));
            kartu.setNama_matkul(resultSet.getString("nama"));
            kartu.setSks(resultSet.getInt("sks"));
            kartu.setNama_dosen(resultSet.getString("nama_dosen"));
          kartukrs.add(kartu);
        }
        return kartukrs;
    }
    
   public MethodDosen dataDosen(String kode) throws SQLException {
        connection = null;
        PreparedStatement statement;
        ResultSet resultSet;
        MethodDosen dsn = new MethodDosen();
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT kode_dosen, nama_dosen, "
                + "alamat, email FROM Dosen where kode_dosen = ?");
        statement.setString(1, kode);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            dsn.setKode_dosen(resultSet.getString("kode_dosen"));
            dsn.setNama(resultSet.getString("nama_dosen"));
            dsn.setAlamat(resultSet.getString("alamat"));
            dsn.setEmail(resultSet.getString("email"));
        }
        return dsn;
    } 
}
