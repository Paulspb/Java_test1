package ru.stqa.ptf.mantis.model;

/**
 * Created by khomep on 29-Jul-16.
 */
public class MailMessage {

    public String to;
    public String text;

    public MailMessage(String to, String text) {
         this.to = to;
         this.text = text;
    }

}
