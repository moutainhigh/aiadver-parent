package com.aiadver.microservice.user.translator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author george
 */
public interface BaseTranslator<Entity, Model> {

    /**
     * 将entity对象转换成model对象
     *
     * @param entity
     * @return
     */
    Model copyEntityToModel(Entity entity);

    /**
     * 将entity对象转换成model对象
     *
     * @param entities
     * @return
     */
    default List<Model> copyEntityToModel(List<Entity> entities) {
        return entities.stream().map(this::copyEntityToModel).collect(Collectors.toList());
    }

    /**
     * 将model对象转换成entity对象
     *
     * @param model
     * @return
     */
    Entity copyModelToEntity(Model model);

    /**
     * 将model对象转换成entity对象
     *
     * @param models
     * @return
     */
    default List<Entity> copyModelToEntity(List<Model> models) {
        return models.stream().map(this::copyModelToEntity).collect(Collectors.toList());
    }
}
