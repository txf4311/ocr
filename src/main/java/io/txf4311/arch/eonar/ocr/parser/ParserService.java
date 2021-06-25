package io.txf4311.arch.eonar.ocr.parser;

public abstract class ParserService {

    private String typeName;

    ParserService(String typeName){
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public abstract String parser(String text);
}
