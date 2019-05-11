package tech.poorguy.commonmapper.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.poorguy.commonmapper.entity.bo.Test;
import tech.poorguy.commonmapper.entity.po.Tag;
import tech.poorguy.commonmapper.annoation.ResponseResult;
import tech.poorguy.commonmapper.service.TagService;

import javax.servlet.http.HttpServletRequest;
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
public class TagController {
    @Autowired
    TagService tagService;
    @PostMapping("/test")
//    @ApiResponse()
    public Object test(@RequestBody Test test){
       System.out.println(test);
       System.out.println(test.getId());
        return test;
    }

    @PostMapping("/tag")
    @ApiOperation("添加标签")
    public Tag addTag(@RequestBody Tag tag){
        tagService.insert(tag);
        return tag;
    }
    @GetMapping("/hi")
    public String sayHi(){
        System.out.println("hihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihi");
        return "hi";
    }

    @GetMapping("/tagList")
    public List<Tag> getTagList(){
        return tagService.selectAll();
    }

}
