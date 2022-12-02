package caseStudy.services.InputAndValidData;

import java.util.regex.Pattern;

public interface PersonConst {
    Pattern validPhoneNumber = Pattern.compile("^(84|0[3|5|7|8|9])+([0-9]{8})\\b$");
    Pattern validGender = Pattern.compile("(?:m|M|male|Male|f|F|female|Female|FEMALE|MALE|Not prefer to say)$");
    Pattern validEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Pattern validRank = Pattern.compile("(?:Gold|Platinum|Diamond|Member|Silver)$");
    Pattern validLevelEducation = Pattern.compile("(?:College|University)$");
    Pattern validPosition = Pattern.compile("(?:Receptionist|Waiter|Specialist|Supervisor|Manager|Director)$");

}
