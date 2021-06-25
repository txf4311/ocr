package io.txf4311.arch.eonar.ocr.annotation;

import io.txf4311.arch.eonar.ocr.configuration.OcrConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({OcrConfiguration.class})
public @interface EnableOCR {

    String[] value() default "io.txf4311";
}
