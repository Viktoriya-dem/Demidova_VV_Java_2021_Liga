package ru.digitalleague.factory.ok.notification;

import ru.digitalleague.factory.ok.User;

import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
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
        String [] form=notification.getText().split(" ");
        String result="";
        for (int i=0; i<form.length-1; i++){
            result=result + message.getString(form[i]) + " ";
        }
        result=result+form[form.length-1];
        return result;
    }

}

