package ru.digitalleague.factory.ok.notification;

import ru.digitalleague.factory.ok.User;

public class PushNotification implements Notification {

    private User user;

    public PushNotification(User user) {
        this.user = user;
    }

    public String getText() {
        return String.format(NotificationType.PUSH.getMessage(), user.getName(), user.getId());
    }
}
