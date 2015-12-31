package ro.ghasachi.bt.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

@Configuration
@ComponentScan({"ro.ghasachi.bt.web", "ro.ghasachi.bt.middleware"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig() {
        super();
    }

    // API

    @Bean
    public JavaMailSender setupEmail() {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("mail.smtp2go.com");
        javaMailSender.setPort(2525);
        javaMailSender.setUsername("online-exam@mail.com");
        javaMailSender.setPassword("secret123");


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");

        javaMailSender.setJavaMailProperties(props);

        return javaMailSender;
    }

}