package tech.poorguy.commonmapper.helper;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import tech.poorguy.commonmapper.bean.ParameterInvalidItem;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 14:11
 * 参数无效项辅助器
 */
public class ParameterInvalidItemHelper {

    public static <T> List<ParameterInvalidItem> convertCVSetObjectToParameterInvalidItemList(Set<ConstraintViolation<T>> cvset) {
        if (CollectionUtils.isEmpty(cvset)) {
            return null;
        }

        List<ParameterInvalidItem> parameterInvalidItemList = Lists.newArrayList();
        for (ConstraintViolation<?> cv : cvset) {
            ParameterInvalidItem parameterInvalidItem = new ParameterInvalidItem();
            String propertyPath = cv.getPropertyPath().toString();
            if (propertyPath.indexOf(".") != -1) {
                String[] propertyPathArr = propertyPath.split("\\.");
                parameterInvalidItem.setFieldName(propertyPathArr[propertyPathArr.length - 1]);
            } else {
                parameterInvalidItem.setFieldName(propertyPath);
            }
            parameterInvalidItem.setMessage(cv.getMessage());
            parameterInvalidItemList.add(parameterInvalidItem);
        }

        return parameterInvalidItemList;
    }

    public static List<ParameterInvalidItem> convertCVSetToParameterInvalidItemList(Set<ConstraintViolation<?>> cvset) {
        if (CollectionUtils.isEmpty(cvset)) {
            return null;
        }

        List<ParameterInvalidItem> parameterInvalidItemList = Lists.newArrayList();
        for (ConstraintViolation<?> cv : cvset) {
            ParameterInvalidItem parameterInvalidItem = new ParameterInvalidItem();
            String propertyPath = cv.getPropertyPath().toString();
            if (propertyPath.indexOf(".") != -1) {
                String[] propertyPathArr = propertyPath.split("\\.");
                parameterInvalidItem.setFieldName(propertyPathArr[propertyPathArr.length - 1]);
            } else {
                parameterInvalidItem.setFieldName(propertyPath);
            }
            parameterInvalidItem.setMessage(cv.getMessage());
            parameterInvalidItemList.add(parameterInvalidItem);
        }

        return parameterInvalidItemList;
    }

    public static List<ParameterInvalidItem> convertBindingResultToMapParameterInvalidItemList(BindingResult bindingResult) {
        if (bindingResult == null) {
            return null;
        }

        List<ParameterInvalidItem> parameterInvalidItemList = Lists.newArrayList();

        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            ParameterInvalidItem parameterInvalidItem = new ParameterInvalidItem();
            parameterInvalidItem.setFieldName(fieldError.getField());
            parameterInvalidItem.setMessage(fieldError.getDefaultMessage());
            parameterInvalidItemList.add(parameterInvalidItem);
        }

        return parameterInvalidItemList;
    }
}

