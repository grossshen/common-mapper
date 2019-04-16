package tech.poorguy.commonmapper.base.mapper;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 10:22
 */
public interface CrudMapper<T> extends
        InsertMapper<T>,
        DeleteMapper<T>,
        UpdateMapper<T>,
        SelectMapper<T>{
}
