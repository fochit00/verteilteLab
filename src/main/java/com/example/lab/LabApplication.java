package com.example.lab;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Theme("flowcrmtutorial")
public class LabApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }

}
