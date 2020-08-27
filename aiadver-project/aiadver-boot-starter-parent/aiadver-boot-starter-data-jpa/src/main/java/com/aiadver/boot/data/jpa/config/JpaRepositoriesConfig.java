package com.aiadver.boot.data.jpa.config;

import com.aiadver.boot.data.jpa.base.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author george
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.aiadver.**.repository", repositoryBaseClass = BaseRepositoryImpl.class)
public class JpaRepositoriesConfig {
}
