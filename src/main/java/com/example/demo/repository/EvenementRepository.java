package com.example.demo.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Evenement;
import com.example.demo.entity.User;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long>{

List<Evenement> findAll();
List<Evenement> findAllByDate(LocalDate date);
List<Evenement> findByUser(User user);	

}
