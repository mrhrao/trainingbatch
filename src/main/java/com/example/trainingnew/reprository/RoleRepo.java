package com.example.trainingnew.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingnew.model.Rolepojo;

public interface RoleRepo extends JpaRepository<Rolepojo, Long>{

	Rolepojo findOneById(long id);

}
