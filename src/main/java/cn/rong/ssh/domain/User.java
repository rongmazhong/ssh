package cn.rong.ssh.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Author:rong
 * Description:
 * Data: Create in 下午 6:32 17.11.1
 * Package: cn.rong.ssh.domain
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id ;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "customerid")
    private int customerid;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", customerid=" + customerid +
                '}';
    }
}
