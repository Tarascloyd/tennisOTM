package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.PlayerRepository;
import com.example.demo.player.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository thePlayerRepository) {
		playerRepository = thePlayerRepository;
	}

	@Override
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	@Override
	public Player findById(int theId) {
		Optional<Player> result = playerRepository.findById(theId);
		
		Player thePlayer = null;
		
		if (result.isPresent()) {
			thePlayer = result.get();
		}
		else {
			// we didn't find the player
			throw new RuntimeException("Did not find player id - " + theId);
		}
		
		return thePlayer;
	}

	@Override
	public void save(Player thePlayer) {
		playerRepository.save(thePlayer);

	}

	@Override
	public void deleteById(int theId) {
		playerRepository.deleteById(theId);

	}
	
	@Override
	public List<Player> searchBy(String theName) {
		
		return playerRepository.
				findByNameContainsAllIgnoreCase(theName);	
	}

	@Override
	public List<Player> findAllSortedByELO() {
		
		return playerRepository.findAll().stream().sorted((p1, p2) 
				-> (int)((p2.getPlayersStat().getELORating() - p1.getPlayersStat().getELORating())*1000)).collect(Collectors.toList());
	}

}
