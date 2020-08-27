package com.aiadver.boot.data.jpa.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * @author george
 */
public class BaseRepositoryImpl<Entity, ID extends Serializable> extends SimpleJpaRepository<Entity, ID> implements BaseRepository<Entity, ID> {

    public BaseRepositoryImpl(JpaEntityInformation<Entity, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public <Example extends Entity> long count(Example example) {
        return count(getExample(example));
    }

    @Override
    public <Example extends Entity> List<Entity> findAll(Example example) {
        return findAll(getExample(example));
    }

    @Override
    public <Example extends Entity> Page<Entity> findAll(Example example, Pageable pageable) {
        return findAll(getExample(example), pageable);
    }

    @Override
    public <Example extends Entity> List<Entity> findAll(Example example, Sort sort) {
        return findAll(getExample(example), sort);
    }

    @Override
    public <Example extends Entity> Entity findOne(Example example) {
        return findOne(getExample(example)).get();
    }

    private <S extends Entity> Example<S> getExample(S s) {
        Example<S> example = Example.of(s);
        return example;
    }
}
