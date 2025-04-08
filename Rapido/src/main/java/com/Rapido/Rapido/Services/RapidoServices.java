package com.Rapido.Rapido.Services;

import com.Rapido.Rapido.Entity.Rapidos;
import com.Rapido.Rapido.Repository.RapidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class RapidoServices {
    @Autowired
    private RapidoRepo rapidoRepo;

    public Rapidos saverapido(MultipartFile rapido, String name, String address,String cost) throws IOException, SQLException {
        Rapidos rapidos=new Rapidos();
        rapidos.setName(name);
        rapidos.setAddress(address);
        rapidos.setCost(cost);
        if(!rapido.isEmpty()){
            byte[] photoBytes=rapido.getBytes();
            Blob photoBlob=new SerialBlob(photoBytes);
            rapidos.setPhoto(photoBytes);
        }
        return rapidoRepo.save(rapidos);
    }

    public Rapidos getrapidos(int id){
        return rapidoRepo.findById(id);
    }
    public Rapidos updaterapido(int id,String name,String address,String cost,byte[] photo){
        Rapidos rapidos=rapidoRepo.findById(id);
        if(name!=null)rapidos.setName(name);
        if(address!=null)rapidos.setAddress(address);
        if(cost!=null)rapidos.setCost(cost);

        if(photo!=null && photo.length>0){
            byte[] photo1=new byte[0];
            rapidos.setPhoto(photo1);
        }
        return rapidoRepo.save(rapidos);
    }

    public void deleterapido(int id){
        Rapidos rapidos=rapidoRepo.findById(id);
        rapidoRepo.deleteById(id);
    }
}
