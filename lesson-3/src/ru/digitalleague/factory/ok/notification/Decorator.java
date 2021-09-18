package ru.digitalleague.factory.ok.notification;

import ru.digitalleague.factory.ok.User;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Decorator implements Notification {

    private Notification notification;
    private User user;

    public Decorator(Notification notification, User user) {
        this.notification = notification;
        this.user = user;
    }

    @Override
    public String getText() {
        ResourceBundle message = ResourceBundle.getBundle("resources/message", user.getLanguage());
        Object[] messageArguments = {
                user.getName(),
                user.getEmail(),
                user.getPhone()
        };
        MessageFormat formatter = new MessageFormat(notification.getText());
        switch (notification.getClass().getSimpleName()) {
            case "MailNotification":
                formatter.applyPattern(message.getString("mail"));
                break;
            case "PhoneNotification":
                formatter.applyPattern(message.getString("phone"));
                break;
            case "PushNotification":
                formatter.applyPattern(message.getString("push"));
                break;
        }
        return formatter.format(messageArguments);
    }
}

