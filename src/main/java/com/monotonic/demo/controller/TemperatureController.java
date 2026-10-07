package com.monotonic.demo.controller;

import com.monotonic.demo.dto.TemperatureRequest;
import com.monotonic.demo.dto.TemperatureResponse;
import com.monotonic.demo.service.TemperatureService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/temperatures")
public class TemperatureController {

    private final TemperatureService temperatureService;

    public TemperatureController(
            TemperatureService temperatureService) {

        this.temperatureService = temperatureService;
    }

    @PostMapping("/analyze")
    public TemperatureResponse analyze(
            @RequestBody TemperatureRequest request) {

        return temperatureService.analyze(
                request.getTemperatures()
        );
    }
}