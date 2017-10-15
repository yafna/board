package my.painboard.service.app;

import my.painboard.db.config.DBConfig;
import my.painboard.service.config.AppConfig;
import my.painboard.service.config.WebConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {DBConfig.class, AppConfig.class, WebConf.class})
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}
