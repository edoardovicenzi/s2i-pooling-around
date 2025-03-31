package solutions.vdesign.util;

import java.util.*;

import solutions.vdesign.datatransfer.User;

public class UserDecorator {

    private User user;

    public UserDecorator() {
        this.user = new User();
    }

    public UserDecorator(User existinUser) {
        this.user = existinUser;
    }

    public UserDecorator inputName() {
        String userName = ConsoleUtil.getInputString("Dimmi il tuo nome: ", "[a-zA-Z][a-zA-Z ]*");
        this.user.setNome(userName);
        return this;
    }

    public UserDecorator inputSurname() {
        String userSurname = ConsoleUtil.getInputString("Dimmi il tuo cognome: ", "[a-zA-Z][a-zA-Z ]*");
        this.user.setCognome(userSurname);
        return this;
    }

    public UserDecorator inputAddress() {
        String userAddress = ConsoleUtil.getInputString("Dimmi il tuo indirizzo: ");
        this.user.setIndirizzo(userAddress);
        return this;
    }

    public UserDecorator inputIDCardIdentifier() {
        String userIDCardIdentifier = ConsoleUtil.getInputString("Dimmi il codice della carta di identità: ", "[A-Z]{2}\\s\\d{6}\\s\\d");
        this.user.setIdDocumento(userIDCardIdentifier);
        return this;
    }

    public UserDecorator inputBirthDate() {
        Date userBirthDate = ConsoleUtil.getInputDate("Dimmi quando sei nato (es. 15/01/1990): ");
        this.user.setDataNascita(userBirthDate);
        return this;
    }

    public User getUser() {
        return this.user;
    }

}
