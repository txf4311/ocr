package io.txf4311.arch.eonar.ocr;

import io.txf4311.arch.eonar.ocr.annotation.EnableOCR;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableOCR
@SpringBootApplication
public class OCRApplication {

    public static void main(String[] args) {
        SpringApplication.run(OCRApplication.class, args);
    }

}
