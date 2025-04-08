package com.Rapido.Rapido.Repository;

import com.Rapido.Rapido.Entity.Rapidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapidoRepo extends JpaRepository<Rapidos,Integer> {
    Rapidos findById(int id);
}
