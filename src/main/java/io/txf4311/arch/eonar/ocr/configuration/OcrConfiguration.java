package io.txf4311.arch.eonar.ocr.configuration;

import io.txf4311.arch.eonar.ocr.service.OcrService;
import io.txf4311.arch.eonar.ocr.service.paddle.PaddleOcrService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties({OcrProperties.class})
public class OcrConfiguration {

    @Bean
    @ConditionalOnProperty(
            prefix = "eonar.ocr",
            name = {"serverUrl"}
    )
    public OcrService ocrService(OcrProperties ocrProperties) {
        return new PaddleOcrService(ocrProperties);
    }
}
