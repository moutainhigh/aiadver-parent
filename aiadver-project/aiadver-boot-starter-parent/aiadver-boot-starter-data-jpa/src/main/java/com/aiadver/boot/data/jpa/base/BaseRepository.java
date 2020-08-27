package com.aiadver.boot.data.jpa.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author george
 */
@NoRepositoryBean
public interface BaseRepository<Entity, ID extends Serializable> extends JpaRepositoryImplementation<Entity, ID> {

    /**
     * 获取所有实体的个数
     *
     * @param example
     * @return
     */
    <Example extends Entity> long count(Example example);

    /**
     * 获取所有的实体
     *
     * @param example
     * @return
     */
    <Example extends Entity> List<Entity> findAll(Example example);

    /**
     * 获取分页的所有实体
     *
     * @param example
     * @param pageable
     * @return
     */
    <Example extends Entity> Page<Entity> findAll(Example example, Pageable pageable);

    /**
     * 获取所有实体，并且按照排序排列。
     *
     * @param example
     * @param sort
     * @return
     */
    <Example extends Entity> List<Entity> findAll(Example example, Sort sort);

    /**
     * 获取单个实体
     *
     * @param example
     * @return
     */
    <Example extends Entity> Entity findOne(Example example);

}
