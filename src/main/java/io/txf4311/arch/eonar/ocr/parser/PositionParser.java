package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;

/**
 * 职位解析器
 */
public class PositionParser  extends ParserService {

    public PositionParser() {
        super(ParserConstant.POSITION);
    }

    @Override
    public String parser(String text) {
        for (String item : SnipWordsDic.POSITION_WORD.split(",")) {
            if (text.contains(item))
                return text;
        }
        return null;
    }

    public static void main(String ... args){
        String text = "KSWCERAMICS金瓷·陶瓷";
        for (String item : SnipWordsDic.POSITION_WORD.split(",")) {
            if (text.contains(item))
                System.out.println(text + item);
        }
    }
}
