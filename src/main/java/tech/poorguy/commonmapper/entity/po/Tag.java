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
public class Tag extends PoBase<String> {
    @ApiModelProperty(value ="标签主键")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    @Id
    private String id;

    @ApiModelProperty(value = "标签名称")
    @NotBlank
    @Length(min = 1,max = 50)
    private String name;
}