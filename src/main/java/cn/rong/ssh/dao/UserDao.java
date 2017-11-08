package cn.rong.ssh.dao;

import cn.rong.ssh.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author:rong
 * Description: 用户接口
 * Data: Create in 下午 6:53 17.11.7
 * Package: cn.rong.ssh.dao
 */
@Repository
public interface UserDao extends JpaRepository<User,Long>{

	@Override
	List<User> findAll();

	@Transactional
	@Query("select u from User u where u.name = ?1")
	User findUserByName(String name);


}
