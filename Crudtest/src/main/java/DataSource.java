import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;
import java.lang.*;

import static java.sql.DriverManager.getConnection;

public abstract class DataSource {

    public Connection getDBConnection(String url, String username, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getConnection(url, username, password);
    }

}
