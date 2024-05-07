package com.multiple.database.in.secondDB.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerFactoryBean",
        basePackages = {"com.multiple.database.in.secondDB.repo"},
        transactionManagerRef = "secondTransactionManager"
)
public class SecondDbConfig {
    @Bean(name = "secondDataSource")
    @Primary
    @ConfigurationProperties(prefix = "second.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondEntityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean =new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        Map<String,Object> map = new HashMap<>();
        map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        map.put("hibernate.show_sql", "true");
        map.put("hibernate.hbm2ddl.auto","update");
        map.put("hibernate.format_sql", "true");
        bean.setDataSource(dataSource());
        bean.setJpaVendorAdapter(adapter);
        bean.setJpaPropertyMap(map);
        bean.setPackagesToScan("com.multiple.database.in.secondDB.model");
        return bean;
    }

    @Primary
    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }
}
