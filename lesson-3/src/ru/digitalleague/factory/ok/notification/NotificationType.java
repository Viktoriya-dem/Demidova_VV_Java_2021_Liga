package ru.digitalleague.factory.ok.notification;

public enum NotificationType {

    MAIL("Привет %s! Уведомление по почте %s!"),
    PHONE("Привет %s! Уведомление по телефону %s!"),
    PUSH("Привет %s! Push-уведомление!");

    private String message;

    public String getMessage() {
        return message;
    }

    NotificationType(String message) {
        this.message = message;
    }

}
