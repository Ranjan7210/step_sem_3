package session_5_access_modifiers_and_encapsulation.assignment_problem;

public class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {
        this.membershipPin = null;
        this.branchCode = null;
        this.finesOwed = 0.0;
        this.displayName = null;
        this.membershipId = null;
        this.name = null;
        this.premiumMember = false;
        this.securityAnswer = null;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (this.membershipId == null && id != null) {
            this.membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = answer;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 4: LibraryMember JavaBean Test ---");
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println("m.getMembershipId(): " + m.getMembershipId());

        m.setMembershipId("FAKE-0000");
        System.out.println("After second setMembershipId call: " + m.getMembershipId());

        System.out.println("m.isPremiumMember(): " + m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
        System.out.println("Security answer set via write-only setter.");
    }
}
