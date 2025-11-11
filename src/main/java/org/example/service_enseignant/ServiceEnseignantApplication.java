package org.example.service_enseignant;

import org.example.service_enseignant.Configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
@EnableFeignClients(basePackages = "org.example")

public class ServiceEnseignantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEnseignantApplication.class, args);
    }

}
