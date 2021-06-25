package io.txf4311.arch.eonar.ocr.service;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.txf4311.arch.eonar.ocr.configuration.OcrProperties;
import io.txf4311.arch.eonar.ocr.parser.ParserContext;
import io.txf4311.arch.eonar.ocr.parser.ParserService;
import io.txf4311.arch.eonar.ocr.util.ParserConstant;
import io.txf4311.arch.eonar.ocr.entity.BusinessCard;
import org.springframework.util.StringUtils;

public abstract class OcrContainer {

    private static final Logger log = LoggerFactory.getLogger(OcrContainer.class);

    protected OcrProperties ocrProperties;

    public OcrContainer(OcrProperties ocrProperties) {
        this.ocrProperties = ocrProperties;
    }

    /**
     * 解析返回的json数据
     *
     * @param response json数据
     * @return JSONArray
     */
    protected JSONArray analysisResponse(String response) {
        log.debug("图片解析返回的JSON数据：", response);
        if (StringUtils.isEmpty(response))
            return null;
        try {
            JSONObject jsonObject = JSONUtil.parseObj(response);
            return ((JSONObject) jsonObject.getJSONArray("results").get(0)).getJSONArray("data");
        } catch (Exception e) {
            log.error("图片解析返回的JSON数据异常：", e);
            return null;
        }
    }

    /**
     * 将jsonArray转换BusinessCard
     *
     * @param jsonArray jsonArray
     * @return BusinessCard
     */
    protected BusinessCard transBusinessLicense(JSONArray jsonArray, ParserContext context) {
        if (null == jsonArray || jsonArray.isEmpty())
            return null;
        BusinessCard businessCard = new BusinessCard();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String text = jsonObject.getStr("text", "");
            if (StringUtils.isEmpty(text))
                continue;
            String parserText = "";
            for (ParserService service : context.getList()) {
                parserText = service.parser(text);
                if (!StringUtils.isEmpty(parserText)) {
                    switch (service.getTypeName()) {
                        case ParserConstant.EMAIL:
                            businessCard.setEmail(parserText);
                            break;
                        case ParserConstant.ADDRESS:
                            businessCard.setAddress(parserText);
                            break;
                        case ParserConstant.NAMEZH:
                            businessCard.setNameZh(parserText);
                            break;
                        case ParserConstant.NAMEEN:
                            businessCard.setNameEn(parserText);
                            break;
                        case ParserConstant.TEL:
                            businessCard.setTel(parserText);
                            break;
                        case ParserConstant.COMPANY:
                            businessCard.setCompanyName(parserText);
                            break;
                        case ParserConstant.POSITION:
                            businessCard.setPosition(parserText);
                            break;
                        case ParserConstant.PHONE:
                            businessCard.setPhone(parserText);
                            break;
                    }
                }
            }
        }
        return businessCard;
    }

    /**
     * 将jsonArray转换BusinessCard
     *
     * @param jsonArray jsonArray
     * @return BusinessCard
     */
    protected BusinessCard transBusinessCard(JSONArray jsonArray, ParserContext context) {
        if (null == jsonArray || jsonArray.isEmpty())
            return null;
        BusinessCard businessCard = new BusinessCard();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String text = jsonObject.getStr("text", "");
            if (StringUtils.isEmpty(text))
                continue;
            String parserText = "";
            for (ParserService service : context.getList()) {
                parserText = service.parser(text);
                if (!StringUtils.isEmpty(parserText)) {
                    switch (service.getTypeName()) {
                        case ParserConstant.EMAIL:
                            businessCard.setEmail(parserText);
                            break;
                        case ParserConstant.ADDRESS:
                            businessCard.setAddress(parserText);
                            break;
                        case ParserConstant.NAMEZH:
                            businessCard.setNameZh(parserText);
                            break;
                        case ParserConstant.NAMEEN:
                            businessCard.setNameEn(parserText);
                            break;
                        case ParserConstant.TEL:
                            businessCard.setTel(parserText);
                            break;
                        case ParserConstant.COMPANY:
                            businessCard.setCompanyName(parserText);
                            break;
                        case ParserConstant.POSITION:
                            businessCard.setPosition(parserText);
                            break;
                        case ParserConstant.PHONE:
                            businessCard.setPhone(parserText);
                            break;
                    }
                }
            }
        }
        return businessCard;
    }
}
