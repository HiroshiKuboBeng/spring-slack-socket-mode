package com.github.hiroshikubobeng.spring_slack_socket_mode;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.jakarta_socket_mode.SocketModeApp;
import com.slack.api.model.event.AppMentionEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackSocketModeMain {

    @Value("${slack.bot.token}")
    private String slackBotToken;

    @Value("${slack.app.token}")
    private String slackAppToken;


    @Bean
    public App slackApp() {
        AppConfig appConfig = AppConfig.builder().singleTeamBotToken(slackBotToken).build();
        App app = new App(appConfig);

        app.event(AppMentionEvent.class, (payload, ctx) -> {
            ctx.say("Hello <@" + payload.getEvent().getUser() + ">!");
            return ctx.ack();
        });

        return app;
    }

    @Bean
    public SocketModeApp socketModeApp(App app) throws Exception {
        return new SocketModeApp(slackAppToken, app);
    }
}
