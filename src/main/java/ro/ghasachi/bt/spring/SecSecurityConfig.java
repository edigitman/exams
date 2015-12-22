package ro.ghasachi.bt.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
@ComponentScan({ "ro.ghasachi.bt.security" })
public class SecSecurityConfig {

    public SecSecurityConfig() {
        super();
    }

}
