package cn.rong.ssh;

import cn.rong.ssh.dao.UserRepository;
import cn.rong.ssh.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SshApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(SshApplication.class);
	@Test
	public List<User> getAll(UserRepository userRepository) {
		List<User> users =  userRepository.findAll();
		log.info("得到所有用户");
		for (User user : users) {
		    log.info(user.toString());
		}
		return users;
	}


}
