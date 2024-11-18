package eu.binarystars.cleancode.formatting;

public class Vertical {

    void two(User user, Company company) {
        String stuff;
        if (user == null) {
            if (company == null) {
                stuff = "default";
            }
            stuff = company.name + " employee";
        }
        if (user.salary < 100_000) {
            stuff = "staff";
        }
        stuff =  "manager";
    }
    
    static class User {
        public int salary = 666;
    }
    static class Company {
        public String  name;
    }
}
