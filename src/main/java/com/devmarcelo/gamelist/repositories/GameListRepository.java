package com.devmarcelo.gamelist.repositories;

import com.devmarcelo.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
