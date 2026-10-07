package com.monotonic.demo.dto;

import lombok.Getter;

@Getter
public class TemperatureResponse {

    private int[] temperatures;
    private int[] waitingDays;
    private String algorithm;
    private String timeComplexity;

    public TemperatureResponse(
            int[] temperatures,
            int[] waitingDays,
            String algorithm,
            String timeComplexity) {

        this.temperatures = temperatures;
        this.waitingDays = waitingDays;
        this.algorithm = algorithm;
        this.timeComplexity = timeComplexity;
    }

}