package tech.poorguy.commonmapper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.poorguy.commonmapper.model.Tag;
import tech.poorguy.commonmapper.result.FormatResult;
import tech.poorguy.commonmapper.result.ResponseResult;

import java.util.List;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 10:25
 */
@RestController
@RequestMapping("/recommend")
@ResponseResult(FormatResult.class)
public class indexController {
    @GetMapping("/tagList")
    public List<Tag> getTagList(){
        return null;
    }

}
