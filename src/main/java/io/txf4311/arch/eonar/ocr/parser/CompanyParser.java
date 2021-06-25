package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;

import java.util.regex.Pattern;

/**
 * 公司解析器
 */
public class CompanyParser extends ParserService{

    private static final String REGEX  = "^(?=.*[\u4e00-\u9fa5])(?=.*[a-zA-Z])([a-zA-Z\u4e00-\u9fa5]{1,30})$";

    public CompanyParser() {
        super(ParserConstant.COMPANY);
    }

    @Override
    public String parser(String text) {
        return text.contains("公司") || text.contains("集团") ? text : null;
    }

    public static void main(String ... args){
        System.out.println( Pattern.matches(REGEX,"迟盼"));
    }
}
