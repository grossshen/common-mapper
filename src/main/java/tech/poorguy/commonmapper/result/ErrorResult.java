package tech.poorguy.commonmapper.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import tech.poorguy.commonmapper.Util.RequestContextHolderUtil;
import tech.poorguy.commonmapper.enume.BusinessExceptionEnum;
import tech.poorguy.commonmapper.exception.BusinessException;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 11:16
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResult implements Result {
    private static final long serialVersionUID = -2648953744601082906L;

    /** 
     * @Description:  http响应状态码
     */
    private Integer status;
    //htttp响应码对应错误提示
    private String error;
    //异常堆栈信息
    private String message;
    private Integer code;
    //接口调用路径
    private String path;
    //异常名称
    private String exception;
    //异常的错误传递的数据：不解
    private Object errors;
    private Date timestamp;

    public static ErrorResult failure(ResultCode resultCode, Throwable e, HttpStatus httpStatus, Object errors) {
        ErrorResult result =ErrorResult.failure(resultCode, e, httpStatus);
        result.setErrors(errors);
        return result;
    }

    public static ErrorResult failure(ResultCode resultCode, Throwable e, HttpStatus httpStatus) {
        ErrorResult result = new ErrorResult();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setStatus(httpStatus.value());
        result.setError(httpStatus.getReasonPhrase());
        result.setException(e.getClass().getName());
        result.setPath(RequestContextHolderUtil.getRequest().getRequestURI());
        result.setTimestamp(new Date());
        return result;
    }

//    自定义异常
    public static ErrorResult failure(BusinessException e) {
        BusinessExceptionEnum ee = BusinessExceptionEnum.getByEClass(e.getClass());
        if (ee != null) {
            return ErrorResult.failure(ee.getResultCode(), e, ee.getHttpStatus(), e.getData());
        }

        ErrorResult ErrorResult = failure(e.getResultCode() == null ? ResultCode.SUCCESS : e.getResultCode(), e, HttpStatus.OK, e.getData());
        if (StringUtil.isNotEmpty(e.getMessage())) {
            ErrorResult.setMessage(e.getMessage());
        }
        return ErrorResult;
    }
}
