package com.Institutes.Institute.Repository;

import com.Institutes.Institute.Entity.Institutes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepo extends JpaRepository<Institutes,Integer> {
    Institutes findByid(int id);
}
