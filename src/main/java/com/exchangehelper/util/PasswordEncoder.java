package com.exchangehelper.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    private MessageDigest messageDigest;

    public PasswordEncoder() {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            //error
        }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        if (messageDigest == null) {
            return rawPassword.toString();
        }

        messageDigest.update(rawPassword.toString().getBytes());

        byte byteData[] = messageDigest.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
