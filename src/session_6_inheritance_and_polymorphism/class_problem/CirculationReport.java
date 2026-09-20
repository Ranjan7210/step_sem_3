package session_6_inheritance_and_polymorphism.class_problem;

public class CirculationReport {

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof StudentMember) {
            return "Direct descendant (2 generations deep)";
        }
        return "Base generation";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        if (members != null) {
            for (LibraryMember m : members) {
                if (m != null) {
                    total += m.getBooksBorrowed();
                }
            }
        }
        return total;
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (LibraryMember m : members) {
                if (m != null) {
                    sb.append(m.displayInfo());
                    if (m instanceof StudentMember) {
                        StudentMember sm = (StudentMember) m;
                        sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
                    }
                    sb.append(" | ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1 Test ---");
        StudentMember s1 = new StudentMember("STU10", 3, "CSE");
        s1.borrowBook();
        s1.borrowBook();
        System.out.println("s1.getBooksBorrowed(): " + s1.getBooksBorrowed());
        System.out.println("enrollBatch: " + LibraryMember.enrollBatch(new String[]{"STU1", "LB1", "STU2", "  ", "STU3"}, 3));

        System.out.println("\n--- Problem 2 Test ---");
        HonorsStudentMember honors = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember faculty = new FacultyMember("STU4", 5, "Physics");
        System.out.println("classifyGeneration(honors): " + classifyGeneration(honors));
        System.out.println("classifyGeneration(faculty): " + classifyGeneration(faculty));
        System.out.println("getTotalBooksBorrowed: " + getTotalBooksBorrowed(new LibraryMember[]{s1, honors, faculty}));

        System.out.println("\n--- Problem 3 Test ---");
        StudentMember s2 = new StudentMember("STU5", 3, "CSE");
        s2.chargeFine(100);
        System.out.println("s2.getTotalFine(): " + s2.getTotalFine());

        System.out.println("\n--- Problem 4 Test ---");
        LibraryMember lb5 = new LibraryMember("LIB5", 3);
        StudentMember stu6 = new StudentMember("STU6", 3, "ECE");
        System.out.println("batchPrint: " + batchPrint(new LibraryMember[]{lb5, stu6}));

        System.out.println("\n--- Problem 5 Test ---");
        LibraryMember m1 = new LibraryMember(3);
        System.out.println("m1.memberNumber: " + m1.memberNumber);
        System.out.println("isValidRenewalCode(\"R12A\"): " + LibraryMember.isValidRenewalCode("R12A"));
        System.out.println("processNightlyAudit: " + LibraryMember.processNightlyAudit(new LibraryMember[]{new FacultyMember(5, "Physics"), null, new LibraryMember(3)}));
    }
}
