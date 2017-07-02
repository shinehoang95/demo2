package fpt.svtt;

import java.io.Serializable;

/**
 *
 * @author HCD-Fresher157
 * 
*/
public class InternCandidate extends Candidate implements Serializable {

    private String major;
    private String semester;
    private String universityName;

    public InternCandidate() {
        super();
    }

    /**
     * 
     * @param major
     * @param semester
     * @param universityName
     * @param firstName
     * @param lastName
     * @param brithDay
     * @param address
     * @param phone
     * @param email
     * @param candidate_type 
     */
    public InternCandidate(String major, String semester, String universityName, String firstName, String lastName, int brithDay, String address, String phone, String email, int candidate_type) {
        super(firstName, lastName, brithDay, address, phone, email, candidate_type);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + "[major=" + major + ", semester=" + semester + ", universityName=" + universityName
                + "]";
    }
}
