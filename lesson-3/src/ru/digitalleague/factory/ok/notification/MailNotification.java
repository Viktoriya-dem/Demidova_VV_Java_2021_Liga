package ru.digitalleague.factory.ok.notification;


import ru.digitalleague.factory.ok.User;

public class MailNotification implements Notification {

    private User user;

    public MailNotification(User user) {
        this.user = user;
    }

    public String getText() {
        return String.format(NotificationType.MAIL.getMessage(), user.getName(), user.getEmail());
    }
}
