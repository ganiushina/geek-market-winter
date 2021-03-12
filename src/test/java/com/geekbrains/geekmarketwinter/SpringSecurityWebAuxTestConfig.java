package com.geekbrains.geekmarketwinter;


import com.geekbrains.geekmarketwinter.entites.Role;
import com.geekbrains.geekmarketwinter.entites.SystemUser;
import com.geekbrains.geekmarketwinter.entites.User;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public void userDetailsService() {

        User basicAdmin = new User();
        basicAdmin.setUserName("user");
        basicAdmin.setRoles(Arrays.asList(
                new Role("ROLE_EMPLOYEE"),
                new Role("ROLE_ADMIN")));


        SystemUser systemUser = new SystemUser();

        User managerUser = new User();
        managerUser.setUserName("managerUser");
        managerUser.setRoles(Arrays.asList(new Role("ROLE_EMPLOYEE"), new Role("ROLE_MANAGER")));
     //   managerUser.

//        return new InMemoryUserDetailsManager(Arrays.asList(
//                basicAdmin, managerUser
//        ));
    }
}
