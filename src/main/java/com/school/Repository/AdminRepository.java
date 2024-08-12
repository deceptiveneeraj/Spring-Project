package com.school.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.school.entities.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
}
