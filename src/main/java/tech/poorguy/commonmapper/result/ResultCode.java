package tech.poorguy.commonmapper.result;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200,"sucess"),
    INVALID_PARAM(400,"invalid parameter");
    private int code;
    private String message;
    ResultCode(int code, String message){
        this.code=code;
        this.message=message;
    }
}
