package com.Park.Parks.Controller;

import com.Park.Parks.Entity.Parks;
import com.Park.Parks.Services.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/park")
public class ParkController {
    @Autowired
    private ParkService parkService;

    @PostMapping("/savepark")
    public ResponseEntity<Parks> savepark(@RequestParam("photo") MultipartFile photo,
                                            @RequestParam("names")String names,
                                            @RequestParam("area")String area,
                                            @RequestParam("price")String price) throws SQLException, IOException {
        Parks parks=parkService.saveparks(photo,names,area,price);
        return new ResponseEntity<>(parks, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parks>getpark(@PathVariable int id){
        Parks parks=parkService.getparks(id);
        return new ResponseEntity<>(parks,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parks>updatepark(@PathVariable int id,
                                                     @RequestParam(value="photo",required=false)MultipartFile photo,
                                                     @RequestParam("names")String names,
                                                     @RequestParam("area")String area,
                                                     @RequestParam("price")String price) throws IOException {
        Parks parks=parkService.updateparks(id,names,area,price,photo.getBytes());
        return new ResponseEntity<>(parks,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Parks>deletepark(@PathVariable int id){
        parkService.deleteparks(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
