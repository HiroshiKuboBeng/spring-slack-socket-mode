package com.github.hiroshikubobeng.spring_slack_socket_mode;

import com.slack.api.bolt.jakarta_socket_mode.SocketModeApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSlackSocketModeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSlackSocketModeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(SocketModeApp socketModeApp) {
        return args -> socketModeApp.start();
    }

}
