package com.leleproperty.leleproperty.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leleproperty.leleproperty.model.dao.Role;







@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String string);
  
}
