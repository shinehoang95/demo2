package fpt.svtt;

import java.io.Serializable;

/**
 *
 * @author HCD-Fresher157
 * 
*/
public class ExperienceCandidate extends Candidate implements Serializable{

    private int expInYear;
    private String proSkill;

    public ExperienceCandidate() {
        super();
    }
    
    /**
     * 
     * @param expInYear
     * @param proSkill
     * @param firstName
     * @param lastName
     * @param brithDay
     * @param address
     * @param phone
     * @param email
     * @param candidate_type 
     */
    public ExperienceCandidate(int expInYear, String proSkill, String firstName, String lastName, int brithDay, String address, String phone, String email, int candidate_type) {
        super(firstName, lastName, brithDay, address, phone, email, candidate_type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " [expInYear=" + expInYear + ", proSkill=" + proSkill + "]";
    }
}
