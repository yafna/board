package my.painboard.db.config;


import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import my.painboard.db.service.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan("my.painboard.db.model")
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = "my.painboard.db.service")
//@PropertySource("classpath:db.properties")
public class DBConfig {
    @Autowired
    private DataSource dataSource;
//    @Value("${f.datasource.url}")
//    private String dbUrl;
//
//    @Value("${f.datasource.username}")
//    private String dbUser;
//
//    @Value("${f.datasource.password}")
//    private String dbPassword;
//
//    @Value("${f.datasource.driverClassName}")
//    private String dbDriver;
//
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
////        System.out.println("dataSource.getConnection().get = " + dataSource.getConnection().get);
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setPackagesToScan("my.painboard.db.service", "my.painboard.db.model");
//        sessionFactory.setHibernateProperties(additionalProperties());
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(dbDriver);
//        dataSource.setUrl(dbUrl);
//        dataSource.setUsername(dbUser);
//        dataSource.setPassword(dbPassword);
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        return properties;
//    }

    @Bean
    public MyClass myClass(){
        return new MyClass(dataSource);
    }
}
