package ethp.mostafa.serviceemailspringboot.services;

import ethp.mostafa.serviceemailspringboot.entities.Message;

public interface EmailService {
    // To send a simple email
    void sendSimpleMail(Message details);

    // To send an email with attachment
    String sendMailWithAttachment(Message details);

    String sendMailTemplate(Message details) ;
}
