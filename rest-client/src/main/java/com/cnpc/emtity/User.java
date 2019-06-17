package com.cnpc.emtity;

import cn.hutool.core.date.DateUtil;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/17 9:39
 * @Version 1.0
 **/
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    private String userName;

    @Email(message = "请输入正确的email")
    private String email;

    @Min( value = 0,message = "年龄必须是正整数")
    @Max( value = 130,message = "请输入正确的年龄")
    private Integer age;

    @Past
    @Column(nullable = false)
    private Date birthday;

    public User(){

    }

    public User(String userName,String email,Integer age,String birthday){
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.birthday = DateUtil.parse( birthday,"yyyy-MM-dd" );
    }


}
