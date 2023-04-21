package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import java.sql.Timestamp;
import com.example.repo.MyUserRepo;

import com.example.model.MyUser;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MyUserRepoTest {
	
	@Autowired
	private MyUserRepo repo;
	
	@Autowired
	private TestEntityManager entityManager;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	//test if user is successfully added to the database
	@Test
	public void testCreateUser() {
		MyUser user = new MyUser();
		user.setEmail("czajka027@gmail.com");
		user.setRegistered(timestamp);
		user.setTitle("Miss");
		user.setFirst_name("Patricia");
		user.setLast_name("Smith");
		user.setAddress_line_1("100 High Street");
		user.setAddress_line_2(null);
		user.setCity("London");
		user.setPostcode("WC2N 5DU");
		user.setPhone_number("+44 1234 456789");
		
		MyUser savedUser = repo.save(user);
		
		MyUser existUser = entityManager.find(MyUser.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
}
