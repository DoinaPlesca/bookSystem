package dal.database;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector{
    private SQLServerDataSource dataSource;

    public DatabaseConnector(){
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("BookAssignment");
        dataSource.setUser("CSe22B_23");
        dataSource.setPassword("CSe22B_23");
        dataSource.setPortNumber(1433);
        dataSource.setTrustServerCertificate(true);
    }
    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnector dataBaseConnection = new DatabaseConnector();
        Connection connection = dataBaseConnection.getConnection();

        System.out.println("Try to open tho " + !connection.isClosed());

        connection.close();
    }
}