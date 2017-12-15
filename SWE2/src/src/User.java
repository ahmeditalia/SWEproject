package src;



import java.util.*;

/**
 * 
 */
public class User {


    public User() {
    }

    private String Username;

    private String Password;

    private String E_mail;

    private String PhoneNumber;

    private String Gender;

    private String Address;

    public byte Type;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String value) {
        Username=value;
    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String value) {
        Password=value;
    }
    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String value) {
        E_mail=value;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String value) {
        PhoneNumber=value;
    }
    public String getGender() {
        return Gender;
    }

    public void setGender(String value) {
        Gender=value;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String value) {
        Address=value;
    }

    public byte getType() {
        return Type;
    }

    public void setType(byte value) {
        Type=value;
    }


}