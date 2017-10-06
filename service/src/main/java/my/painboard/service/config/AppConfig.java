package my.painboard.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"my.painboard.service.controller"})
public class AppConfig {
}
