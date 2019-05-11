package tech.poorguy.commonmapper.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import tech.poorguy.commonmapper.base.PoBase;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@ApiModel("标签PO")
@Table(name = "tag")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends PoBase {
    private static final long serialVersionUID = 2881060376334249969L;
    @ApiModelProperty(value = "标签名称")
    @NotBlank
    @Length(min = 1,max = 50)
    private String name;
}