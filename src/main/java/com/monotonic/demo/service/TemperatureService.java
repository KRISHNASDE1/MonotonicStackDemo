package com.monotonic.demo.service;

import com.monotonic.demo.dto.TemperatureResponse;
import com.monotonic.demo.entity.TemperatureAnalysis;
import com.monotonic.demo.repository.TemperatureAnalysisRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

@Service
public class TemperatureService {

    private final TemperatureAnalysisRepository repository;

    public TemperatureService(
            TemperatureAnalysisRepository repository) {

        this.repository = repository;
    }

    public TemperatureResponse analyze(int[] temperatures) {

        int n = temperatures.length;

        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && temperatures[stack.peek()] <= temperatures[i]) {

                stack.pop();
            }

            if (!stack.isEmpty()) {

                answer[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        TemperatureAnalysis analysis =
                new TemperatureAnalysis(
                        Arrays.toString(temperatures),
                        Arrays.toString(answer),
                        "Monotonic Stack",
                        "O(n)"
                );

        repository.save(analysis);

        return new TemperatureResponse(
                temperatures,
                answer,
                "Monotonic Stack",
                "O(n)"
        );
    }
}