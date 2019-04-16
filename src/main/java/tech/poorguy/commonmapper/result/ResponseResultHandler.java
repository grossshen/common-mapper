package tech.poorguy.commonmapper.result;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import tech.poorguy.commonmapper.Util.JsonUtil;
import tech.poorguy.commonmapper.Util.RequestContextHolderUtil;
import tech.poorguy.commonmapper.annoation.ResponseResult;
import tech.poorguy.commonmapper.constant.HeaderConstant;
import tech.poorguy.commonmapper.enume.ApiStyleEnum;
import tech.poorguy.commonmapper.interceptor.ResponseResultInterceptor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 11:37
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = RequestContextHolderUtil.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        return responseResultAnn != null && !ApiStyleEnum.NONE.name().equalsIgnoreCase(request.getHeader(HeaderConstant.API_STYLE));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResponseResult responseResultAnn = (ResponseResult) RequestContextHolderUtil.getRequest().getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);

        Class<? extends Result> resultClazz = responseResultAnn.value();

        if (resultClazz.isAssignableFrom(FormatResult.class)) {
            if (body instanceof ErrorResult) {
                ErrorResult ErrorResult = (ErrorResult) body;
                return FormatResult.builder()
                        .code(Integer.valueOf(ErrorResult.getCode()))
                        .msg(ErrorResult.getMessage())
                        .data(ErrorResult.getErrors())
                        .build();
            } else if (body instanceof String) {
                return JsonUtil.object2Json(FormatResult.success(body));
            }
            return FormatResult.success(body);
        }
        return body;
    }

}

