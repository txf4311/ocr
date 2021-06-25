package io.txf4311.arch.eonar.ocr.configuration;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ToString
@ConfigurationProperties(
    prefix = "eonar.ocr"
)
public class OcrProperties {
    private String serverUrl;
    private int timeOut;
}
