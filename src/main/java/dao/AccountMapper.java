package dao;

import model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();

        account.setUserMail(rs.getString("user_mail"));
        account.setPassword(rs.getString("user_password"));
        account.setName(rs.getString("user_name"));
        account.setBirthday(rs.getDate("user_birthday"));
        account.setPhone(rs.getString("user_phone"));
        account.setRole(rs.getString("user_role"));
        account.setStatus(Integer.parseInt(rs.getString("user_status")));

        return account;
    }
}
