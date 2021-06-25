package io.txf4311.arch.eonar.ocr.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResp<T> {
    private boolean state;
    private String message;
    private T data;

    public static BaseResp fail(String message){
        return  BaseResp.builder().state(false).message(message).build();
    }

    public static BaseResp success(String message, Object data){
        return  BaseResp.builder().state(true).message(message).data(data).build();
    }
}
