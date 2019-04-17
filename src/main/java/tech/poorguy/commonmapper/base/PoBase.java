package tech.poorguy.commonmapper.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 15:13
 */
@Data
public abstract class PoBase<PK> implements PoInterface<PK> ,Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="主键id")
    @Id
    //这样配置支持主键回写
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private PK id;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}
