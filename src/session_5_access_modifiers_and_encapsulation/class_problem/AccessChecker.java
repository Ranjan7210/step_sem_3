package session_5_access_modifiers_and_encapsulation.class_problem;

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

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String result = classifyAccess(attempt[0], attempt[1]);
                    if ("ALLOWED".equals(result)) {
                        allowed++;
                    } else {
                        denied++;
                    }
                }
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1 & 2: Access Checker Examples ---");
        System.out.println("classifyAccess(\"private\", \"SAME_CLASS\"): " + classifyAccess("private", "SAME_CLASS"));
        System.out.println("classifyAccess(\"protected\", \"DIFFERENT_PACKAGE\"): " + classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE\"): " + classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE\"): " + classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));

        String[][] batch = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println("summarizeBatch output: " + summarizeBatch(batch));
    }
}
