package com.monitor.monitor_service.services;


import com.monitor.monitor_service.models.SystemMetrics;
import com.monitor.monitor_service.repositories.SystemMetricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SystemMetricsService {

    private final SystemMetricsRepository systemMetricsRepository;
    private final SystemInfo systemInfo = new SystemInfo();
    private final CentralProcessor processor = systemInfo.getHardware().getProcessor();

    @Scheduled(fixedRate = 60000)
    public void captureAndStoreMetrics() {

        SystemMetrics metrics = SystemMetrics.builder()
                .cpuLoad(processor.getSystemCpuLoad(1000) * 100)
                .totalMemory(Runtime.getRuntime().totalMemory())
                .freeMemory(Runtime.getRuntime().freeMemory())
                .availableProcessors(processor.getLogicalProcessorCount())
                .timestamp(LocalDateTime.now())
                .build();

        systemMetricsRepository.save(metrics);
    }


}
