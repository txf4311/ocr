package io.txf4311.arch.eonar.ocr.parser;

import java.util.ArrayList;
import java.util.List;

public class ParserContext {

    private String content;

    private List<ParserService> list = new ArrayList<ParserService>();

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public ParserContext add(ParserService eps) {
        list.add(eps);
        return this;
    }

    public List<ParserService> getList() {
        return list;
    }
}
