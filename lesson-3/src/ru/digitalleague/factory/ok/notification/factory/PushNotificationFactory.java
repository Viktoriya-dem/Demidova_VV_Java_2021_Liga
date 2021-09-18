package ru.digitalleague.factory.ok.notification.factory;

import ru.digitalleague.factory.ok.User;
import ru.digitalleague.factory.ok.notification.Notification;
import ru.digitalleague.factory.ok.notification.PushNotification;


public class PushNotificationFactory implements NotificationFactory {
    public Notification makeNotification(User user) {
        return new PushNotification(user);
    }
}
