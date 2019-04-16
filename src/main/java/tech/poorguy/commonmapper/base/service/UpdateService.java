package tech.poorguy.commonmapper.base.service;

public interface UpdateService<E, PK> {
    int updateByPk(PK pk, E record);
    int updateByPkSelective(PK pk, E record);
    PK saveOrUpdate(E record);
}
