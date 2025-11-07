package com.teprotejo.segurity;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;


public class SegurityUtil {


    private static String PEPPER_KEY = "#p5g@mnEx4&%x8XGZsL!gvi^7V&oo4vC";


    private static final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(
            16,32,1,4096,3);

    public static String hashPassword(String password) {
        return encoder.encode(password+ PEPPER_KEY);

    }

    public static boolean validePassword(String password, String hashpass){
        return encoder.matches(password+ PEPPER_KEY,hashpass);
    }

}
