package ryu.useless.project03.services;

import org.bouncycastle.util.encoders.Hex;
import ryu.useless.project03.api.*;
import ryu.useless.project03.data.PersonRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PersonService {
    private PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<PersonBasicView> getPersonsBasicView() {
        return personRepository.getPersonsBasicView();
    }

    /**
     Add person app thingy: -------------------------------------------------------------------------------------
     **/
    public void createPerson(PersonCreateView personCreateView) {
        String originalPassword = personCreateView.getPassword();
        String hashedPassword = hashPassword(originalPassword);
        personCreateView.setPassword(hashedPassword);

        personRepository.createPerson(personCreateView);
    }
    private String hashPassword(String password) {
        try {
            String pswd = new String(password);
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //hash and stuff
            byte[] hash = digest.digest(pswd.getBytes(StandardCharsets.UTF_8));
            String sha256hex = new String(Hex.encode(hash));
            password = sha256hex;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return password;
    }
    public void editPerson(PersonEditView personEditView) {
        personRepository.editPerson(personEditView);
    }

    public List<SQLinjectionView> getSQLbasicView() {
        return personRepository.getSQLview();
    }
    public void sqlAttack(String input){
        personRepository.getSQLviewAttack(input);
    }
    public void sqlAttackPRMMNTSTMNT(String input){
        personRepository.getSQLviewAttackPrprstmnt(input);
    }

    public PersonDetailedView findPersonDetailedView(String email) {
        return personRepository.findPersonDetailedView(email);
    }
    public boolean getStatusEdit(){ //For the Edit
        return personRepository.isDidItRun();
    }
    public boolean getStatusCreate(){
        return personRepository.didCreateRunned();
    }
    // filter pokus: ----------------
    public List<PersonFilterView> getFilterThing(String name) {
        return personRepository.filterPersonView(name);
    }
    }


