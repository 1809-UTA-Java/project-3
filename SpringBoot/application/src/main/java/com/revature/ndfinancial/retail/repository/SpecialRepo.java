package com.revature.ndfinancial.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ndfinancial.retail.model.Special;

@Repository
public interface SpecialRepo extends JpaRepository<Special, String> {

}
