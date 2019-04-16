package tech.poorguy.commonmapper.service;

import org.springframework.stereotype.Service;
import tech.poorguy.commonmapper.base.service.implement.MySqlCrudServiceImpl;
import tech.poorguy.commonmapper.entity.po.Tag;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 16:55
 */
@Service
public class TagServiceImpl extends MySqlCrudServiceImpl<Tag,String> implements TagService{
}
