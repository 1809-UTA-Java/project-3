package com.revature.ndfinancial.retail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.revature.ndfinancial.retail.model.Offer;

public interface OfferRepo extends MongoRepository<Offer,String> {
	
}
