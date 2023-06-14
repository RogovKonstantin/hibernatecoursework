import java.sql.*;

public class JDBC {

    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost/electronics_shop";
    private static final String user = "postgres";
    private static final String password = "postgres";


    public static void checkJDBC() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver is not found. Include it in your library path");
        }
    }

    public static void getAdminNameClientIdOrderNumberByOrderTotal(int total) {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement("select order_number, client_id, admin_name " +
                    "from zakaz WHERE total<?;");
            statement.setInt(1, total);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("order_number") + "(o_num) "
                        + resultSet.getString("client_id") + "(c_id) "
                        + resultSet.getString("admin_name") + "(a_name)\n");
            }
            statement.close();
            connection.close();
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
