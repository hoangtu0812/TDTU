import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) throws Exception {
//        String url = "jdbc:mysql://localhost:3306/id17411881_tdtdb";
//        String username = "id17411881_hoangtu0812@2a02:4780:bad:c0de::13";
//        String url = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6509306";
//        String username = "sql6509306";
//        String password = "3xpdPI68KW";
//
//        System.out.println("Connecting database...");
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }
        String sDate1="1999-08-12";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        System.out.println(sDate1);

    }
}

