package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮件解析器
 */
public class EmailParser extends ParserService {

    private static final String REGEX_PER = "[^A-Za-z0-9.@-：]";

    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public EmailParser() {
        super(ParserConstant.EMAIL);
    }

    public String parser(String text) {
        if (text.contains("@") && text.contains(".")) {
            Pattern p = Pattern.compile(REGEX_PER);
            Matcher m = p.matcher(text);
            String s = m.replaceAll("").trim();
            if(s.contains("：")) s = s.split("：")[1];
            return Pattern.matches(REGEX_EMAIL, s) ? s : null;
        }
        return null;
    }

    public static void main(String... args) {
        ParserService parser = new EmailParser ();
        System.out.println(parser.parser("E18508105058@wo.com.cn"));
    }
}