package com.Institutes.Institute.Service;

import com.Institutes.Institute.Entity.Institutes;
import com.Institutes.Institute.Repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class InsService {
    @Autowired
    private InstituteRepo instituteRepo;

    public Institutes saveInstitute(MultipartFile institute,String name,String courses,String price,Long mentors) throws IOException, SQLException {
Institutes institutes=new Institutes();
institutes.setName(name);
institutes.setCourses(courses);
institutes.setPrice(price);
institutes.setMentors(mentors);
if(!institute.isEmpty()){
    byte[] photoBytes=institute.getBytes();
    Blob photoBlob=new SerialBlob(photoBytes);
    institutes.setPhoto(photoBytes);
}
        return instituteRepo.save(institutes) ;
    }
    public Institutes getinstitute(int id){

        return instituteRepo.findByid(id);
    }
    public Institutes updateinstitute(int id,String name,String courses,byte[] photo){
     Institutes institutes=instituteRepo.findByid(id);
     if (name!=null) institutes.setName(name);
     if(courses!=null)institutes.setCourses(courses);
     if(photo!=null && photo.length>0){
         byte[] photo1=new byte[0];
         institutes.setPhoto(photo1);
     }
        return instituteRepo.save(institutes);
    }
    public void deleteinstitute(int id){
        Institutes institutes=instituteRepo.findByid(id);
        if(institutes!=null){
            instituteRepo.deleteById(id);
        }else{
            throw new RuntimeException("Exam not found with id: "+id);
        }
    }



}
