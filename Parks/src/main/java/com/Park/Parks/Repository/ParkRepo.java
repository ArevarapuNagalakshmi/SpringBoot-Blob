package com.Park.Parks.Repository;

import com.Park.Parks.Entity.Parks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepo extends JpaRepository<Parks,Integer>{
    Parks findById(int id);
}
