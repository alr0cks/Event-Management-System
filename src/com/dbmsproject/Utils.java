package com.dbmsproject;

import com.sendgrid.*;

import javax.swing.*;
import java.io.IOException;


/**
 * @author akhil
 */

// This class contains some useful functions used often throughout the projet
public class Utils {
    // This function shows a message dialog and exits
    static void exit(JFrame currentFrame) {
        JOptionPane.showMessageDialog(currentFrame, "Exiting!");
        System.exit(0);
    }

    // This function shows a message dialog on the current frame
    static void showMessage(JFrame currentFrame, String message) {
        JOptionPane.showMessageDialog(currentFrame, message);
    }

    /**
     * This method <i>encrypts</i> the given string
     *
     * @param s String to be encrypted
     *          Each Character of the String is XOR'd with the length of the String
     * @return String with each character XOR'd with length
     */
    static String encrypt(String s) {
        String n = "";
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            int t = c;
            t = t ^ l;
            c = (char) (t);
            n += c;
        }
        return n;
    }

    // This method decrypts the given string by calling encrypt(), as we use a very simple XOR logic for now
    static String decrypt(String s) {
        return encrypt(s);
    }

    static int sendEmail(String toEmail, String subject, String emailContent) {
        Email from = new Email("dbms-project@thescriptgroup.in");
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            return response.getStatusCode();
        } catch (IOException e) {
            Utils.showMessage(null, "Error occurred sending email!\n" + e.getMessage());
        }
        return -1;
    }
}
