package dao;

import model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String message;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate  = new JdbcTemplate(dataSource);
    }

    public int count() {
        String SQL = "select count(*) from Account";
        return jdbcTemplate.queryForObject(SQL, Integer.class);
    }

    @Transactional
    public void create(Account account) throws SQLException {
//        String SQL = "insert into Account(user_mail, user_password, user_name, user_birthday, user_phone, user_role, user_status) values('hoangtupham@gmail.com3', 'test123','Hoang Tu', '1997/12/13', '0914989487', 'admin', 1) "; //yyyy/mm/dd
        try {
            String SQL = "insert into Account (user_mail, user_password, user_name, user_birthday, user_phone, user_role, user_status) values (?,?,?,?,?,?,?)";
            jdbcTemplate.update(SQL, account.getUserMail(), hashPassword(account.getPassword()),account.getName(), account.getBirthday(), account.getPhone(), account.getRole(), account.getStatus());
//            jdbcTemplate.getDataSource().getConnection().commit();
        } catch (Exception exception) {
//            jdbcTemplate.getDataSource().getConnection().rollback();
            exception.printStackTrace();
        }
    }
    public boolean checkExist(Account account) {
        String SQL = "select count(*) from Account where user_mail = ?";
        int count = 0;
        try {
            System.out.println(account.getUserMail());
            count = jdbcTemplate.queryForObject(SQL, new Object[]{account.getUserMail()}, Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        if (count != 0) {
            //đã tồn tại
            this.message = "This email was exists!";
            return false;
        } else {
            //chưa tồn tại
            return true;
        }
    }
    public boolean login(Account account){
        String SQL = "select count(*) from Account where user_mail = ? and user_password = ?";
        int count = jdbcTemplate.queryForObject(SQL, new Object[]{account.getUserMail(), hashPassword(account.getPassword())}, Integer.class);
        if (count == 0) {
            //thông tin đăng nhập sai
            this.message = "Your email or password is not correct!";
            return false;
        } else {
            //thông tin đăng nhập đúng
            return true;
        }
    }
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }
    public String getMessage () {
        return this.message;
    }
    public List<Account> getAccountList () {
        String SQL = "select * from Account";
        System.out.println("Check");
        List<Account> accountList = new ArrayList<>();
        try {
            accountList = jdbcTemplate.query(SQL, new AccountMapper());
        } catch (Exception e){
            e.printStackTrace();
        }
        return accountList;
    }
    public Account getAccount (String userMail) {
        String SQL = "select * from Account where user_mail = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{userMail}, new AccountMapper());
    }
}