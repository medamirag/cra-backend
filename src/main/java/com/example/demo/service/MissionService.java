package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mission;
import com.example.demo.repository.MissionRepository;
@Service
public class MissionService {
@Autowired
MissionRepository missionRepository;
	
	public List<Mission>getAllMissions(){
		
		return missionRepository.findAll();
	}
	public String addMission(Mission mission) {
		return missionRepository.save(mission).getName();
	}
}
