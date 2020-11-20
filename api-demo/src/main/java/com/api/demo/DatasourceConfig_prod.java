package com.api.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@ConditionalOnResource(resources = "classpath:application-mysql.yml")
@Profile("mysql")
public class DatasourceConfig_prod {
    private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    @Bean
    public void setup() {
        LOG.info("Setting up datasource for DEV environment. ");
    }
}
