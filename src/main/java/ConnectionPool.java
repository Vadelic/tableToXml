import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Komyshenets on 05.09.2018.
 */
public class ConnectionPool {
    private Connection connection = null;

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL("");
            dataSource.setUser("");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public ResultSet cursor(String sql) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
       return preparedStatement.executeQuery();
    }
}
