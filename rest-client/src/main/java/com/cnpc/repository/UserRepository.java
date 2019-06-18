package com.cnpc.repository;

import com.cnpc.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/17 10:04
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User,Long> {

    Page<User> findAll(Pageable pageable);

    User findById(long id);

    User findByEmail(String email);

    void deleteById(String id);


}
