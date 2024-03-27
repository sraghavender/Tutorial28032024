package com.raghavender.demo.logging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@RestController

@Slf4j
@RequestMapping("Lombok")
public class LoggingController {

    
    @GetMapping
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
}