# Spring Boot × Slack Socket Mode Sample

このプロジェクトは、Spring BootとSlack Socket Modeを使用して、シンプルなSlackボットを実装するサンプルプロジェクトです。メンションに対して応答する基本的な機能を実装しています。

## 技術スタック

- Java 21
- Spring Boot 3.5.5
- [Slack Bolt for Java](https://slack.dev/java-slack-sdk/guides/bolt-socket-mode) 1.45.3
- Gradle 

## Slack App の設定

1. [Slack API](https://api.slack.com/apps)でアプリを作成します。
2. 以下のApp Manifestを使用してアプリを設定します：

```yaml
display_information:
  name: YourBotName
features:
  bot_user:
    display_name: YourBotName
    always_online: true
oauth_config:
  scopes:
    bot:
      - app_mentions:read
      - channels:history
      - chat:write
settings:
  event_subscriptions:
    bot_events:
      - message.channels
      - app_mention
  interactivity:
    is_enabled: true
  org_deploy_enabled: false
  socket_mode_enabled: true
  token_rotation_enabled: false
```

3. App Manifestを適用後、以下のトークンを取得します：
   - Bot User OAuth Token (`xoxb-*`) - OAuth & Permissionsページから取得
   - App-Level Token (`xapp-*`) - Basic Informationページから取得（Generate Token & Scopesボタンから作成）

## アプリケーションのセットアップ

1. このリポジトリをクローンします：

```bash
git clone https://github.com/hiroshikubobeng/spring-slack-socket-mode.git
cd spring-slack-socket-mode
```

2. `application-sample.properties`をコピーして`application.properties`を作成します：

```bash
cp src/main/resources/application-sample.properties src/main/resources/application.properties
```

3. `application.properties`に上記で取得したSlackトークンを設定します：

```properties
slack.bot.token=xoxb-your-bot-token
slack.app.token=xapp-your-app-token
```

## 実行方法

Gradleを使用してアプリケーションを実行します：

```bash
./gradlew bootRun
```

## 機能

- Slackでボットにメンションを送ると、メンションしたユーザーに対して"Hello @username!"と応答します。

![Slack Bot Response](.github/images/slack-bot-response.png)

## ライセンス

このプロジェクトは[MITライセンス](LICENSE)の下で公開されています。詳細は[LICENSE](LICENSE)ファイルをご覧ください。