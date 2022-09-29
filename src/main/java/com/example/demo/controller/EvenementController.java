package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Evenement;
import com.example.demo.entity.User;
import com.example.demo.service.EvenementService;
import com.example.demo.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("evenement")
public class EvenementController {
	
	@Autowired
	private EvenementService evenementService;
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/{id}")
	public String  addEvenement(@PathVariable("id") Long id,@RequestBody List<Evenement> evenements) {

		User myUser = userService.getUserByID(id);
		if(evenements.get(0).getMission().equals("null"))
		{
			evenementService.deleteEvenement(evenements.get(0).getDate(), myUser);
			return null;
		}
		for (Evenement evenement : evenements) {
			evenement.setUser(myUser);
		}
		evenementService.addEvenement(evenements,myUser);
		return null;
	}
	@PostMapping("/get/{id}")
	public List<Evenement>getEventsByUserAndDate(@PathVariable("id") Long id,@RequestBody() LocalDate date){
	
return  evenementService.getEventsByUserAndDate(id,date);
		
	}
}
