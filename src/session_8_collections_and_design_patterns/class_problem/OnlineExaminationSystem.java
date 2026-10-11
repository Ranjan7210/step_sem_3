package session_8.class_problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Question {
    protected int id;
    protected String text;
    protected int maxPoints;

    public Question(int id, String text, int maxPoints) {
        this.id = id;
        this.text = text;
        this.maxPoints = maxPoints;
    }

    public int getId() {
        return id;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public abstract boolean isCorrect(String answer);
}

class MultipleChoiceQuestion extends Question {
    private String correctOption;

    public MultipleChoiceQuestion(int id, String text, int maxPoints, String correctOption) {
        super(id, text, maxPoints);
        this.correctOption = correctOption;
    }

    @Override
    public boolean isCorrect(String answer) {
        return correctOption.equalsIgnoreCase(answer.trim());
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(int id, String text, int maxPoints, boolean correctAnswer) {
        super(id, text, maxPoints);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrect(String answer) {
        return Boolean.parseBoolean(answer.trim()) == correctAnswer;
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Examination {
    private String name;
    private List<Question> questions;

    public Examination(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

enum AttemptState {
    IN_PROGRESS,
    SUBMITTED
}

class Attempt {
    private Student student;
    private Examination examination;
    private Map<Integer, String> recordedAnswers;
    private AttemptState state;

    public Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
        this.recordedAnswers = new HashMap<>();
        this.state = AttemptState.IN_PROGRESS;
        System.out.println(examination.getName() + " started by " + student.getName() + ".");
    }

    public boolean recordAnswer(int questionId, String answer) {
        if (state == AttemptState.SUBMITTED) {
            System.out.println("Cannot change answers for a submitted examination.");
            return false;
        }
        recordedAnswers.put(questionId, answer);
        System.out.println("Answer recorded for Question " + questionId + ".");
        return true;
    }

    public void submit() {
        if (state == AttemptState.SUBMITTED) {
            return;
        }
        state = AttemptState.SUBMITTED;
        System.out.println(examination.getName() + " submitted by " + student.getName() + ".");

        int totalScore = 0;
        int maxTotal = 0;
        StringBuilder resultBuilder = new StringBuilder("Result: ");

        List<Question> questions = examination.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            maxTotal += q.getMaxPoints();
            String ans = recordedAnswers.get(q.getId());
            boolean correct = ans != null && q.isCorrect(ans);
            int awarded = correct ? q.getMaxPoints() : 0;
            totalScore += awarded;

            resultBuilder.append("Question ").append(q.getId()).append(": ")
                    .append(correct ? "Correct" : "Incorrect")
                    .append(" (").append(awarded).append(" points)");

            if (i < questions.size() - 1) {
                resultBuilder.append(", ");
            }
        }
        resultBuilder.append(". Total score: ").append(totalScore).append("/").append(maxTotal).append(".");
        System.out.println(resultBuilder.toString());
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Examination examA = new Examination("Exam A");
        examA.addQuestion(new MultipleChoiceQuestion(1, "Select option", 5, "C"));
        examA.addQuestion(new TrueFalseQuestion(2, "True or False", 5, false));

        Student s1 = new Student("Student 1");
        Attempt attempt = new Attempt(s1, examA);

        attempt.recordAnswer(1, "C");
        attempt.recordAnswer(2, "True");
        attempt.submit();
        attempt.recordAnswer(1, "A");
    }
}
