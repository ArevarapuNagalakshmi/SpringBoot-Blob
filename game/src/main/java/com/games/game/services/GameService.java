package com.games.game.services;

import com.games.game.entity.Games;
import com.games.game.repository.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class GameService {
    @Autowired
    private GameRepo gameRepo;

    public Games savegame(MultipartFile game,String names,String rules,Long numbers,String type) throws IOException, SQLException {
     Games games=new Games();
     games.setNames(names);
     games.setRules(rules);
     games.setNumbers(numbers);
     games.setType(type);
     if(!game.isEmpty()){
         byte[] photoBytes=game.getBytes();
         Blob photoBlob=new SerialBlob(photoBytes);
         games.setImage(photoBytes);
     }
        return gameRepo.save(games);
    }

    public Games getgame(int rno){
        return gameRepo.findById(rno);
    }
    public Games updategame(int rno,String names,String rules,Long numbers,String type,byte[] image){
       Games games=gameRepo.findById(rno);
       if(names!=null)games.setNames(names);
       if(rules!=null)games.setRules(rules);
       if(numbers!=null)games.setNumbers(numbers);
       if (type!=null)games.setType(type);
       if(image!=null && image.length>0) {
           byte[] image1 = new byte[0];
           games.setImage(image1);
       }
        return gameRepo.save(games);
    }
    public void deletegame(int rno){
        Games games=gameRepo.findById(rno);
        if(games!=null){
            gameRepo.deleteById(rno);
        }else {
            throw new RuntimeException("game not found with id:"+rno);
        }
    }
}
