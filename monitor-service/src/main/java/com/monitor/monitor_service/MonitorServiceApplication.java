package com.monitor.monitor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorServiceApplication.class, args);
    }

}
