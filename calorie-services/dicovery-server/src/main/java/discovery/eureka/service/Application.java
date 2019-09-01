package discovery.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import discovery.eureka.service.component.CrossDomainAccessFilter;

@EnableEurekaServer
@SpringBootApplication
public class Application {

@Bean
public FilterRegistrationBean someFilterRegistration() {

    FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CrossDomainAccessFilter());
        registration.addUrlPatterns("/*");
        registration.setName("CrossDomainAccessFilter");
        registration.setOrder(1);
    
    return registration;
} 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}