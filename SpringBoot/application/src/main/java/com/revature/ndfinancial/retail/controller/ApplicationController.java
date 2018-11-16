package com.revature.ndfinancial.retail.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ndfinancial.retail.model.AppForm;
import com.revature.ndfinancial.retail.model.Group;
import com.revature.ndfinancial.retail.model.Offer;
import com.revature.ndfinancial.retail.model.Offers;
import com.revature.ndfinancial.retail.model.Special;
import com.revature.ndfinancial.retail.model.Specials;
import com.revature.ndfinancial.retail.repository.ApplicationRepo;
import com.revature.ndfinancial.retail.repository.GroupRepo;
import com.revature.ndfinancial.retail.repository.OfferRepo;
import com.revature.ndfinancial.retail.repository.SpecialRepo;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
	@Autowired
	private ApplicationRepo app_repo;

	@Autowired
	private GroupRepo group_repo;

	@Autowired
	private OfferRepo offer_repo;

	@Autowired
	private SpecialRepo special_repo;

	@PostMapping("/")
	public AppForm postApplication(@RequestBody AppForm newApp) {
		newApp.setId(UUID.randomUUID().toString());
		return app_repo.save(newApp);
	}

	@DeleteMapping("/{id}")
	public String deleteApplication(@PathVariable(value = "id") String id) {
		Optional<AppForm> _appForm = app_repo.findById(id);

		if (_appForm.isPresent()) {
			AppForm deleteApp = _appForm.get();
			deleteApp.setActive(false);
			app_repo.save(deleteApp);
			return id+" deleted";
		} else {
			return "Id not found";
		}
	}

	@GetMapping("/{id}")
	public AppForm getApplicationById(@PathVariable(value = "id") String id) {

		Optional<AppForm> _appForm = app_repo.findById(id);

		if (_appForm.isPresent()) {
			return _appForm.get();
		} else {
			return null;
		}

	}

	@PutMapping("/{id}")
	public String putApplication(@PathVariable(value = "id") String id, @RequestBody AppForm appForm) {
		Optional<AppForm> _appForm = app_repo.findById(id);

		if (_appForm.isPresent()) {
			appForm.setId(id);
			app_repo.save(appForm);
			return "update completed";
		} else {
			return "no id found";
		}
	}
	
	@GetMapping("/offer")
	public Offers getAllOffers() {
		Offers offers = new Offers();
		List <Offer> offerList = offer_repo.findAll();
		for(Offer offer: offerList) {
			if(offer.getActive() == true) {
				offers.getResult().add(offer);
			}
		}
		return offers;
	}

	@GetMapping("/offer/user/{id}")
	public Offers getUserOffers(@PathVariable(value = "id") String userId) {
		List<Group> _userGroups = group_repo.findByUserId(userId);
		List<Group> userGroups = new ArrayList<Group>();
		for(Group group: _userGroups) {
			if(group.getActive()==true) {
				userGroups.add(group);
			}
		}
		List<String> groupList = new ArrayList<String>();
		List<Offer> offers = new ArrayList<Offer>();
		
		for (Group group : userGroups) {
			groupList.add(group.getUserId().toString());
		}
		
		List<Offer> _allOffers = offer_repo.findAll();
		List<Offer> allOffers = new ArrayList<Offer>();
		
		for(Offer offer: _allOffers) {
			if(offer.getActive() ==true) {
				allOffers.add(offer);
			}
		}
		
		for (Offer offer : allOffers) {
			for (String _group : offer.getTarget()) {
				for (String _groupId : groupList) {
					if (_groupId.equals(_group)) {
						offers.add(offer);
					}
				}
			}
		}
		
		Offers result = new Offers();
		result.setResult(offers);
		
		return result;

	}

	@PostMapping("/offer")
	public Offer postOffer(@RequestBody Offer offer) {
		offer_repo.save(offer);
		return offer;
	}

	@PutMapping("/offer/{id}")
	public Offer putOffer(@PathVariable(value = "id") String id, @RequestBody Offer offer) {
		
		Optional <Offer> _offer = offer_repo.findById(id);
		if(_offer.isPresent()) {
			offer_repo.save(offer);
			return offer;
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/offer/{id}")
	public String deleteOffer(@PathVariable(value = "id")String id) {
		Optional <Offer> _offer = offer_repo.findById(id);
		
		if(_offer.isPresent()) {
			Offer offer = _offer.get();
			offer.setActive(false);
			offer_repo.save(offer);
			return id+" deleted";
		}else {
			return id+" not found";
		}
	}
	
	@PostMapping("/special")
	public Special postSpecial(@RequestBody Special special){
		special.setId(UUID.randomUUID().toString());
		special_repo.save(special);
		return(special);
	}
	@GetMapping("/special")
	public Specials getAllSpecials() {
		List<Special> _specialList = special_repo.findAll();
		List<Special> specialList = new ArrayList<Special>();
		for(Special special: _specialList) {
			if(special.getActive() == true) {
				specialList.add(special);
			}
		}
		Specials specials =new Specials();
		specials.setResults(specialList);
		return specials;
	}
	@GetMapping("/special/{id}")
	public Special getSpecialById(@PathVariable(value="id") String id){
		Optional <Special> _special = special_repo.findById(id);
		if(_special.isPresent()) {
			return _special.get();
		}else {
			return null;
		}
	}
	
	@PutMapping("/special/{id}")
	public String putSpecial(@PathVariable(value="id")String id, @RequestBody Special special) {
		Optional <Special> _special = special_repo.findById(id);
		if(_special.isPresent()) {
			special_repo.save(special);
			return "Update complete";
		}else {
			return "Could not find Id";
		}
	}
	@DeleteMapping("/special/{delete}")
	public String deleteSpecial(@PathVariable(value="id")String id) {
		Optional <Special> _special = special_repo.findById(id);
		if(_special.isPresent()) {
			Special special = _special.get();
			special.setActive(false);
			return id+" deleted";
		}else {
			return id+ " special not found";
		}
	}
	
	@GetMapping("/group")
	public List<Group> getAllGroups() {
		List<Group> _groupList = group_repo.findAll();
		List<Group> groupList = new ArrayList<Group>();
		for (Group group: _groupList) {
			if(group.getActive() == true) {
				groupList.add(group);
			}
		}
		
		return groupList;
	}
	
	@PostMapping("/group")
	public Group postGroup(@RequestBody Group group) {
		group_repo.save(group);
		return group;
	}
	
	@DeleteMapping("/group/{id}")
	public String deleteGroup(@PathVariable(value = "id") String id){
		Optional <Group> _group= group_repo.findById(id);
		if(_group.isPresent()) {
			Group group =_group.get();
			group.setActive(false);
			group_repo.save(group);
			return id+" Deleted";
		}else {
			return id+" Not Found";
		}
	}
	
	@GetMapping("group/{id}")
	public Group getGroupById(@PathVariable(value = "id") String id) {
		Optional <Group> _group = group_repo.findById(id);
		if(_group.isPresent()) {
			return _group.get();
		}else {
			return null;
		}
	}
	
	@PutMapping("group/{id}")
	public String putGroup(@PathVariable(value = "id") String id, @RequestBody Group group) {
		Optional <Group> _group = group_repo.findById(id);
		
		if (_group.isPresent()) {
			group_repo.save(group);
			return id+ " Update Complete";
			
		}else {
			return id+ " Record not found";
		}
	}
}