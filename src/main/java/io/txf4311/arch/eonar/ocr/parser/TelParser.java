package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;
import io.txf4311.arch.eonar.ocr.util.SegTextUtil;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 电话解析器
 */
public class TelParser extends ParserService {

    private static final String REGEX_NUM = "[^0-9-]";

    private static final String REGEX_PHONE = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";

    public TelParser() {
        super(ParserConstant.TEL);
    }

    public String parser(String segStr) {
        if(segStr.toUpperCase().contains("FAX") || segStr.contains("传真"))
            return null;
        String c = SegTextUtil.extractChinese(segStr);
        if(!StringUtils.isEmpty(c) && !c.contains("电话"))
            return null;
        Pattern p = Pattern.compile(REGEX_NUM);
        Matcher m = p.matcher(segStr);
        String s = m.replaceAll("").trim();
        if(!SegTextUtil.isNumeric(s.replaceAll("-","")) || s.length() < 7 )
            return null;
        if (s.startsWith("86"))
            s = s.substring(2);
        return !Pattern.matches(REGEX_PHONE, s) ? s : null;
    }

    public static void main(String... args) {
        TelParser telParser = new TelParser();
        System.out.println(telParser.parser("传真（028）66890173"));
        System.out.println(telParser.parser("8618273333799"));
    }
}
