package gymSys;

public class studentMember extends member {
    private String university;
    private boolean hasStudentCard;


    public studentMember(String name, int age, boolean isFemale, String phoneNumber, boolean inGroup,
                         String university, boolean hasStudentCard) {
        super(name, age, isFemale, phoneNumber, inGroup);
        this.university = university;
        this.hasStudentCard = hasStudentCard;
    }


    @Override
    public void work() {
        System.out.println(name + " is doing a student-friendly workout plan.");
    }

    @Override
    public String getRole() {
        return "Student Member";
    }

    @Override
    public double monthlyFee() {
        if (hasStudentCard) return 7000.0;
        return 9000.0;
    }

    public void applyStudentDiscount() {
        if (hasStudentCard) System.out.println("Discount applied for " + name + ".");
        else throw new IllegalArgumentException("Error. Discount is not applied!");;
    }
    public void requestStudyWorkout() {
        System.out.println(name + " requested a short workout for study breaks.");
    }
    public String getUniversity() { return university; }

    public boolean hasStudentCard() { return hasStudentCard; }
    @Override
    public String toString() {
        return super.toString() + " (university='" + university + "', studentCard=" + hasStudentCard + " monthly fee= " + monthlyFee() + ")";
    }
}





