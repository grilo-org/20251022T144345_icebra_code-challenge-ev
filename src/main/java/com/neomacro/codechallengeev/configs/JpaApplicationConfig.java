package com.neomacro.codechallengeev.configs;

import org.springframework.context.annotation.*;
import org.springframework.dao.support.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;

import java.util.logging.*;

@Configuration
@EnableJpaRepositories("com.neomacro.codechallengeev.account.repository")
@EnableTransactionManagement
class JpaApplicationConfig {
    private static final Logger logger = Logger
            .getLogger(JpaApplicationConfig.class.getName());
    @Bean
    public AbstractEntityManagerFactoryBean entityManagerFactory() {
        logger.info("Loading Entity Manager...");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("transactions-optional");
        return factory;
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        logger.info("Loading Transaction Manager...");
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }
    @Bean
    public PersistenceExceptionTranslator persistenceExceptionTranslator() {
        return null; //TODO new OpenJpaDialect();
    }
}