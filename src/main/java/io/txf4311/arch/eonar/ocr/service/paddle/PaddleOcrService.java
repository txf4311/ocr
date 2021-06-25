package io.txf4311.arch.eonar.ocr.service.paddle;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import io.txf4311.arch.eonar.ocr.configuration.OcrProperties;
import io.txf4311.arch.eonar.ocr.entity.BaseResp;
import io.txf4311.arch.eonar.ocr.entity.BusinessCard;
import io.txf4311.arch.eonar.ocr.parser.*;
import io.txf4311.arch.eonar.ocr.service.OcrContainer;
import io.txf4311.arch.eonar.ocr.service.OcrService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PaddleOcrService extends OcrContainer implements OcrService {

    public PaddleOcrService(OcrProperties ocrProperties) {
        super(ocrProperties);
    }

    public BaseResp analysisBusinessCard(String base64Pic) {
        if (StringUtils.isEmpty(base64Pic))
            return BaseResp.fail("图片不能为空");

        //请求接口
        String response = HttpUtil.post(ocrProperties.getServerUrl(), "{\"images\": [\"" + base64Pic + "\"]}", ocrProperties.getTimeOut());

        System.out.println(response);

        //解析返回的JSON
        JSONArray jsonArray = this.analysisResponse(response);
        if (null == jsonArray)
            return BaseResp.fail("图片识别识别，请手动填写！");

        ParserContext context = new ParserContext();
        context.add(new EmailParser()).add(new AddressParser())
                .add(new NameZhParser()).add(new NameEnParser())
                .add(new TelParser()).add(new CompanyParser())
                .add(new PositionParser()).add(new PhoneParser());

        //解析返回实体名片信息
        BusinessCard businessCard = this.transBusinessCard(jsonArray, context);

        return BaseResp.success("解析成功", businessCard);
    }

    @Override
    public BaseResp analysisBusinessLicense(String base64Pic) {
        if (StringUtils.isEmpty(base64Pic))
            return BaseResp.fail("图片不能为空");

        //请求接口
        String response = HttpUtil.post(ocrProperties.getServerUrl(), "{\"images\": [\"" + base64Pic + "\"]}", ocrProperties.getTimeOut());

        System.out.println(response);

        //解析返回的JSON
        JSONArray jsonArray = this.analysisResponse(response);
        if (null == jsonArray)
            return BaseResp.fail("图片识别识别，请手动填写！");

        ParserContext context = new ParserContext();

        //解析返回实体名片信息
        BusinessCard businessCard = this.transBusinessLicense(jsonArray, context);

        return BaseResp.success("解析成功", businessCard);
    }
}
