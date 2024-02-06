package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {
    public static Connection getConnectioin(){
        Connection connection =null;
        try {
            connection= DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/postgres",
                    "postgres",
                    "postgres"
            );
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
