package org.kiye.eternalreturnrootmanagerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EternalReturnRootManagerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EternalReturnRootManagerBackendApplication.class, args);
    }

}
