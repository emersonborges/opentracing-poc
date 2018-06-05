package br.com.poc.opentracing.customer.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DatasourceConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriver;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.hikari.pool-name}")
    private String dataSourceHikariPoolName;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private Integer dataSourceHikariMaximumPoolSize;

    @Bean
    public SpringLiquibase liquibase(@Qualifier("dataSource") DataSource dataSource) throws SQLException {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath*:db/changelog-master.xml");
        springLiquibase.setContexts("development, production");
        return springLiquibase;
    }


    @Bean(destroyMethod = "close", name = "dataSource")
    public DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(dataSourceDriver);
        dataSourceConfig.setJdbcUrl(dataSourceUrl);
        dataSourceConfig.setUsername(dataSourceUsername);
        dataSourceConfig.setPassword(dataSourcePassword);
        dataSourceConfig.setPoolName(dataSourceHikariPoolName);
        dataSourceConfig.setMaximumPoolSize(dataSourceHikariMaximumPoolSize);

        return new HikariDataSource(dataSourceConfig);
    }
}
