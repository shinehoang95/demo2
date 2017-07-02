package fpt.svtt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HCD-Fresher157
 * 
*/
public class Main {

    static Scanner k = new Scanner(System.in);
    Common cm = new Common();
    List<Candidate> arrCandidate = new ArrayList<>();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    /**
     *
     * @param can
     */
    public void inputInformationForCandidate(Candidate can) {
        System.out.print("Input frist name : ");
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

    /**
     *
     */
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
        System.out.println(((FresherCandidate) can).toString());
    }

    /**
     *
     */
    public void inputInformationForIntern() {
        Candidate can = new InternCandidate();
        inputInformationForCandidate(can);
        can.setCandidate_type(2);
        System.out.print("Input major : ");
        ((InternCandidate) can).setMajor(k.nextLine());
        System.out.print("Input semester : ");
        ((InternCandidate) can).setSemester(k.nextLine());
        System.out.print("Input university name : ");
        ((InternCandidate) can).setUniversityName(k.nextLine());
        System.out.println(((InternCandidate) can).toString());
    }

    /**
     *
     */
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
        System.out.println(((ExperienceCandidate) can).toString());
    }

    public void saveData(Object obj) {
        try {
            FileOutputStream f = null;
            ObjectOutputStream oOT = null;
            if (obj instanceof Recruitment) {
                f = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\recruiment.txt");
                oOT = new ObjectOutputStream(f);
                oOT.writeObject(initRecruiment());
            } else if (obj instanceof Candidate) {
                f = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\candidate.txt");
                oOT = new ObjectOutputStream(f);
                oOT.writeObject(initCandidate());
            }
            oOT.close();
            f.close();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra!");
        }
    }

    public List<Candidate> readDataCandidate() {
        List<Candidate> arr = new ArrayList<>();
        try {
            FileInputStream f = null;
            ObjectInputStream oIT = null;
            f = new FileInputStream("C:\\Users\\Administrator\\Desktop\\candidate.txt");
            oIT = new ObjectInputStream(f);
            arr = (List<Candidate>) oIT.readObject();
            oIT.close();
            f.close();
        } catch (IOException io) {
            System.out.println("Có lỗi xảy ra! : " + io.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy class");
        }
        return arr;
    }

    public List<Recruitment> readDataRecruitment() {
        List<Recruitment> arr = arr = new ArrayList<>();
        try {
            FileInputStream f = null;
            ObjectInputStream oIT = null;
            f = new FileInputStream("C:\\Users\\Administrator\\Desktop\\recruiment.txt");
            oIT = new ObjectInputStream(f);
            arr = (List<Recruitment>) oIT.readObject();
            oIT.close();
            f.close();
        } catch (IOException io) {
            System.out.println("Có lỗi xảy ra! : " + io.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy class");
        }
        return arr;
    }

    private List<Recruitment> initRecruiment() {
        List<Recruitment> arr = new ArrayList<>();
        arr.add(new Recruitment("11111", "Dev", "A", 0));
        arr.add(new Recruitment("22222", "Test", "A", 0));
        arr.add(new Recruitment("33333", "Other", "A", 0));
        arr.add(new Recruitment("44444", "Dev", "B", 0));
        arr.add(new Recruitment("55555", "Test", "B", 0));
        arr.add(new Recruitment("66666", "Other", "B", 0));
        arr.add(new Recruitment("77777", "Dev", "C", 0));
        arr.add(new Recruitment("88888", "Test", "C", 0));
        arr.add(new Recruitment("99999", "Other", "C", 0));
        return arr;
    }

    private List<Candidate> initCandidate() {
        List<Candidate> arr = new ArrayList<>();
        arr.add(new ExperienceCandidate(1, "java", "lam", "nguyen", 1990, "danang", "123456789", "lam@gmail.com", 0));
        arr.add(new ExperienceCandidate(2, "ruby", "hoang", "nguyen", 1990, "danang", "123456789", "hoang@gmail.com", 0));
        arr.add(new ExperienceCandidate(3, "c++", "hoa", "ton", 1990, "danang", "123456789", "hoa@gmail.com", 0));
        arr.add(new FresherCandidate("2013", "Good", "Duy Tan", "lam", "nguyen", 1990, "danang", "123456789", "lam@gmail.com", 1));
        arr.add(new FresherCandidate("2014", "Good", "Duy Tan", "hoang", "nguyen", 1990, "danang", "123456789", "hoang@gmail.com", 1));
        arr.add(new FresherCandidate("2015", "Excellence", "Kinh Te", "hoa", "ton", 1990, "danang", "123456789", "hoa@gmail.com", 1));
        arr.add(new InternCandidate("student", "second", "Duy Tan", "lam", "nguyen", 1990, "danang", "123456789", "lam@gmail.com", 2));
        arr.add(new InternCandidate("student", "second", "Duy Tan", "hoang", "nguyen", 1990, "danang", "123456789", "hoang@gmail.com", 2));
        arr.add(new InternCandidate("student", "second", "Kinh Te", "hoa", "ton  ", 1990, "danang", "123456789", "hoa@gmail.com", 2));
        return arr;
    }

    private void outputArrayListRecruitment(List<Recruitment> arr) {
        for (Recruitment a : arr) {
            System.out.println(a.toString());
        }
    }

    private void outputArrayListCandidate(List<Candidate> arr) {
        for (Candidate a : arr) {
            System.out.println(a.toString());
        }
    }

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
//                    candidateType = k.nextInt();
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
//                do {
                    Recruitment r = new Recruitment();
                    Candidate c = new Candidate();
//                    saveData(c);
                    saveData(r);
//                    outputArrayListCandidate(readDataCandidate());
                    outputArrayListRecruitment(readDataRecruitment());
//                } while (true);
        }
    }

    public int choose() {
        int c;
        do {
            System.out.print("Choose requirement 1 or 2 : ");
            c = Integer.parseInt(k.nextLine());
        } while (c < 1 || c > 2);
        return c;
    }
}
