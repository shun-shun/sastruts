package sample.service;

import sample.entity.Syain;

public class SyainService extends AbstractService<Syain> {

    public Syain findById(Integer id) {
        return select().id(id).getSingleResult();
    }
}