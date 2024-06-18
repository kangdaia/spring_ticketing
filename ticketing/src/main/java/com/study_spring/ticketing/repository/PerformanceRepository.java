package com.study_spring.ticketing.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.study_spring.ticketing.domain.Performance;
import java.util.UUID;


@Repository
public interface PerformanceRepository extends JpaRepository<Performance, UUID>  {
}
