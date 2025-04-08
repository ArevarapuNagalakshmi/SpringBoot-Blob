package com.Institutes.Institute.Controller;

import com.Institutes.Institute.Entity.Institutes;
import com.Institutes.Institute.Service.InsService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/institute")
public class InstituteController {
    @Autowired
    private InsService insService;

    @PostMapping("/saveinstitute")
        public ResponseEntity<Institutes>saveinstitute(
            @RequestParam("photo")MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("courses") String courses,
            @RequestParam("price") String price,
            @RequestParam("mentors") Long mentors) throws IOException, SQLException {
         Institutes institutes=insService.saveInstitute(photo, name, courses, price, mentors);
        return new ResponseEntity<>(institutes, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Institutes>getinstitute(
            @PathVariable int id) throws IOException,SQLException{
Institutes institutes=insService.getinstitute(id);
        return new ResponseEntity<>(institutes,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Institutes> updateinstitutes(@PathVariable int id,
                                                     @RequestParam(value="photo",required=false) MultipartFile photo,
                                                     @RequestParam("name") String name,
                                                     @RequestParam("courses")String courses) throws IOException,SQLException{
        Institutes institutes=insService.updateinstitute(id,name,courses, photo.getBytes());
        return new ResponseEntity<>(institutes,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Institutes>deleteinstitute(@PathVariable int id){
        insService.deleteinstitute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
