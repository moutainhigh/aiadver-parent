package com.aiadver.boot.data.jpa.generator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * @author george
 */
public class SnowflakeIdentifierGenerator implements Configurable, IdentifierGenerator {

    private static SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return snowflakeIdWorker.nextId();
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        long workerId = Long.parseLong(params.getProperty("workerId"));
        long dataCenterId = Long.parseLong(params.getProperty("dataCenterId"));
        snowflakeIdWorker = new SnowflakeIdWorker(workerId, dataCenterId);
    }
}
