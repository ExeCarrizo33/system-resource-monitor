package com.monitor.monitor_service.controllers;

import com.monitor.monitor_service.models.SystemMetrics;
import com.monitor.monitor_service.repositories.SystemMetricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class SystemMetricsController {

    private final SystemMetricsRepository systemMetricsRepository;

    @GetMapping
    public List<SystemMetrics> getAllMetrics() {
        return systemMetricsRepository.findAll();
    }



}
