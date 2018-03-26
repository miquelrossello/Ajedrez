package connector_mysql;

import java.sql.*;

public class Connector {

    public static Connection connector(String user, String password) {
        String url = "jdbc:mysql://localhost/Ajedrez";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}

/*class TestConnection {
    public static void main(String[] args) {
        Connection conn = Connector.connector("root", "1998");
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SHOW TABLES");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

class InsertData {
    public static void main(String[] args) {
        Connection conn = Connector.connector("root", "1998");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO Usuario (nombre, apellido_1, apellido_2, fecha_nacimiento, sexo) VALUES ('Miquel', 'Rosselló', 'Melis', '1998-08-08', 'Hombre')");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}*/
