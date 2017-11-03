package cn.rong.ssh.dao;

import cn.rong.ssh.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

/**
 * Author:rong
 * Description:
 * Data: Create in 下午 4:59 17.11.2
 * Package: cn.rong.ssh.dao
 */
@Repository
@Table(name = "uer")
//@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<User , Long> {


    @Override
    List<User> findAll();

    /**
     * 通过名字查询用户
     * @param username
     * @return
    /* *//*
    @Query("select t from User t where t.name = :name")
    List<User> findUsersByUserName(@Param("name") String username);

    User findOne(Integer integer);*/
    User findUsersByNameAndAge();
}
