public class member {
    // Week 4 requirement: minimum 4 protected fields
    protected String name;
    protected int age;
    protected boolean isFemale;
    protected String phoneNumber;
    protected boolean inGroup;

    private static int count = 0;

    // Parent parameterized constructor (required)
    public member(String name, int age, boolean isFemale, String phoneNumber, boolean inGroup) {
        this.name = name;
        setAge(age);
        this.isFemale = isFemale;
        this.phoneNumber = phoneNumber;
        this.inGroup = inGroup;
        count++;
    }

    // Minimum 3 methods including action/work method
    public void work() {
        System.out.println(name + " is doing a regular workout.");
    }

    public String getRole() {
        return "General Member";
    }

    public double monthlyFee() {
        // simple fee logic
        return 10000.0;
    }

    // Getters / setters (simple)
    public String getName() { return name; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) this.age = age;
        else this.age = 0;
    }

    public boolean isFemale() { return isFemale; }

    public void setFemale(boolean female) { isFemale = female; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) this.phoneNumber = phoneNumber;
    }

    public boolean isInGroup() { return inGroup; }

    public void setInGroup(boolean inGroup) { this.inGroup = inGroup; }

    public static int getCount() { return count; }

    @Override
    public String toString() {
        return getRole() + " {" +
                "name='" + name + "'" +
                ", age=" + age +
                ", female=" + isFemale +
                ", phone='" + phoneNumber + "'" +
                ", inGroup=" + inGroup +
                ", fee=" + monthlyFee() +
                '}';
    }
}

/*
  IMPORTANT: No new files requested.
  Child classes are included in the same file (not public).
*/

// Child class 1
class studentMember extends member {
    // child adds 1-2 fields
    private String university;
    private boolean hasStudentCard;

    // parameterized constructor using super() first line
    public studentMember(String name, int age, boolean isFemale, String phoneNumber, boolean inGroup,
                         String university, boolean hasStudentCard) {
        super(name, age, isFemale, phoneNumber, inGroup);
        this.university = university;
        this.hasStudentCard = hasStudentCard;
    }

    // Override minimum 2 parent methods
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
        // cheaper for students with a student card
        if (hasStudentCard) return 7000.0;
        return 9000.0;
    }

    // 2+ unique methods
    public void applyStudentDiscount() {
        if (hasStudentCard) System.out.println("Discount applied for " + name + ".");
        else System.out.println("No student card. Discount not applied for " + name + ".");
    }

    public void requestStudyWorkout() {
        System.out.println(name + " requested a short workout for study breaks.");
    }

    public String getUniversity() { return university; }

    public boolean hasStudentCard() { return hasStudentCard; }

    @Override
    public String toString() {
        return super.toString() + " (university='" + university + "', studentCard=" + hasStudentCard + ")";
    }
}

// Child class 2
class premiumMember extends member {
    // child adds 1-2 fields
    private boolean personalTrainer;
    private int freeGuestPasses;

    // parameterized constructor using super() first line
    public premiumMember(String name, int age, boolean isFemale, String phoneNumber, boolean inGroup,
                         boolean personalTrainer, int freeGuestPasses) {
        super(name, age, isFemale, phoneNumber, inGroup);
        this.personalTrainer = personalTrainer;
        this.freeGuestPasses = freeGuestPasses;
    }

    // Override minimum 2 parent methods
    @Override
    public void work() {
        if (personalTrainer) {
            System.out.println(name + " is training with a personal gymSys.trainer.");
        } else {
            System.out.println(name + " is doing a premium workout.");
        }
    }

    @Override
    public String getRole() {
        return "Premium Member";
    }

    @Override
    public double monthlyFee() {
        // premium fee changes if personal gymSys.trainer is included
        if (personalTrainer) return 25000.0;
        return 18000.0;
    }

    // 2+ unique methods
    public void accessVipZone() {
        System.out.println(name + " accessed the VIP zone.");
    }

    public void useGuestPass() {
        if (freeGuestPasses > 0) {
            freeGuestPasses--;
            System.out.println(name + " used a guest pass. Left: " + freeGuestPasses);
        } else {
            System.out.println(name + " has no guest passes left.");
        }
    }

    public boolean hasPersonalTrainer() { return personalTrainer; }

    @Override
    public String toString() {
        return super.toString() + " (personalTrainer=" + personalTrainer + ", guestPasses=" + freeGuestPasses + ")";
    }
}