package tech.poorguy.commonmapper.entity.bo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/17 10:03
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test implements Serializable{
    private static final long serializableUID=1L;
    private String name;
    private String id;
}
