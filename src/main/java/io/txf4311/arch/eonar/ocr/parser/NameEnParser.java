package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;
import io.txf4311.arch.eonar.ocr.util.SegTextUtil;

/**
 * 英文解析器
 */
public class NameEnParser extends ParserService {
    public NameEnParser() {
        super(ParserConstant.NAMEEN);
    }

    public String parser(String text) {
        if (!SegTextUtil.isEnglish(text) || text.length() > 20)
            return null;
        String[] strings = text.split(" ");
        if (strings.length != 2)
            return null;
        return text;
    }

    public static void main(String ... args){
        NameEnParser parser = new NameEnParser();

        System.out.println("StoneTang".matches("[a-zA-Z]*"));
        System.out.println(parser.parser("Stone Tang"));
    }
}
