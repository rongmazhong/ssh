package cn.rong.ssh.dao;

import cn.rong.ssh.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:rong
 * Description: 用户接口
 * Data: Create in 下午 6:53 17.11.7
 * Package: cn.rong.ssh.dao
 */
@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate HIBERNATE_TEMPLATE;
	/*@Autowired
	private User user;*/

	public List<User> getUser(String name){
		String sql = "select count(*) from User u where u.username=myname";
		String paramName="myname";
		List<User> users= (List<User>) HIBERNATE_TEMPLATE.findByNamedQueryAndNamedParam(sql,paramName,name);
		return users;
	}
}
