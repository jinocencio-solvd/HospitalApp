import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.laba.utils.ConnectionPool;

public class Main {
    private static final Connection connection = ConnectionPool.getInstance().getConnection();
    public static void main(String[] args) {
        try {
            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT* FROM hospital.persons");
            ResultSet rs = statement.executeQuery("SELECT* FROM persons");
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
