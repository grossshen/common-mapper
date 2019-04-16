package tech.poorguy.commonmapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.poorguy.commonmapper.entity.po.Tag;
import tech.poorguy.commonmapper.annoation.ResponseResult;

import java.util.List;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 10:25
 */
@RestController
@RequestMapping("/api/recommend")
@ResponseResult
public class indexController {
    @GetMapping("/tagList")
    @ResponseStatus(HttpStatus.OK)
    public List<Tag> getTagList(){
        return null;
    }

}
