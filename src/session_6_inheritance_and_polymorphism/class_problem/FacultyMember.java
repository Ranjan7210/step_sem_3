package session_6_inheritance_and_polymorphism.class_problem;

public class FacultyMember extends LibraryMember {
    protected String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + booksBorrowed;
    }
}
