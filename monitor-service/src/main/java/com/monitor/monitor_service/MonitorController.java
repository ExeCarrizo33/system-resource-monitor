package com.monitor.monitor_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MonitorController {


    @GetMapping("/monitor")
    public String getMonitor() {
        return "Monitor Service";
    }


}
