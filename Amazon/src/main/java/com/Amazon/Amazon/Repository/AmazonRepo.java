package com.Amazon.Amazon.Repository;

import com.Amazon.Amazon.Entity.AmazonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmazonRepo extends JpaRepository<AmazonEntity,Integer> {
    AmazonEntity findById(int id);
}
