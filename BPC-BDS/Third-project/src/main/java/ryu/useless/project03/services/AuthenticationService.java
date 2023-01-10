package ryu.useless.project03.services;

import org.bouncycastle.util.encoders.Hex;
import ryu.useless.project03.api.AuthenticationView;
import ryu.useless.project03.data.PersonRepository;

import java.nio.charset.StandardCharsets; //hash bullshit
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class AuthenticationService {
    private final PersonRepository personRepository;
    public AuthenticationService(PersonRepository personRepository) { //constructor
        this.personRepository = personRepository;
    }
    private AuthenticationView findPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email);
    }
    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        AuthenticationView personAuthView = findPersonByEmail(username);
        if (personAuthView == null) {
            System.out.println("Provided username is not found");
            return false;
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //hash and stuff
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String sha256hex = new String(Hex.encode(hash));
            String passwordGet = personAuthView.getPassword();
            if(passwordGet.replace("\\x","").equals(sha256hex)){ //thic checks, if the user input hash and database hash are the same
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return false; //this one should be returning only if hashed password doesnt match the database one.
    }

}
