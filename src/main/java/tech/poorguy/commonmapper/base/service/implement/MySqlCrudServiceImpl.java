package tech.poorguy.commonmapper.base.service.implement;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import tech.poorguy.commonmapper.Util.BeanUtil;
import tech.poorguy.commonmapper.Util.StringUtil;
import tech.poorguy.commonmapper.base.mapper.CrudMapper;
import tech.poorguy.commonmapper.base.PoInterface;
import tech.poorguy.commonmapper.base.service.CrudService;
import tech.poorguy.commonmapper.entity.qo.PageQO;
import tech.poorguy.commonmapper.entity.vo.PageVO;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 15:30
 */
@Slf4j
public abstract class MySqlCrudServiceImpl<E extends PoInterface<PK>, PK> implements CrudService<E, PK> {

    @Autowired
    protected CrudMapper<E> crudMapper;

    protected Class<E> poType;

    public MySqlCrudServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        poType = (Class<E>) pt.getActualTypeArguments()[0];
    }

    @Override
    public PK insert(E record) {
        Assert.notNull(record, "record is not null");

        if (record.getCreateTime() == null) {
            Date currentDate = new Date();
            record.setCreateTime(currentDate);
            record.setUpdateTime(currentDate);
        }
        record.setId((PK) StringUtil.generateUUID());
        crudMapper.insert(record);
        return record.getId();
    }

    @Override
    public int deleteByPk(PK pk) {
        Assert.notNull(pk, "pk is not null");

        return crudMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public int deleteByPks(Iterable<PK> pks) {
        Assert.notNull(pks, "pks is not null");

        String pksStr = this.IterableToSpitStr(pks, ",");
        if (pksStr == null) {
            return 0;
        }

        return crudMapper.deleteByIds(pksStr);
    }

    @Override
    public int updateByPk(PK pk, E record) {
        Assert.notNull(pk, "pk is not null");
        Assert.notNull(record, "record is not null");

        record.setId(pk);
        if (record.getUpdateTime() == null) {
            record.setUpdateTime(new Date());
        }
        return crudMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPkSelective(PK pk, E record) {
        Assert.notNull(pk, "pk is not null");
        Assert.notNull(record, "record is not null");

        record.setId(pk);
        if (record.getUpdateTime() == null) {
            record.setUpdateTime(new Date());
        }
        return crudMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PK saveOrUpdate(E record) {
        Assert.notNull(record, "record is not null");

        if (null != record.getId() && null != selectByPk(record.getId())) {
            updateByPk(record.getId(), record);
        } else {
            insert(record);
        }
        return record.getId();
    }

    @Override
    public E selectByPk(PK pk) {
        Assert.notNull(pk, "pk is not null");

        return crudMapper.selectByPrimaryKey(pk);
    }

    @Override
    public List<E> selectByPks(Iterable<PK> pks) {
        Assert.notNull(pks, "pks is not null");

        String pksStr = this.IterableToSpitStr(pks, ",");
        if (pksStr == null) {
            return new ArrayList<>();
        }

        return crudMapper.selectByIds(pksStr);
    }

    private String IterableToSpitStr(Iterable<PK> pks, String separator) {
        StringBuilder s = new StringBuilder();
        pks.forEach(pk -> s.append(pk).append(separator));

        if (StringUtil.isEmpty(s.toString())) {
            return null;
        } else {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    @Override
    public List<E> selectAll() {
        return crudMapper.selectAll();
    }

    @Override
    public PageVO<E> selectPage(PageQO<?> pageQO) {
        Assert.notNull(pageQO, "pageQO is not null");

        Page<E> page = PageHelper.startPage(pageQO.getPageNum(), pageQO.getPageSize(), pageQO.getOrderBy());
        try {
            Object condition = pageQO.getCondition();
            if (condition == null) {
                crudMapper.selectAll();
            } else if (condition instanceof Condition) {
                crudMapper.selectByCondition(condition);
            } else if (condition instanceof Example) {
                crudMapper.selectByExample(condition);
            } else if (poType.isInstance(condition)){
                crudMapper.select((E)condition);
            } else {
                try {
                    E e = poType.newInstance();
                    BeanUtil.copyProperties(condition, e);
                    crudMapper.select(e);
                } catch (InstantiationException | IllegalAccessException e) {
                    log.error("selectPage occurs error, caused by: ", e);
                    throw new RuntimeException("poType.newInstance occurs InstantiationException or IllegalAccessException", e);
                }
            }
        } finally {
            page.close();
        }

        return PageVO.build(page);
    }

}
