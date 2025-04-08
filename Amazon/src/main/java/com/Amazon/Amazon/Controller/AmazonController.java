package com.Amazon.Amazon.Controller;

import com.Amazon.Amazon.Entity.AmazonEntity;
import com.Amazon.Amazon.Services.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Handler;

@RestController
@RequestMapping("/amazon")
public class AmazonController {
    @Autowired
    private AmazonService amazonService;

    @PostMapping("/saveamazon")
    public ResponseEntity<AmazonEntity>saveamazon(@RequestParam("photo")MultipartFile photo,
                                                  @RequestParam("names")String names,
                                                  @RequestParam("roles")String roles,
                                                  @RequestParam("positions")String positions,
                                                  @RequestParam("packages")String packages) throws SQLException, IOException {
    AmazonEntity amazonEntity=amazonService.saveamazon(photo,names,roles,positions,packages);
        return new ResponseEntity<>(amazonEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmazonEntity>getamazon(@PathVariable int id){
        AmazonEntity amazonEntity=amazonService.getamazon(id);
        return new ResponseEntity<>(amazonEntity,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmazonEntity>updateamazons(@PathVariable int id,
                                                     @RequestParam(value="photo",required=false)MultipartFile photo,
                                                     @RequestParam("names")String names,
                                                     @RequestParam("roles")String roles,
                                                     @RequestParam("positions")String positions,
                                                     @RequestParam("packages")String packages) throws IOException {
       AmazonEntity amazonEntity=amazonService.updateamazon(id,names,roles,positions,packages, photo.getBytes());
        return new ResponseEntity<>(amazonEntity,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AmazonEntity>deleteamazon(@PathVariable int id){
        amazonService.deleteamazon(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
