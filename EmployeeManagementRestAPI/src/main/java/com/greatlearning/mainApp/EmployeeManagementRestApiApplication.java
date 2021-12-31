package com.greatlearning.mainApp;

import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;
import com.greatlearning.service.UserService;
import com.greatlearning.service.UserServiceJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.LinkedList;
import java.util.List;

@EntityScan(basePackages = {"com.greatlearning.entity"})
@EnableJpaRepositories(basePackages = "com.greatlearning.dao")
@SpringBootApplication(scanBasePackages = {"com.greatlearning.*"})
public class EmployeeManagementRestApiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(EmployeeManagementRestApiApplication.class, args);

        //populate initial user entry in database having role as ADMIN
        UserService userServiceJpaRepository = applicationContext.getBean(UserServiceJpaRepositoryImpl.class);
        User user = new User("Akhil", "123");
        List<Role> roleList = new LinkedList<Role>();
        roleList.add(new Role("ADMIN"));
        user.setRoles(roleList);
        userServiceJpaRepository.addUser(user);
    }

}
