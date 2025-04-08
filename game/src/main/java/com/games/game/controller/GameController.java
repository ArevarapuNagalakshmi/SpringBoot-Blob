package com.games.game.controller;

import com.games.game.entity.Games;
import com.games.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/savegame")
    public ResponseEntity<Games>savegames(
            @RequestParam("image")MultipartFile image,
            @RequestParam("names") String names,
            @RequestParam("rules") String rules,
            @RequestParam("numbers")Long numbers,
            @RequestParam("type")String type) throws IOException, SQLException {
        Games games=gameService.savegame(image, names, rules, numbers, type);

        return new ResponseEntity<>(games, HttpStatus.CREATED);
    }
    @GetMapping("/{rno}")
    public ResponseEntity<Games>getgames(@PathVariable int rno){
     Games games=gameService.getgame(rno);
        return new ResponseEntity<>(games,HttpStatus.OK);
    }

    @PutMapping("/{rno}")
    public ResponseEntity<Games>updategameses(@PathVariable int rno,
                                             @RequestParam(value="image",required = false)MultipartFile image,
                                             @RequestParam("names")String names,
                                             @RequestParam("rules")String rules,
                                             @RequestParam("numbers")Long numbers,
                                             @RequestParam("type")String type) throws IOException {
        Games games=gameService.updategame(rno,names,rules,numbers,type,image.getBytes());

        return new ResponseEntity<>(games,HttpStatus.OK);
    }
    @DeleteMapping("/{rno}")
    public ResponseEntity<Games>deletegames(@PathVariable int rno){
        gameService.deletegame(rno);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
