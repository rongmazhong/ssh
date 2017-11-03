package cn.rong.ssh.service;

import cn.rong.ssh.dao.UserRepository;
import cn.rong.ssh.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:rong
 * Description:
 * Data: Create in 下午 5:31 17.11.2
 * Package: cn.rong.ssh.service
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    /*public List<User> findusersByName(String usename){
        return userRepository.findusersByName(usename);
    }*/
    /*public User findOne(Integer aLong){
        return userRepository.findOne(aLong);
    }*/

}
