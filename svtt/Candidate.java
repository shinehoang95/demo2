package fpt.svtt;

import java.io.Serializable;

/**
 *
 * @author HCD-Fresher157
 * 
*/
public class Candidate implements Serializable{

    private String firstName;
    private String lastName;
    private int brithDay;
    private String address;
    private String phone;
    private String email;
    private int candidate_type;

    public Candidate() {
    }
    

    /**
     *
     * @param firstName
     * @param lastName
     * @param brithDay
     * @param address
     * @param phone
     * @param email
     * @param candidate_type
     */
    public Candidate(String firstName, String lastName, int brithDay, String address, String phone, String email,
            int candidate_type) {
//        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.brithDay = brithDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidate_type = candidate_type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBrithDay() {
        return brithDay;
    }

    public void setBrithDay(int brithDay) {
        this.brithDay = brithDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidate_type() {
        return candidate_type;
    }

    public void setCandidate_type(int candidate_type) {
        this.candidate_type = candidate_type;
    }

    @Override
    public String toString() {
        return "Candidate [firstName=" + firstName + ", lastName=" + lastName + ", brithDay=" + brithDay + ", address="
                + address + ", phone=" + phone + ", email=" + email + ", candidate_type=" + candidate_type + "]";
    }

}
