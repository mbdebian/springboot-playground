package com.google.mbdebian.springboot.playground.microservices.cdn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@RestController
public class CdnAgentApplication {
    private static final Logger logger = LoggerFactory.getLogger(CdnAgentApplication.class);

    @Autowired
    private ApplicationContext applicationContext;

    private static final String FILE_PATH = "/Users/samael/tmp/boost_your_wifi.jpg";

    // Serve the file via HTTP
    @RequestMapping("/getFile")
    public ResponseEntity<?> getFile() throws IOException {
        // Resource
        File file = new File(FILE_PATH);
        logger.info("Resource at: " + file.getAbsolutePath());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        // HTTP Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octect-stream"))
                .body(resource);
    }

    @RequestMapping(value = "showMeYourParameters", method = RequestMethod.POST)
    public String showMeYourParameters(
            @RequestParam(defaultValue = "no file path given") String filePath,
            @RequestParam(defaultValue = "0") Long startPosition,
            @RequestParam(defaultValue = "-1") Long endPosition) {
        return String.format("file path '%s', [start, end] = [%d, %d]",
                filePath,
                startPosition,
                endPosition);
    }

    @RequestMapping(value = "showMeYourParameters", method = RequestMethod.GET)
    public String showMeYourParameters() {
        return "This method only accepts POST requests";
    }

    public static void main(String[] args) {
        SpringApplication.run(CdnAgentApplication.class, args);
    }
}
