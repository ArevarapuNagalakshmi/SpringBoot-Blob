package com.Amazon.Amazon.Services;

import com.Amazon.Amazon.Entity.AmazonEntity;
import com.Amazon.Amazon.Repository.AmazonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class AmazonService {
    @Autowired
    private AmazonRepo amazonRepo;

    public AmazonEntity saveamazon(MultipartFile amazon,String names, String roles, String positions, String packages) throws IOException, SQLException {
AmazonEntity amazonEntity=new AmazonEntity();
amazonEntity.setNames(names);
amazonEntity.setRoles(roles);
amazonEntity.setPositions(positions);
amazonEntity.setPackages(packages);
if(!amazon.isEmpty()){
    byte[] photoBytes=amazon.getBytes();
    Blob photoBlob=new SerialBlob(photoBytes);
    amazonEntity.setPhoto(photoBytes);
}
        return amazonRepo.save(amazonEntity);
    }

    public AmazonEntity getamazon(int id){
        return amazonRepo.findById(id);
    }
    public AmazonEntity updateamazon(int id,String names,String roles,String positions,String packages,byte[] photo){
       AmazonEntity amazonEntity=amazonRepo.findById(id);
       if(names!=null)amazonEntity.setNames(names);
       if(roles!=null)amazonEntity.setRoles(roles);
       if(positions!=null)amazonEntity.setPositions(positions);
       if(packages!=null)amazonEntity.setPackages(packages);
       if(photo!=null && photo.length>0){
           byte[] photo1=new byte[0];
           amazonEntity.setPhoto(photo1);
       }
        return amazonRepo.save(amazonEntity);
    }

    public void deleteamazon(int id){
        AmazonEntity amazonEntity=amazonRepo.findById(id);
        amazonRepo.deleteById(id);
    }
}
