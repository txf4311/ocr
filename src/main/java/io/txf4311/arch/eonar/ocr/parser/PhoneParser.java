package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机解析器
 */
public class PhoneParser extends ParserService {

  private static final String REGEX_NUM = "[^0-9]";

  private static final String REGEX_PHONE = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";

  public PhoneParser() {
    super(ParserConstant.PHONE);
  }

  @Override
  public String parser(String segStr) {
    if (segStr == null || segStr.length() < 7) {
      return null;
    }
    segStr = segStr.replaceAll("\\+86", "").replaceAll("86-", "");
    Pattern p = Pattern.compile(REGEX_NUM);
    Matcher m = p.matcher(segStr);
    String s = m.replaceAll("").trim();
    if (s.startsWith("86"))
      s = s.substring(2);
    return Pattern.matches(REGEX_PHONE, s) ? s : null;
  }
}
