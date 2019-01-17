package com.groupeight.quwen.repository;

import com.groupeight.quwen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByOpenid(String openid);

}
