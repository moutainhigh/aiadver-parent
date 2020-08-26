package com.aiadver.microservice.user.translator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author george
 */
public abstract class BaseTranslator<Entity, Model> {

    /**
     * 将entity对象转换成model对象
     *
     * @param entity
     * @return
     */
    public abstract Model copyEntityToModel(Entity entity);

    public List<Model> copyEntityToModel(List<Entity> entities) {
        return entities.stream().map(this::copyEntityToModel).collect(Collectors.toList());
    }

    /**
     * 将model对象转换成entity对象
     *
     * @param model
     * @return
     */
    public abstract Entity copyModelToEntity(Model model);

    public List<Entity> copyModelToEntity(List<Model> models) {
        return models.stream().map(this::copyModelToEntity).collect(Collectors.toList());
    }
}
