package com.Rapido.Rapido.Controller;

import com.Rapido.Rapido.Entity.Rapidos;
import com.Rapido.Rapido.Services.RapidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/rapido")
public class RapidoController {
    @Autowired
    private RapidoServices rapidoServices;

    @PostMapping("/saverapido")
    public ResponseEntity<Rapidos> saverapidos(@RequestParam("photo") MultipartFile photo,
                                               @RequestParam("name")String name,
                                               @RequestParam("address")String address,
                                               @RequestParam("cost")String cost) throws SQLException, IOException {
        Rapidos rapidos=rapidoServices.saverapido(photo,name,address,cost);
        return new ResponseEntity<>(rapidos, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rapidos>getrapidos(@PathVariable int id){
        Rapidos rapidos=rapidoServices.getrapidos(id);
        return new ResponseEntity<>(rapidos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rapidos>updaterapidos(@PathVariable int id,
                                                     @RequestParam(value="photo",required=false)MultipartFile photo,
                                                     @RequestParam("name")String name,
                                                     @RequestParam("address")String address,
                                                     @RequestParam("cost")String cost) throws IOException {
        Rapidos rapidos=rapidoServices.updaterapido(id,name,address,cost,photo.getBytes());
        return new ResponseEntity<>(rapidos,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Rapidos>deleterapios(@PathVariable int id){
        rapidoServices.deleterapido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
