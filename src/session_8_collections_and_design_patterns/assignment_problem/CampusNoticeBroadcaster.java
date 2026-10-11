package session_8.assignment_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface NotificationChannel {
    String getName();

    void send(NoticeStudent student, Notice notice);
}

class EmailChannel implements NotificationChannel {
    @Override
    public String getName() {
        return "Email";
    }

    @Override
    public void send(NoticeStudent student, Notice notice) {
        System.out.println("[Email -> " + student.getName() + "] " + notice.getTitle() + ".");
    }
}

class SmsChannel implements NotificationChannel {
    @Override
    public String getName() {
        return "SMS";
    }

    @Override
    public void send(NoticeStudent student, Notice notice) {
        System.out.println("[SMS -> " + student.getName() + "] " + notice.getTitle() + ".");
    }
}

class AppChannel implements NotificationChannel {
    @Override
    public String getName() {
        return "App";
    }

    @Override
    public void send(NoticeStudent student, Notice notice) {
        System.out.println("[App -> " + student.getName() + "] " + notice.getTitle() + ".");
    }
}

class NoticeStudent {
    private String name;
    private String department;
    private List<NotificationChannel> preferredChannels;

    public NoticeStudent(String name, String department, NotificationChannel... channels) {
        this.name = name;
        this.department = department;
        this.preferredChannels = new ArrayList<>(Arrays.asList(channels));
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<NotificationChannel> getPreferredChannels() {
        return preferredChannels;
    }
}

class Notice {
    private String title;
    private List<String> targetDepartments;

    public Notice(String title, List<String> targetDepartments) {
        this.title = title;
        this.targetDepartments = targetDepartments;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTargetDepartments() {
        return targetDepartments;
    }
}

class NoticeBoard {
    private List<NoticeStudent> students;

    public NoticeBoard() {
        this.students = new ArrayList<>();
    }

    public void registerStudent(NoticeStudent student) {
        students.add(student);
    }

    public boolean postNotice(String title, List<String> targetDepartments) {
        if (title == null || title.trim().isEmpty() || targetDepartments == null || targetDepartments.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return false;
        }

        StringBuilder deptsBuilder = new StringBuilder();
        for (int i = 0; i < targetDepartments.size(); i++) {
            deptsBuilder.append(targetDepartments.get(i));
            if (i < targetDepartments.size() - 1) {
                deptsBuilder.append(", ");
            }
        }
        System.out.println("Notice '" + title + "' posted to " + deptsBuilder.toString() + ".");

        Notice notice = new Notice(title, targetDepartments);
        for (NoticeStudent student : students) {
            if (targetDepartments.contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getPreferredChannels()) {
                    channel.send(student, notice);
                }
            }
        }
        return true;
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        NoticeStudent asha = new NoticeStudent("Asha", "CSE", new EmailChannel(), new AppChannel());
        NoticeStudent ravi = new NoticeStudent("Ravi", "ECE", new SmsChannel());

        board.registerStudent(asha);
        board.registerStudent(ravi);

        board.postNotice("Lab Closed Tomorrow", Arrays.asList("CSE"));
        board.postNotice("Fee Deadline Extended", Arrays.asList("CSE", "ECE"));
        board.postNotice("Sports Day", new ArrayList<>());
    }
}
