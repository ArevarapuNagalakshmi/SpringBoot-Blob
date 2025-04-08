package com.games.game.repository;

import com.games.game.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Games,Integer> {
    Games findById(int rno);
}
