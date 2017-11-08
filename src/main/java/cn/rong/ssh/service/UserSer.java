package cn.rong.ssh.service;

import cn.rong.ssh.dao.UserDao;
import cn.rong.ssh.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:rong
 * Description:
 * Data: Create in 下午 7:15 17.11.7
 * Package: cn.rong.ssh.service
 */
@Service
public class UserSer {
	@Autowired
	private UserDao userDao;
	public User findUserByName(String name){
		User user = userDao.findUserByName(name);
		return user;
	}
}
