package connectdb;

public class Member {
    private String firstName;
    private int salary;
    
    
    

    public Member() {
        this(null, 0);
    }

    public Member(String firstName, int salary) {
        this.firstName = firstName;
        this.salary = salary;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FIRST_NAME : " + firstName + " | " + "SALARY : " + salary;
    }
    
    // @Override
    // public boolean equals(Object obj) {
    //     // TODO Auto-generated method stub
    //     return super.equals(obj);
    // }
    // @Override
    // public int hashCode() {
    //     // TODO Auto-generated method stub
    //     return super.hashCode();
    // }
    
}
