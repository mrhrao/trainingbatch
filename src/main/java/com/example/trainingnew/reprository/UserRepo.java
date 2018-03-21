package com.example.trainingnew.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingnew.model.UserPojo;

public interface UserRepo extends JpaRepository<UserPojo ,Long>{

	UserPojo findOneById(long id);

}
