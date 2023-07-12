package com.devmarcelo.gamelist.repositories;

import com.devmarcelo.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
