public class member {
    protected String name;
    protected int age;
    protected boolean is_female;
    protected String phone_number;
    protected boolean in_group;
    private static int count = 0;
    public member(String name,int age,boolean is_female,String phone_number, boolean in_group){
        setAge(age);
        this.name = name;
        this.is_female = is_female;
        this.phone_number = phone_number;
        this.in_group = in_group;
        count++;
    }

    public member() {
        this.name = "Unknown Name";
        this.is_female = false;
        this.phone_number = "+00000";
        this.in_group = false;
        this.age = 0;
    }

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

    public String getName() {
        return name;
    }

    public boolean isIn_group() {
        return in_group;
    }

    public void setIn_group(boolean in_group) {
        this.in_group = in_group;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }

    }

    public boolean isIs_female() {
        return is_female;
    }

    public void setIs_female(boolean is_female) {
        this.is_female = is_female;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Warning: Age cannot be negative! Setting to 1.");
            this.age = 1;
        }

    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    //additional method 1 to apply discount


    //additional method 2 to count the number of members
    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", is_female=" + is_female +
                ", age='" + age + '\'' +
                ", phone_number=" + phone_number + '\'' +
                ", in_group=" + in_group +
                '}';
    }

}

class studentMember extends member {
    // child
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




class premiumMember extends member {

    private boolean personalTrainer;



    public premiumMember(String name, int age, boolean isFemale, String phoneNumber, boolean inGroup,
                         boolean personalTrainer) {
        super(name, age, isFemale, phoneNumber, inGroup);
        this.personalTrainer = personalTrainer;

    }


    @Override
    public void work() {
        if (personalTrainer) {
            System.out.println(name + " is training with a personal trainer.");
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

        if (personalTrainer) return 25000.0;
        return 18000.0;
    }

    public boolean hasPersonalTrainer() { return personalTrainer; }

    @Override
    public String toString() {
        return super.toString() + " (personalTrainer=" + personalTrainer + ", guestPasses=" + ")";
    }
}