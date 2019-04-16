package tech.poorguy.commonmapper.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 10:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormatResult implements Result {
    private static final long serialVersionUID = -3914040323322313111L;
    private Integer code;
    private String msg;
    private Object data;

    public static FormatResult success(){
        FormatResult result = new FormatResult();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    public static FormatResult success(Object data){
        FormatResult result = new FormatResult();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    public static FormatResult failure(ResultCode resultCode){
        FormatResult result = new FormatResult();
        result.setResultCode(resultCode);
        return result;
    }
    public static FormatResult failure(ResultCode resultCode, Object data){
        FormatResult result = new FormatResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    public static FormatResult failure(String message){
        FormatResult result = new FormatResult();
        result.setCode(ResultCode.PARAM_IS_INVALID.getCode());
        result.setMsg(message);
        return result;
    }

    private void setResultCode(ResultCode code){
        this.code=code.getCode();
        this.msg=code.getMessage();
    }
}
