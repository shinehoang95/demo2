package fpt.svtt;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HCD-Fresher157
 * 
*/
public class FresherCandidate extends Candidate implements Serializable {

    private String graduationDate;
    private String graduationRank;
    private String education;

    /**
     * 
     * @param graduationDate
     * @param graduationRank
     * @param education
     * @param firstName
     * @param lastName
     * @param brithDay
     * @param address
     * @param phone
     * @param email
     * @param candidate_type 
     */
    public FresherCandidate(String graduationDate, String graduationRank, String education, String firstName, String lastName, int brithDay, String address, String phone, String email, int candidate_type) {
        super(firstName, lastName, brithDay, address, phone, email, candidate_type);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    

    public FresherCandidate() {
        super();
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + "[graduationDate=" + graduationDate + ", graduationRank=" + graduationRank
                + ", education=" + education + "]";
    }
}
