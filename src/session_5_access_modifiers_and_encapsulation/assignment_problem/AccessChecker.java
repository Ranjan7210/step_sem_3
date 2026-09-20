package session_5_access_modifiers_and_encapsulation.assignment_problem;

public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        String modifier = fieldModifier.trim().toLowerCase();
        String context = accessorContext.trim().toUpperCase();

        if ("public".equals(modifier)) {
            return "ALLOWED";
        }

        switch (context) {
            case "SAME_CLASS":
                return "ALLOWED";

            case "SAME_PACKAGE":
                if ("default".equals(modifier) || "protected".equals(modifier)) {
                    return "ALLOWED";
                }
                break;

            case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                if ("protected".equals(modifier)) {
                    return "ALLOWED";
                }
                break;

            case "DIFFERENT_PACKAGE":
            case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                break;

            default:
                break;
        }

        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        int privAllowed = 0, privDenied = 0;
        int defAllowed = 0, defDenied = 0;
        int protAllowed = 0, protDenied = 0;
        int pubAllowed = 0, pubDenied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String modifier = attempt[0] != null ? attempt[0].trim().toLowerCase() : "";
                    String context = attempt[1];
                    boolean isAllowed = "ALLOWED".equals(classifyAccess(modifier, context));

                    switch (modifier) {
                        case "private":
                            if (isAllowed) privAllowed++; else privDenied++;
                            break;
                        case "default":
                            if (isAllowed) defAllowed++; else defDenied++;
                            break;
                        case "protected":
                            if (isAllowed) protAllowed++; else protDenied++;
                            break;
                        case "public":
                            if (isAllowed) pubAllowed++; else pubDenied++;
                            break;
                    }
                }
            }
        }

        return "private: " + privAllowed + " allowed / " + privDenied + " denied | " +
               "default: " + defAllowed + " allowed / " + defDenied + " denied | " +
               "protected: " + protAllowed + " allowed / " + protDenied + " denied | " +
               "public: " + pubAllowed + " allowed / " + pubDenied + " denied";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts != null) {
            for (int i = 0; i < attempts.length; i++) {
                String[] attempt = attempts[i];
                if (attempt != null && attempt.length >= 2) {
                    String modifier = attempt[0];
                    String context = attempt[1];
                    if ("DENIED".equals(classifyAccess(modifier, context))) {
                        return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
                    }
                }
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1: summarizeByModifier Test ---");
        String[][] batch1 = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println("summarizeByModifier: " + summarizeByModifier(batch1));

        System.out.println("\n--- Problem 2: firstDeniedAttempt Test ---");
        String[][] batch2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println("firstDeniedAttempt: " + firstDeniedAttempt(batch2));

        String[][] batch3 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println("firstDeniedAttempt (all allowed): " + firstDeniedAttempt(batch3));
    }
}
