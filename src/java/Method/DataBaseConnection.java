package Method;


import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
public class DataBaseConnection {
// Sesuaikan properti jdbcURL dengan basis data anda
    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "hr";
    private String password = "apem";
    private Connection connection = null;
    public DataBaseConnection() {
        try {
            OracleDataSource ods;
            ods = new OracleDataSource();
            ods.setURL(jdbcURL);
            connection = ods.getConnection(user, password);
        } catch (SQLException ex) {
            System.out.println("message: " + ex.getMessage());
        }
    }

    public boolean isConnected() {
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean getClosed() {
        if (isConnected()) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
    public String getJdbcURL() {
        return jdbcURL;
    }
    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConn(Connection connection) {
        this.connection = connection;
    }
}
