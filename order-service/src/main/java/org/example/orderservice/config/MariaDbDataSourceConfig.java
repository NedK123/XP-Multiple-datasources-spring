package org.example.orderservice.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.example.orderservice.persistence.process",
        entityManagerFactoryRef = "mariadbEntityManager",
        transactionManagerRef = "mariadbTransactionManager"
//        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class
)
public class MariaDbDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.mariadb")
    public DataSource mariadbDataSource() {
        return DataSourceBuilder.create().url("jdbc:mariadb://localhost:3310/springbootdb?user=myuser&password=secret")
                .username("myuser").password("secret").build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mariadbEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("mariadbDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("org.example.orderservice.persistence.process")
                .persistenceUnit("mariadbDataSource").build();
    }

    @Bean
    public PlatformTransactionManager mariadbTransactionManager(@Qualifier("mariadbEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
