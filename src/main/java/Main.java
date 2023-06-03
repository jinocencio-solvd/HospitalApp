import com.laba.jdbc.PersonsDAO;

public class Main {
    public static void main(String[] args) {
        PersonsDAO personsDAO = new PersonsDAO();
        personsDAO.deleteById(21);

    }
}
