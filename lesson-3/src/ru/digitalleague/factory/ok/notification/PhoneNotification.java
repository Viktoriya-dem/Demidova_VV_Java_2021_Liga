package ru.digitalleague.factory.ok.notification;


import ru.digitalleague.factory.ok.User;

public class PhoneNotification implements Notification {

    private User user;

    public PhoneNotification(User user) {
        this.user = user;
    }

    public String getText() {
        return String.format(NotificationType.PHONE.getMessage(), user.getName(), user.getPhone());
    }
}
