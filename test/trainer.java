public class trainer {
    private String name;
    private float salary;
    private String phoneNumber;
    private int age;
    private int experienceYears;

    public trainer(String name, float salary, String phoneNumber, int age, int experienceYears) {
        this.name = name;
        setSalary(salary);
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.experienceYears = experienceYears;
    }

    public trainer() {
        this("Unknown", 0, "N/A", 0, 0);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }

    public float getSalary() { return salary; }

    public void setSalary(float salary) {
        if (salary >= 0) this.salary = salary;
        else this.salary = 0;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) this.phoneNumber = phoneNumber;
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) this.age = age;
        else this.age = 0;
    }

    public int getExperienceYears() { return experienceYears; }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) this.experienceYears = experienceYears;
        else this.experienceYears = 0;
    }

    public String level() {
        if (experienceYears >= 10) return "Senior";
        if (experienceYears >= 3) return "Mid";
        return "Junior";
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", phone='" + phoneNumber + '\'' +
                ", age=" + age +
                ", expYears=" + experienceYears +
                ", level='" + level() + '\'' +
                '}';
    }
}
