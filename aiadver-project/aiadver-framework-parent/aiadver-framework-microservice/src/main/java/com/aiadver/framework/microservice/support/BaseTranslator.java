package com.aiadver.framework.microservice.support;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author george
 */
public abstract class BaseTranslator<Source, Target> {

    /**
     * 将Source对象转换成Target对象
     *
     * @param source
     * @return
     */
    public abstract Target copySourceToTarget(Source source);

    /**
     * 将Source对象转换成Target对象
     *
     * @param sources
     * @return
     */
    public List<Target> copySourceToTargetList(Collection<Source> sources) {
        return sources.stream().map(this::copySourceToTarget).collect(Collectors.toList());
    }

    public Set<Target> copySourceToTargetSet(Collection<Source> sources) {
        return sources.stream().map(this::copySourceToTarget).collect(Collectors.toSet());
    }

    /**
     * 将Target对象转换成Source对象
     *
     * @param target
     * @return
     */
    public abstract Source copyTargetToSource(Target target);

    /**
     * 将Target对象转换成Source对象
     *
     * @param targets
     * @return
     */
    public List<Source> copyTargetToSourceList(Collection<Target> targets) {
        return targets.stream().map(this::copyTargetToSource).collect(Collectors.toList());
    }

    public Set<Source> copyTargetToSourceSet(Collection<Target> targets) {
        return targets.stream().map(this::copyTargetToSource).collect(Collectors.toSet());
    }

}
