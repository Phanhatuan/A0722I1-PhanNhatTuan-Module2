package ss12.test;

import caseStudy.models.Employee;

public class EmployeeTest {
    private String birthday;

    public EmployeeTest() {

    }

    public EmployeeTest(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        EmployeeTest a = new EmployeeTest();
        //a.setBirthday(22);
    }
}
