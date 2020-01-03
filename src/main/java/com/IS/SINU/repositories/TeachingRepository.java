package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeachingRepository extends JpaRepository<Teaching, Long> {
}
