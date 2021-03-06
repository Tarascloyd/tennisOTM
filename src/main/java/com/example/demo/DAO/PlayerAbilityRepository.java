package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.player.PlayersAbility;

@Repository
public interface PlayerAbilityRepository extends JpaRepository<PlayersAbility, Integer>{

}
