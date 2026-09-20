package session_5_access_modifiers_and_encapsulation.assignment_problem;

import java.util.Arrays;

public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds != null ? bookIds.clone() : new String[0];
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return bookIds != null ? bookIds.clone() : new String[0];
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (bookIds == null || index < 0 || index >= bookIds.length) {
            return this;
        }
        String[] updated = bookIds.clone();
        updated[index] = newId;
        return new LoanReceipt(this.memberId, updated);
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int nullSkipped = 0;
        int refOnlyCount = 0;
        int regularCount = 0;

        if (receipts != null) {
            for (LoanReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                } else if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    refOnlyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        int processed = refOnlyCount + regularCount;
        return processed + " processed | " + nullSkipped + " null skipped | " + refOnlyCount + " reference-only | " + regularCount + " regular";
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 5: LoanReceipt Test ---");
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println("Defensive copy check (r.getBookIds()[0]): " + r.getBookIds()[0]);

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println("Original r.getBookIds(): " + Arrays.toString(r.getBookIds()));
        System.out.println("Corrected getBookIds(): " + Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] batch = new LoanReceipt[]{
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println("processNightlyCirculation: " + processNightlyCirculation(batch));
    }
}
