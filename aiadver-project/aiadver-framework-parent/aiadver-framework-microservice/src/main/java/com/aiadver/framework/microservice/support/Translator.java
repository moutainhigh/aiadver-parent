package com.aiadver.framework.microservice.support;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author george
 */
public interface Translator<Source, Target> {

    /**
     * 将Source对象转换成Target对象
     *
     * @param source
     * @return
     */
    Target copySourceToTarget(Source source);

    /**
     * 将Source对象转换成Target对象
     *
     * @param sources
     * @return
     */
    default List<Target> copySourceToTarget(List<Source> sources) {
        return sources.stream().map(this::copySourceToTarget).collect(Collectors.toList());
    }

    /**
     * 将Target对象转换成Source对象
     *
     * @param target
     * @return
     */
    Source copyTargetToSource(Target target);

    /**
     * 将Target对象转换成Source对象
     *
     * @param targets
     * @return
     */
    default List<Source> copyTargetToSource(List<Target> targets) {
        return targets.stream().map(this::copyTargetToSource).collect(Collectors.toList());
    }
}
