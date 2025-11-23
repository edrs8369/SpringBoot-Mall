package com.Max.springboot_mall.rowmapper;


import com.Max.springboot_mall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UserRowMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer userId = rs.getInt("user_Id");
        String email = rs.getString("email");
        String password = rs.getString("password");
        Date createdDate = rs.getTimestamp("created_date");
        Date lastModifiedDate = rs.getTimestamp("last_modified_date");

        User user = new User();
        user.setUserId(userId);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedDate(createdDate);
        user.setLastModifiedDate(lastModifiedDate);

        return user;
    }
}
