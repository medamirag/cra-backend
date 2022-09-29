package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mission;
import com.example.demo.service.MissionService;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("Mission")
public class MissionController {
	@Autowired
	MissionService missionService;
	@Autowired
	UserService usService;

	
	
	@GetMapping("/")
	public List<Mission> getAllMission(){
		return missionService.getAllMissions();
		
	}
	@PostMapping("/{iduser}")
	public String addMission(@RequestBody Mission mission,@PathVariable("iduser") Long iduser) {
		mission.setUser(usService.getUserByID(iduser));
				missionService.addMission(mission);
		return null;
	}
}
