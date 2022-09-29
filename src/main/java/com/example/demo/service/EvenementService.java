package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Activite;
import com.example.demo.entity.Evenement;
import com.example.demo.entity.User;
import com.example.demo.repository.EvenementRepository;
import com.example.demo.repository.UserRepository;

@Service
public class EvenementService {
	@Autowired
	private EvenementRepository evenementRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String addEvenement(List<Evenement> evenements,User user) {
		for (Evenement evenement : evenements) {
			deleteEvenement(evenement.getDate(),user);
			for (Activite activite : evenement.getActivite()) {
				activite.setEvenement(evenement);
			}
		}
		evenementRepository.saveAll(evenements);
		return null;
	}
	
	public String deleteEvenement(LocalDate date,User user) {
		System.out.println("date"+date);

		List<Evenement> events = evenementRepository.findAllByDate(date);
		
		for (Evenement evenement : events) {
			System.out.println("evenement.getMission()"+evenement.getMission());
			evenementRepository.deleteById(evenement.getId());
		}
		return "";
	}
	public List<Evenement>getEventsByUserAndDate(Long id,LocalDate date){

	System.out.println("id"+id);
	User myUser = userRepository.findById(id).orElse(null);
	System.out.println(myUser+"myUser");
	List<Evenement>	events= evenementRepository.findByUser(myUser);	
	return 	events.stream().filter(event->event.getDate().getYear()==date.getYear()&&event.getDate().getMonth().equals(date.getMonth())).toList();
}
}
