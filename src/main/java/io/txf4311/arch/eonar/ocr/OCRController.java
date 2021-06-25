package io.txf4311.arch.eonar.ocr;

import io.txf4311.arch.eonar.ocr.service.OcrService;
import io.txf4311.arch.eonar.ocr.entity.BaseResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Base64;

@Controller
public class OCRController {

    @Resource
    OcrService ocrService;

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @ResponseBody
    @PostMapping("/uploadBusinessCard")
    public BaseResp businessCard(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            BaseResp.fail("上传失败，请选择文件");
        }
        byte[] fileByte;
        try {
            fileByte = file.getBytes();
        } catch (IOException e) {
            return BaseResp.fail("图像文件转码失败！");
        }
        String voiceBase64 = Base64.getEncoder().encodeToString(fileByte);
        return ocrService.analysisBusinessCard(voiceBase64);
    }

    @ResponseBody
    @PostMapping("/uploadBusinessLicense")
    public BaseResp businessLicense(@RequestParam("fileBusinessLicense") MultipartFile file) {
        if (file.isEmpty()) {
            BaseResp.fail("上传失败，请选择文件");
        }
        byte[] fileByte;
        try {
            fileByte = file.getBytes();
        } catch (IOException e) {
            return BaseResp.fail("图像文件转码失败！");
        }
        String voiceBase64 = Base64.getEncoder().encodeToString(fileByte);
        return ocrService.analysisBusinessCard(voiceBase64);
    }

}