package fpt.svtt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccess {

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    CallableStatement callstmt = null;
    ResultSet rs = null;

    public DataAccess() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AssignmentRecruitment; username=sa; password=12345678");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
// public Connection getConnect() { 
// try { 
// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
// con = DriverManager.getConnection( 
// "jdbc:sqlserver://localhost:1433;databaseName=AssignmentRecruitment; username=sa; password=12345678"); 
// } catch (ClassNotFoundException e) { 
// e.printStackTrace(); 
// } catch (SQLException e) { 
// e.printStackTrace(); 
// } 
// return con; 
// } 

// public void addnewPhongHop(PhongHop pHop) throws SQLException { 
// /* 
// * String sql = 
// * "Insert into PhongHop values('"+pHop.getTenPhong()+"',"+pHop.getSoghe 
// * ()+",'"+pHop.getVitri()+"')"; try { stmt = 
// * getConnect().createStatement(); stmt.executeUpdate(sql); } catch 
// * (SQLException e) { 
// * e.printStackTrace(); } 
// */ 
// String sql = "Insert into Phong values(?,?,?)"; 
// try { 
// getConnect().setAutoCommit(false); 
// pstmt = getConnect().prepareStatement(sql); 
// pstmt.setString(1, pHop.getTenPhong()); 
// pstmt.setInt(2, pHop.getSoghe()); 
// pstmt.setString(3, pHop.getVitri()); 
// pstmt.executeUpdate(); 
// getConnect().commit(); 
// } catch (SQLException e) { 
// e.printStackTrace(); 
// getConnect().rollback(); 
// } 
// getConnect().setAutoCommit(true); 
// } 
// public ArrayList<PhongHop> getListPhongHop() { 
// try { 
// callstmt = getConnect().prepareCall("{call Sp_getPhongHoc()}"); 
// rs = callstmt.executeQuery(); 
// while (rs.next()) { 
// ph = new PhongHop(); 
// ph.setTenPhong(rs.getString("TenPhong")); 
// ph.setSoghe(rs.getInt("SoGhe")); 
// ph.setVitri(rs.getString("Vitri")); 
// ds.add(ph); 
// } 
// } catch (SQLException e) { 
// e.printStackTrace(); 
// } 
// return ds; 
// } 
    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
    }

// public int update(String sql) { 
// int n = 0; 
// try { 
// n = stmt.executeUpdate(sql); 
// } catch (SQLException e) { 
// } // return n; 
// } 
    public void insertCandidateIntoDatabase(Candidate can) throws SQLException {
        int expInYear = 0;
        String sql, proSkill = "", graduationDate = "", graduationRank = "", education = "", major = "", semester = "", universityName = "";
        if (can instanceof ExperienceCandidate) {
            proSkill = ((ExperienceCandidate) can).getProSkill();
            expInYear = ((ExperienceCandidate) can).getExpInYear();
        } else if (can instanceof FresherCandidate) {
            graduationDate = ((FresherCandidate) can).getGraduationDate();
            graduationRank = ((FresherCandidate) can).getGraduationRank();
            education = ((FresherCandidate) can).getEducation();
        } else if (can instanceof InternCandidate) {
            major = ((InternCandidate) can).getMajor();
            semester = ((InternCandidate) can).getSemester();
            universityName = ((InternCandidate) can).getUniversityName();
        }
        sql = "insert into candidate(firstname,lastname,birthday,address,phone,email,candidate_type,expinyear,proskill," + "graduationDate,graduationRank,education,major," + "semester,universityName) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, can.getFirstName());
            pstmt.setString(2, can.getLastName());
            pstmt.setInt(3, can.getBrithDay());
            pstmt.setString(4, can.getAddress());
            pstmt.setString(5, can.getPhone());
            pstmt.setString(6, can.getEmail());
            pstmt.setInt(7, can.getCandidate_type());
            pstmt.setInt(8, expInYear);
            pstmt.setString(9, proSkill);
            pstmt.setString(10, graduationDate);
            pstmt.setString(11, graduationRank);
            pstmt.setString(12, education);
            pstmt.setString(13, major);
            pstmt.setString(14, semester);
            pstmt.setString(15, universityName);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }
        con.setAutoCommit(true);
    }

    public void insertRecruitmentIntoDatabase(Recruitment re) throws SQLException {
        String sql = "insert into recruitment(recruimentCode,position,recruimentPackage,number) values(?,?,?,?)";
        try {
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, re.getRecruimentCode());
            pstmt.setString(2, re.getPosition());
            pstmt.setString(3, re.getRecruimentPackage());
            pstmt.setInt(4, 0);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }
        con.setAutoCommit(true);
    }
    public void updateNumberRecruitmentPackage(){
        
   }

    public Candidate findCandidateById(int id) {
        Candidate can = null;
        try {
            callstmt = con.prepareCall("{call sp_findCandidateById(?)}");
            callstmt.setInt(1, id);
            rs = callstmt.executeQuery();
            while (rs.next()) {
                int type = rs.getInt("candidate_type");
                if (type == 0) {
                    can = new ExperienceCandidate();
                    setInformationForCandidate(can);
                    ((ExperienceCandidate) can).setExpInYear(rs.getInt("expinyear"));
                    ((ExperienceCandidate) can).setProSkill(rs.getString("proskill"));
                } else if (type == 1) {
                    can = new FresherCandidate();
                    setInformationForCandidate(can);
                    ((FresherCandidate) can).setGraduationDate(rs.getString("graduationdate"));
                    ((FresherCandidate) can).setGraduationRank(rs.getString("graduationrank"));
                    ((FresherCandidate) can).setEducation(rs.getString("education"));
                } else {
                    can = new InternCandidate();
                    setInformationForCandidate(can);
                    ((InternCandidate) can).setMajor(rs.getString("major"));
                    ((InternCandidate) can).setSemester(rs.getString("semester"));
                    ((InternCandidate) can).setUniversityName(rs.getString("universityname"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return can;
    }

    public Recruitment findRecruitmentByCode(String code) {
        Recruitment re = new Recruitment();
        try {
            callstmt = con.prepareCall("{call sp_findRecruitmentByCode(?)}");
            callstmt.setString(1, code);
            rs = callstmt.executeQuery();
            while (rs.next()) {
                re.setRecruimentCode(rs.getString("recruimentCode"));
                re.setPosition(rs.getString("position"));
                re.setRecruimentPackage(rs.getString("recruimentPackage"));
                re.setNumber(rs.getInt("number"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return re;
    }

    public void setInformationForCandidate(Candidate can) {
        try {
            can.setFirstName(rs.getString("firstname"));
            can.setLastName(rs.getString("lastname"));
            can.setBrithDay(rs.getInt("birthday"));
            can.setPhone(rs.getString("phone"));
            can.setAddress(rs.getString("address"));
            can.setEmail(rs.getString("email"));
            can.setCandidate_type(rs.getInt("candidate_type"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
