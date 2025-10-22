package com.neomacro.codechallengeev;

import com.neomacro.codechallengeev.account.model.*;
import com.neomacro.codechallengeev.customer.model.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.context.annotation.*;
import org.springframework.data.rest.core.config.*;
import org.springframework.data.rest.webmvc.config.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import javax.persistence.*;

@SpringBootApplication
@EnableFeignClients
@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class CodeChallengeEvApplication {

    private static final EntityManagerFactory INSTANCE = Persistence.createEntityManagerFactory("transactions-optional");

    @RequestMapping("/codechallenge")
    @ResponseBody
    public String codechallenge() {
        return "Code Challenge";
    }

    public static void main(String[] args) {
        SpringApplication.run(CodeChallengeEvApplication.class, args);
    }

    @Component
    class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {

        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
            config.exposeIdsFor(AccountModel.class);
            config.exposeIdsFor(CustomerModel.class);
        }
    }
}
