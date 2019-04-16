package tech.poorguy.commonmapper.base.service;

public interface DeleteService<PK> {
    int deleteByPk(PK pk);
    int deleteByPks(Iterable<PK> pks);
}
