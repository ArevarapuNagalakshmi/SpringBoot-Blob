package com.Park.Parks.Services;

import com.Park.Parks.Entity.Parks;
import com.Park.Parks.Repository.ParkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class ParkService {
    @Autowired
    private ParkRepo parkRepo;

    public Parks saveparks(MultipartFile park, String names, String area,String price) throws IOException, SQLException {
      Parks parks=new Parks();
       parks.setNames(names);
       parks.setArea(area);
       parks.setPrice(price);
        if(!park.isEmpty()){
            byte[] photoBytes=park.getBytes();
            Blob photoBlob=new SerialBlob(photoBytes);
            parks.setPhoto(photoBytes);
        }
        return parkRepo.save(parks);
    }

    public Parks getparks(int id){

        return  parkRepo.findById(id);
    }
    public Parks updateparks(int id,String names,String area,String price,byte[] photo){
        Parks parks= parkRepo.findById(id);
        if(names!=null)parks.setNames(names);
        if(area!=null)parks.setArea(area);
        if(price!=null)parks.setPrice(price);

        if(photo!=null && photo.length>0){
            byte[] photo1=new byte[0];
            parks.setPhoto(photo1);
        }
        return  parkRepo.save(parks);
    }

    public void deleteparks(int id){
        Parks parks= parkRepo.findById(id);
        parkRepo.deleteById(id);
    }
}
