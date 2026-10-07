package com.monotonic.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "temperature_analysis")
public class TemperatureAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String temperatures;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String waitingDays;

    @Setter
    private String algorithm;

    @Setter
    private String timeComplexity;

    public TemperatureAnalysis() {
    }

    public TemperatureAnalysis(
            String temperatures,
            String waitingDays,
            String algorithm,
            String timeComplexity) {

        this.temperatures = temperatures;
        this.waitingDays = waitingDays;
        this.algorithm = algorithm;
        this.timeComplexity = timeComplexity;
    }

}