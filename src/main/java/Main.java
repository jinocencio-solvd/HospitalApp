import com.laba.jdbc.PersonsDAO;
import com.laba.model.Persons;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.laba.utils.ConnectionPool;

public class Main {
    public static void main(String[] args) {
        PersonsDAO personsDAO = new PersonsDAO();
        personsDAO.getAll();

    }
}
