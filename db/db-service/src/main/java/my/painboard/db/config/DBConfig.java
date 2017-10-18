package my.painboard.db.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan("my.painboard.db.model")
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = "my.painboard.db.service")
public class DBConfig {

}
