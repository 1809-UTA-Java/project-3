package com.revature.ndfinancial.retail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ndfinancial.retail.model.AppForm;

@Repository
public interface ApplicationRepo extends JpaRepository<AppForm, String> {

	List<AppForm> findByUserId(String id);

}
