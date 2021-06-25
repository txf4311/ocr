package io.txf4311.arch.eonar.ocr.parser;

import io.txf4311.arch.eonar.ocr.util.ParserConstant;
import io.txf4311.arch.eonar.ocr.util.SegTextUtil;

/**
 * 中文解析器
 */
public class NameZhParser extends ParserService {
    public NameZhParser() {
        super(ParserConstant.NAMEZH);
    }

    public String parser(String segStr) {
        segStr = SegTextUtil.extractChinese(segStr);
        if (!SegTextUtil.isChinese(segStr)  || segStr.length() < 2 || segStr.length() > 4) {
            return null;
        }
        String singleFirstName = segStr.substring(0, 1);
        String complexFirstName = segStr.substring(0, 2);
        if (segStr.length() > 2 && SnipWordsDic.VALID_POPULAR_SURNAME.contains("," + complexFirstName + ",")) {
            return segStr;
        } else if (segStr.length() < 4 && SnipWordsDic.VALID_POPULAR_SURNAME.contains("," + singleFirstName + ",")) {
            return segStr;
        }
        return null;
    }

    public static void main(String... args) {
        NameZhParser parser = new NameZhParser();
        System.out.println(parser.parser("钱江峰Edgar"));
        System.out.println(parser.parser("上海市延安东路618号13A"));
    }
}
