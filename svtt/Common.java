package fpt.svtt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PHONE_PATTERN = "\\d{7,}";
    public static final String RECRUITMENT_CODE = "\\d{5}";
    public static final int LAST_BIRTHDAY = 1900; // public static final String EXPERIENCE_IN_YEAR = "[0-100]"; 
    static DateFormat dateFormat = new SimpleDateFormat("yyyy");
    static Date date = new Date();
    public static final int CURRENT_YEAR = Integer.parseInt(dateFormat.format(date));
    public static final int MIN_EXPERIENCE_IN_YEAR = 0;
    public static final int MAX_EXPERIENCE_IN_YEAR = 100;
}
