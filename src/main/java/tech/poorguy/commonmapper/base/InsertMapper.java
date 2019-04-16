package tech.poorguy.commonmapper.base;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 10:38
 */
public interface InsertMapper<T> extends Marker,
        tk.mybatis.mapper.common.sqlserver.InsertMapper<T>,
        InsertSelectiveMapper<T>,
        MySqlMapper<T>{
}
