package com.devmarcelo.gamelist.services;

import com.devmarcelo.gamelist.dto.GameMinDTO;
import com.devmarcelo.gamelist.dto.GameDTO;
import com.devmarcelo.gamelist.entities.Game;
import com.devmarcelo.gamelist.projections.GameMinProjection;
import com.devmarcelo.gamelist.repositories.GameRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
