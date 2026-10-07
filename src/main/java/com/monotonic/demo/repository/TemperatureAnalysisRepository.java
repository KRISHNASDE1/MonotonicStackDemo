package com.monotonic.demo.repository;

import com.monotonic.demo.entity.TemperatureAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureAnalysisRepository
        extends JpaRepository<TemperatureAnalysis, Long> {
}