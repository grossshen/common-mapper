package tech.poorguy.commonmapper.exception;

import lombok.Getter;
import tech.poorguy.commonmapper.Util.StringUtil;
import tech.poorguy.commonmapper.enume.BusinessExceptionEnum;
import tech.poorguy.commonmapper.result.ResultCode;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 14:37
 */
@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 194906846739586856L;

    private String code;

    private String message;

    protected ResultCode resultCode;

    protected Object data;

    public BusinessException() {
        BusinessExceptionEnum exceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            resultCode = exceptionEnum.getResultCode();
            code = exceptionEnum.getResultCode().getCode().toString();
            message = exceptionEnum.getResultCode().getMessage();
        }
    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        this.message = StringUtil.formatIfArgs(format, "{}", objects);
    }

    public BusinessException(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.getCode().toString();
        this.message = resultCode.getMessage();
    }

}
