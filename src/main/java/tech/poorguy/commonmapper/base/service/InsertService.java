package tech.poorguy.commonmapper.base.service;

public interface InsertService<E, PK> {
    PK insert(E record);
}
