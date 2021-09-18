package ru.digitalleague.factory.ok;

import ru.digitalleague.factory.ok.notification.Decorator;
import ru.digitalleague.factory.ok.notification.Notification;
import ru.digitalleague.factory.ok.notification.factory.NotificationFactory;
import ru.digitalleague.factory.ok.notification.factory.MailNotificationFactory;
import ru.digitalleague.factory.ok.notification.factory.PhoneNotificationFactory;

public class Main {

    public static void main(String[] args) {
        User user = new User(2L, "Денис", "denis@gmail.com", "+79522668105");
        NotificationFactory factory = true ? new PhoneNotificationFactory() : new MailNotificationFactory();
        Notification decorator = new Decorator(factory.makeNotification(user), user);
        sendNotification(factory.makeNotification(user));
        sendNotification(decorator);
    }

    private static void sendNotification(Notification notification) {
        System.out.println(notification.getText());
    }
}
