package fpt.svtt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_Database {

    static Scanner k = new Scanner(System.in);
    static DataAccess da;

    public static void main(String[] args) {
        Main_Database main = new Main_Database();
        da = new DataAccess();
// main.menu(); 
// main.outputCandidate(); 
        System.out.println(da.findCandidateById(6));
    }

    /**
     * * * @return
     */
    public int choose() {
        int c;
        do {
            System.out.print("Choose requirement 1 or 2 : ");
            c = Integer.parseInt(k.nextLine());
        } while (c < 1 || c > 2);
        return c;
    }

    /**
     * *
     */
    public void menu() {
        switch (choose()) {
            case 1:
                int candidateType;
                do {
                    System.out.println("Type candidate : ");
                    System.out.println("--Experience Candidate = 0");
                    System.out.println("--Fresher Candidate = 1");
                    System.out.println("--Intern Candidate = 2");
                    System.out.print("choose : ");
                    candidateType = Integer.parseInt(k.nextLine());
// candidateType = k.nextInt();
                } while (candidateType < 0 || candidateType > 2);
                switch (candidateType) {
                    case 0:
                        inputInformationForExperience();
                        break;
                    case 1:
                        inputInformationForFresher();
                        break;
                    case 2:
                        inputInformationForIntern();
                        break;
                }
                break;
            case 2:
                int choice;
                do {
                    System.out.println("Input information for recruitment : 1");
                    System.out.println("Select candidate to apply the chose recruitment : 2");
                    System.out.print("choose : ");
                    choice = Integer.parseInt(k.nextLine());
                } while (choice < 0 || choice > 2);
                switch (choice) {
                    case 1:
                        inputInformationForRecruitment();
                        break;
                    case 2:
                        toApplyTheRecruitment();
                        break;
                    case 3:
                        inputInformationForIntern();
                        break;
                }
                break;
        }
    }

    public void inputInformationForExperience() {
        Candidate can = new ExperienceCandidate();
        inputInformationForCandidate(can);
        can.setCandidate_type(0);
        int expInYear;
        do {
            System.out.print("Input experience in year (0-100) : ");
            expInYear = k.nextInt();
        } while (expInYear < Common.MIN_EXPERIENCE_IN_YEAR || expInYear > Common.MAX_EXPERIENCE_IN_YEAR);
        ((ExperienceCandidate) can).setExpInYear(expInYear);
        k.nextLine();
        System.out.print("Input pro skill : ");
        ((ExperienceCandidate) can).setProSkill(k.nextLine());
        System.out.println(can.toString());
        try {
            da.insertCandidateIntoDatabase(can);
            System.out.println("done");
        } catch (SQLException e) { // TODO Auto-generated catch block 
            e.printStackTrace();
        }
    }

    public void inputInformationForFresher() {
        Candidate can = new FresherCandidate();
        inputInformationForCandidate(can);
        can.setCandidate_type(1);
        System.out.print("Input graduation day : ");
        ((FresherCandidate) can).setGraduationDate(k.nextLine());
        String graduationRank = null;
        int check;
        do {
            System.out.println("Input graduation rank : ");
            System.out.println("--Excellence = 1");
            System.out.println("--Good = 2");
            System.out.println("--Fair = 3");
            System.out.println("--Poor = 4");
            check = k.nextInt();
        } while (check < 1 || check > 4);
        switch (check) {
            case 1:
                graduationRank = "Excellence";
                break;
            case 2:
                graduationRank = "Good";
                break;
            case 3:
                graduationRank = "Fair";
                break;
            case 4:
                graduationRank = "Poor";
        }
        ((FresherCandidate) can).setGraduationRank(graduationRank);
        k.nextLine();
        System.out.print("Input education : ");
        ((FresherCandidate) can).setEducation(k.nextLine());
        System.out.println(can.toString());
        try {
            da.insertCandidateIntoDatabase(can);
            System.out.println("done");
        } catch (SQLException e) { // TODO Auto-generated catch block 
            e.printStackTrace();
        }
    }

    public void inputInformationForIntern() {
        Candidate can = new InternCandidate();

        inputInformationForCandidate(can);

        can.setCandidate_type(2);
        System.out.print(
                "Input major : ");
        ((InternCandidate) can).setMajor(k.nextLine());
        System.out.print(
                "Input semester : ");
        ((InternCandidate) can).setSemester(k.nextLine());
        System.out.print(
                "Input university name : ");
        ((InternCandidate) can).setUniversityName(k.nextLine());
        System.out.println(
                ((InternCandidate) can).toString());
        try {
            da.insertCandidateIntoDatabase(can);
            System.out.println("done");
        } catch (SQLException e) { // TODO Auto-generated catch block 
            e.printStackTrace();
        }
    }

    public void inputInformationForCandidate(Candidate can) {
        System.out.print("Input first name : ");
        can.setFirstName(k.nextLine());
        System.out.print("Input last name : ");
        can.setLastName(k.nextLine());
        int birthDay = 0;
        do {
            System.out.print("Input birthday (1900...current day) : ");
            birthDay = k.nextInt();
        } while (birthDay < Common.LAST_BIRTHDAY || birthDay > Common.CURRENT_YEAR);
        can.setBrithDay(birthDay);
        k.nextLine();
        System.out.print("Input address : ");
        can.setAddress(k.nextLine());
        boolean flagPhone;
        String phone;
        do {
            System.out.print("Input phone number : ");
            phone = k.nextLine();
            flagPhone = phone.matches(Common.PHONE_PATTERN);
        } while (!flagPhone);
        can.setPhone(phone);
        boolean flagEmail;
        String email;
        do {
            System.out.print("Input email : ");
            email = k.nextLine();
            Pattern pattern = Pattern.compile(Common.EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            flagEmail = matcher.matches();
        } while (!flagEmail);
        can.setEmail(email);
    }

    public void inputInformationForRecruitment() {
        Recruitment re = new Recruitment();
        String recruimentCode;
        boolean flagCode;
        do {
            System.out.print("Input recruitment code : ");
            recruimentCode = k.nextLine();
            flagCode = recruimentCode.matches(Common.RECRUITMENT_CODE);
        } while (!flagCode);
        re.setRecruimentCode(recruimentCode);
        int choicePosition;
        String position = null;
        do {
            System.out.println("Input position for recruitment : ");
            System.out.println("--Dev : 1");
            System.out.println("--Test : 2");
            System.out.println("--Other : 3");
            System.out.print("Choose : ");
            choicePosition = k.nextInt();
        } while (choicePosition < 1 || choicePosition > 3);
        switch (choicePosition) {
            case 1:
                position = "Dev";
                break;
            case 2:
                position = "Test";
                break;
            case 3:
                position = "Other";
        }
        re.setPosition(position);
        int choicePackage;
        String packageRecruiment = null;
        do {
            System.out.println("Input recruitment package : ");
            System.out.println("--A : 1");
            System.out.println("--B : 2");
            System.out.println("--C : 3");
            System.out.print("Choose : ");
            choicePackage = k.nextInt();
        } while (choicePackage < 1 || choicePackage > 3);
        switch (choicePackage) {
            case 1:
                packageRecruiment = "A";
                break;
            case 2:
                packageRecruiment = "B";
                break;
            case 3:
                packageRecruiment = "C";
        }
        re.setRecruimentPackage(packageRecruiment);
        try {
            da.insertRecruitmentIntoDatabase(re);
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void toApplyTheRecruitment() {
        System.out.print("Input id candidate : ");
        int id = Integer.parseInt(k.nextLine());
        System.out.print("Input recruitment code : ");
        String code = k.nextLine();

        Candidate can = da.findCandidateById(id);
        Recruitment re = da.findRecruitmentByCode(code);
        String recruitmentPackage = convertCandidateTypeToRecruitmentPackage(can);
        if (recruitmentPackage.equalsIgnoreCase(re.getRecruimentPackage())) {
            re.setNumber(re.getNumber() + 1);
            //update into database 
            System.out.println("Submitted this candidate successfully");
        } else {
            System.out.println("This candidate not matching");
        }

    }

    public void outputCandidate() {
        String sql = "select * from candidate";
        ResultSet rs = da.getData(sql);
        try {
            while (rs.next()) {
                System.out.println(rs.getString("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String convertCandidateTypeToRecruitmentPackage(Candidate can) {
        if (can.getCandidate_type() == 0) {
            return "A";
        } else if (can.getCandidate_type() == 1) {
            return "B";
        }
        return "C";
    }
}
