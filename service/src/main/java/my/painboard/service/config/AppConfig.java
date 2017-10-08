package my.painboard.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"my.painboard.service.controller", "my.painboard.service.filesystem"})
public class AppConfig {
}
