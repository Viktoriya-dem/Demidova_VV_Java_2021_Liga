package ru.digitalleague.factory.ok.notification;

public enum NotificationType {

    MAIL("Hi %s! Notification by mail %s!"),
    PHONE("Hi %s! Notification by phone %s!"),
    PUSH("Hi %s! Push-notification!");

    private String message;

    public String getMessage() {
        return message;
    }

    NotificationType(String message) {
        this.message = message;
    }

}
