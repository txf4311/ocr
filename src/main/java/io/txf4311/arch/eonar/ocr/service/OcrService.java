package io.txf4311.arch.eonar.ocr.service;

import io.txf4311.arch.eonar.ocr.entity.BaseResp;

public interface OcrService {

    /**
     * 解析名片图片
     * @param base64Pic base64的图片流
     * @return
     */
    BaseResp analysisBusinessCard(String base64Pic);


    /**
     * 解析营业图片
     * @param base64Pic base64的图片流
     * @return
     */
    BaseResp analysisBusinessLicense(String base64Pic);

}
