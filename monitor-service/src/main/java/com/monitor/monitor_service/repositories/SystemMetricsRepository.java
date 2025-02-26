package com.monitor.monitor_service.repositories;

import com.monitor.monitor_service.models.SystemMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMetricsRepository extends JpaRepository<SystemMetrics,Long> {
}
