package session_8.assignment_problem;

import java.util.HashMap;
import java.util.Map;

abstract class Assignment {
    protected String title;
    protected int maxMarks;
    protected String dueDate;
    protected int dueDay;

    public Assignment(String title, int maxMarks, String dueDate, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
        this.dueDay = dueDay;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public int getDueDay() {
        return dueDay;
    }

    public abstract int calculateLatePenaltyPercent(int daysLate);
}

class CodingAssignment extends Assignment {
    public CodingAssignment(String title, int maxMarks, String dueDate, int dueDay) {
        super(title, maxMarks, dueDate, dueDay);
    }

    @Override
    public int calculateLatePenaltyPercent(int daysLate) {
        return daysLate > 0 ? daysLate * 10 : 0;
    }
}

class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, int maxMarks, String dueDate, int dueDay) {
        super(title, maxMarks, dueDate, dueDay);
    }

    @Override
    public int calculateLatePenaltyPercent(int daysLate) {
        return daysLate > 0 ? daysLate * 20 : 0;
    }
}

class SubmissionStudent {
    private String name;

    public SubmissionStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum SubmissionStatus {
    SUBMITTED("Submitted"),
    GRADED("Graded");

    private final String displayName;

    SubmissionStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

class Submission {
    private SubmissionStudent student;
    private Assignment assignment;
    private String submissionDate;
    private int daysLate;
    private SubmissionStatus status;
    private int finalMarks;

    public Submission(SubmissionStudent student, Assignment assignment, String submissionDate, int submissionDay) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.daysLate = Math.max(0, submissionDay - assignment.getDueDay());
        this.status = SubmissionStatus.SUBMITTED;

        String lateText = daysLate == 0 ? "(on time)" : "(" + daysLate + " days late)";
        System.out.println(student.getName() + "'s submission for '" + assignment.getTitle() + "' received " + lateText + ". Status: " + status.getDisplayName() + ".");
    }

    public SubmissionStudent getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public SubmissionStatus getStatus() {
        return status;
    }

    public void grade(int rawMarks) {
        if (status == SubmissionStatus.GRADED) {
            return;
        }
        int penaltyPercent = assignment.calculateLatePenaltyPercent(daysLate);
        this.finalMarks = rawMarks - (rawMarks * penaltyPercent / 100);
        this.status = SubmissionStatus.GRADED;

        if (penaltyPercent > 0) {
            System.out.println(student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() +
                    " after " + penaltyPercent + "% late penalty. Status: " + status.getDisplayName() + ".");
        } else {
            System.out.println(student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() +
                    ". Status: " + status.getDisplayName() + ".");
        }
    }
}

public class AssignmentSubmissionPortal {
    private static Map<String, Submission> submissions = new HashMap<>();

    public static Submission submit(SubmissionStudent student, Assignment assignment, String date, int day) {
        String key = student.getName() + "_" + assignment.getTitle();
        Submission existing = submissions.get(key);
        if (existing != null && existing.getStatus() == SubmissionStatus.GRADED) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
            return null;
        }
        Submission sub = new Submission(student, assignment, date, day);
        submissions.put(key, sub);
        return sub;
    }

    public static void main(String[] args) {
        Assignment coding = new CodingAssignment("Linked List Lab", 50, "Mar 10", 10);
        Assignment written = new WrittenAssignment("Design Essay", 50, "Mar 12", 12);

        SubmissionStudent asha = new SubmissionStudent("Asha");
        SubmissionStudent ravi = new SubmissionStudent("Ravi");

        Submission s1 = submit(asha, coding, "Mar 10", 10);
        Submission s2 = submit(ravi, written, "Mar 14", 14);

        if (s1 != null) s1.grade(45);
        if (s2 != null) s2.grade(40);

        submit(asha, coding, "Mar 15", 15);
    }
}
