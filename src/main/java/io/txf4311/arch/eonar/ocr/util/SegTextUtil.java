package io.txf4311.arch.eonar.ocr.util;

import io.txf4311.arch.eonar.ocr.parser.SnipWordsDic;

import java.util.ArrayList;
import java.util.List;

public class SegTextUtil {

    /**
     * 判断是否为中文
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为中文数字或字母或数字
     */
    public static boolean isNumberLetter(String str){
        for(int i =0 ;i<str.length();i++){
            char c = str.charAt(i);
            if(SnipWordsDic.NUMBER_CHINESE_DIC.contains(","+c+",") || !isChinese(c)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     *  判断是否为纯阿拉伯数字
     * */
    public static boolean isNumeric(String txt){
        char[] chrs = txt.toCharArray();
        for(char chr : chrs){
            if (!Character.isDigit(chr)){
                return false;
            }
        }
        return true;
    }

    /**
     * 去除关键字
     * */
    public static String cutPreWord(String txt,String keys){
        String[] arraykeys = keys.split(",");
        // 是否需要检查末尾为数字字母
        boolean isNeedCheck = false;
        for(int i = 0 ;i < arraykeys.length ; i++){
            if(txt.length() == 0){
                return txt;
            }
            String key = arraykeys[i];
            if(key.length() > 0 && txt.length() >= key.length() && txt.lastIndexOf(key) == (txt.length() - key.length())){
                txt = txt.substring(0, txt.length()-key.length());
                isNeedCheck = true;
                i = -1;
            }
            if(txt.length() == 0){
                return txt;
            }
            // 先去除末尾数字字母
            String chr = txt.substring(txt.length()-1,txt.length());
            if(isNeedCheck && !SegTextUtil.isChinese(chr)){
                txt = txt.substring(0, txt.length()-1);
                isNeedCheck = true;
                i = -1;
            }
        }
        return txt;
    }

    /**
     *  转换中文数字为阿拉伯数字
     *
     * */
    public static String processChineseNumber(String txt){
        // 如果是纯阿拉伯数字，则不进行转换
        if(isNumeric(txt)){
            return txt;
        }
        // 处理汉字数字
        char[] chrs = txt.toCharArray();
        List<Integer> numberList = new ArrayList<Integer>();
        // 转换汉字为数字
        for(int i = 0; i<chrs.length; i++){
            char chr = chrs[i];
            switch (chr) {
                case '一':
                    numberList.add(1);
                    break;
                case '二':
                    numberList.add(2);
                    break;
                case '三':
                    numberList.add(3);
                    break;
                case '四':
                    numberList.add(4);
                    break;
                case '五':
                    numberList.add(5);
                    break;
                case '六':
                    numberList.add(6);
                    break;
                case '七':
                    numberList.add(7);
                    break;
                case '八':
                    numberList.add(8);
                    break;
                case '九':
                    numberList.add(9);
                    break;
                case '十':
                    numberList.add(10);
                    break;
                case '百':
                    numberList.add(100);
                    break;
                case '千':
                    numberList.add(1000);
                    break;
                case '万':
                    numberList.add(10000);
                    break;
                case '亿':
                    numberList.add(100000000);
                    break;
                case '壹':
                    numberList.add(1);
                    break;
                case '贰':
                    numberList.add(2);
                    break;
                case '叁':
                    numberList.add(3);
                    break;
                case '肆':
                    numberList.add(4);
                    break;
                case '伍':
                    numberList.add(5);
                    break;
                case '陆':
                    numberList.add(6);
                    break;
                case '柒':
                    numberList.add(7);
                    break;
                case '捌':
                    numberList.add(8);
                    break;
                case '玖':
                    numberList.add(9);
                    break;
                case '拾':
                    numberList.add(10);
                    break;
                default:
                    break;
            }
        }
        int number = 0;
        for(int i = 0 ;i<numberList.size();i++){
            int numTemp = numberList.get(i);
            if(numTemp % 10 == 0 && i == 0){
                number = numTemp;
            }else if(numTemp > 0 && numTemp < 10){
                number = numTemp + number;
            }else{
                number = numTemp * number;
            }
        }
        return number+"";
    }

    /**
     * 取出文本中的关键字
     * */
    public static String cutKeyWord(String keys,String txt){
        String key = null;
        for(int i =1 ;i<= txt.length();i++){
            String afterWord = txt.substring(txt.length()-i,txt.length());
            if(keys.contains(","+afterWord+",")){
                key = afterWord;
            }
        }
        return key;
    }

    /**
     * 判断字符串是否为中文
     * */
    public static boolean isChinese(String str) {
        for(int i =0 ;i<str.length();i++){
            char c = str.charAt(i);
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
            if (ub != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否为英文
     * */
    public static boolean isEnglish(String str) {
        return str.replaceAll(" ", "").matches("[a-zA-Z]*");
    }

    /**
     * 提取中文
     * */
    public static String extractChinese(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0 ;i<str.length();i++){
            char c = str.charAt(i);
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
            if (ub != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS )
                continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * 是否有中文
     * */
    public static boolean hasChinese(String str) {
        for(int i =0 ;i<str.length();i++){
            char c = str.charAt(i);
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
            if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS )
                return true;
        }
        return false;
    }
}
