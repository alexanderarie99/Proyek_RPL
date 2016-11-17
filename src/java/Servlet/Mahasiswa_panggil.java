package Servlet;
import Method.MataKuliah;
import Method.MethodKrs;
import Method.DataBaseConnection;
import Method.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Mahasiswa_panggil {

    Connection connection;
    DataBaseConnection database = new DataBaseConnection();

    public ArrayList<MataKuliah> listMat() throws SQLException {
        connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<MataKuliah> mtList = new ArrayList<MataKuliah>();
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT m.*, d.NAMA_DOSEN "
                + "FROM MATAKULIAH m, DOSEN d WHERE d.KODE_DOSEN=m.KODE_DOSEN "
                + "ORDER BY m.kode_matkul");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            MataKuliah mtk = new MataKuliah();
            mtk.setKode_matkul(resultSet.getString("kode_matkul"));
            mtk.setNama_matkul(resultSet.getString("nama"));
            mtk.setSks(resultSet.getInt("sks"));
            mtk.setKode_dosen(resultSet.getString("kode_dosen"));
            mtk.setNama_dosen(resultSet.getString("nama_dosen"));
            mtList.add(mtk);
        }
        return mtList;
    }

    public ArrayList<MethodMahasiswa> listMhs() throws SQLException {
        connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<MethodMahasiswa> mhsList = new ArrayList<MethodMahasiswa>();
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT * FROM MAHASISWA ORDER BY nim");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            MethodMahasiswa mhs = new MethodMahasiswa();
            mhs.setNim(resultSet.getInt("nim"));
            mhs.setNama(resultSet.getString("nama"));
            mhs.setAlamat(resultSet.getString("alamat"));
            mhs.setEmail(resultSet.getString("email"));
            mhsList.add(mhs);
        }
        return mhsList;
    }

    public MethodMahasiswa dataMhs(int nim) throws SQLException {
        connection = null;
        PreparedStatement statement;
        ResultSet resultSet;
        MethodMahasiswa mhs = new MethodMahasiswa();
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT nim, nama, alamat, email"
                + " FROM MAHASISWA where nim = ?");
        statement.setInt(1, nim);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            mhs.setNim(resultSet.getInt("nim"));
            mhs.setNama(resultSet.getString("nama"));
            mhs.setAlamat(resultSet.getString("alamat"));
            mhs.setEmail(resultSet.getString("email"));
        }
        return mhs;
    }
}