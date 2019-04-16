package tech.poorguy.commonmapper.base.service;

import tech.poorguy.commonmapper.entity.qo.PageQO;
import tech.poorguy.commonmapper.entity.vo.PageVO;

import java.util.List;

public interface SelectService<E, PK> {
    E selectByPk(PK pk);
    List<E> selectByPks(Iterable<PK> pks);
    List<E> selectAll();
    PageVO<E> selectPage(PageQO<?> pageQO);
}
