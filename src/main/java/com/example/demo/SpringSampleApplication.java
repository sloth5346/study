package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.login.domain.model.User;

@SpringBootApplication
public class SpringSampleApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbc;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSampleApplication.class, args);
		//System.out.println("DATASOURCE = " + dataSource);
		
		//String url = "jdbc:oracle:thin:@//localhost:1521/orcl_19c";
        //String user = "TANAKA";
        //String pass = "Ta0520pp";
        //try (Connection con = DriverManager.getConnection(url, user, pass);
        //        Statement stmt = con.createStatement();) {
        //    // 登録実行
        //    ResultSet rs = stmt.executeQuery("select * from m_user");
        //    while (rs.next()) {
        //        System.out.println(rs.getString("user_id"));
        //        System.out.println(rs.getString("password"));
        //    }
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
	}
	
	@Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

       ///Get dbcp2 datasource settings
       //BasicDataSource newds = (BasicDataSource) dataSource;
       //System.out.println("BasicDataSource = " + newds.getInitialSize());

        System.out.println("Display all customers...");
        List<User> list = selectMany();
        list.forEach(x -> System.out.println(x));

        System.out.println("Done!");

    }
	
	private List<User> selectMany() throws DataAccessException {
		
		List<Map<String, Object>> getList = 
				jdbc.queryForList("SELECT * FROM m_user");
		
		List<User> userList = new ArrayList<>();
		
		for(Map<String, Object>map : getList) {
			
			User user = new User();
			
			user.setUserId((String)map.get("user_id"));
			user.setPassword((String)map.get("password"));
			user.setUserName((String)map.get("user_name"));
			user.setBirthday((Date)map.get("birthday"));
			user.setAge((BigDecimal)map.get("age"));
			user.setMarriage((String)map.get("marriage"));
			user.setRole((String)map.get("role"));
			
			userList.add(user);

		}
		return userList;
		
	}

}
