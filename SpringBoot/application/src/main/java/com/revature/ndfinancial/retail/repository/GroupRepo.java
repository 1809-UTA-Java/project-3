package com.revature.ndfinancial.retail.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.revature.ndfinancial.retail.model.Group;

public interface GroupRepo extends MongoRepository <Group,String>{
	@Query("{'userId':?0}")
	List<Group> findByUserId(String id);
}
