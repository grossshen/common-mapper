package tech.poorguy.commonmapper.base;


import java.util.Date;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 15:11
 */
public interface PoInterface<PK>  {

    PK getId();

    void setId(PK id);

    Date getCreateTime();

    void setCreateTime(Date createTime);

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);
}
