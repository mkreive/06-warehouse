package lt.javau5.warehouse.configurations;

import lt.javau5.warehouse.services.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(MyConfig.class);

    @Autowired
    MainService service;


    @Override
    public void run(ApplicationArguments args) {
        String msg = service.seedData() ? "MY MSG: Data seeded successfully!" : "MY MSG: Data was not seeded";
        log.info(msg);
    }
}
