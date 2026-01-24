package gymSys;

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
            throw new IllegalArgumentException("Name can not be empty!");
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
            throw new IllegalArgumentException("Age can not be negative!");

        }

    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


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
                ", in_group=" + in_group +" monthly fee= " + monthlyFee() +
                '}';
    }

}

