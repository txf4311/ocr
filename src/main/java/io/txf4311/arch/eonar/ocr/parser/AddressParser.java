package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;

/**
 * 地址解析器
 */
public class AddressParser extends ParserService {
    public AddressParser() {
        super(ParserConstant.ADDRESS);
    }

    public String parser(String segStr) {
        for (String snipWord : SnipWordsDic.KEY_TYPE_WORD.split(",")) {
            if (segStr.contains(snipWord)) {
                return segStr;
            }
        }
        return null;
    }
}
