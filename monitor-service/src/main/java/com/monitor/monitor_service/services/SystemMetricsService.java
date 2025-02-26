package com.monitor.monitor_service.services;


import com.monitor.monitor_service.models.SystemMetrics;
import com.monitor.monitor_service.repositories.SystemMetricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SystemMetricsService {

    private final SystemMetricsRepository systemMetricsRepository;
    private final OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

    @Scheduled(fixedRate = 60000)
    public void captureAndStoreMetrics() {

        SystemMetrics metrics = new SystemMetrics();
        metrics.setCpuLoad(osBean.getSystemLoadAverage());
        metrics.setTotalMemory(Runtime.getRuntime().totalMemory());
        metrics.setFreeMemory(Runtime.getRuntime().freeMemory());
        metrics.setAvailableProcessors(osBean.getAvailableProcessors());
        metrics.setTimestamp(LocalDateTime.now());

        systemMetricsRepository.save(metrics);
    }


}
