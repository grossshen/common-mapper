package tech.poorguy.commonmapper.base.service;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 15:19
 * E： 具体的PO类， PK：PO类的主键类型。
 */
public interface CrudService<E,PK> extends
        InsertService<E,PK>,
        UpdateService<E,PK>,
        DeleteService<PK>,
        SelectService<E,PK>{
}
