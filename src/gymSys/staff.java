package gymSys;

public abstract class staff {
    protected String name;
    protected static float salary;
    protected String phone_number;
    private int age;

    public staff(String name,float salary,String phone_number,int age){
        this.name = name;
        setSalary(salary);
        this.phone_number = phone_number;
        this.age = age;

    }


    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("name cannot be empty!");
        }

    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if (salary>0){
            this.salary = salary;
            System.out.println(salary);
        }
        else {
            throw new IllegalArgumentException("salary cannot be negative or zero!");

        }
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("salary cannot be negative!");
        }
    }
    //additional method 1 to apply discount
    public static float salary_with_groups(int member_count){
        float full_salary;
        if(member_count>=0){
            full_salary = salary + member_count * 5000;

        }
        else{
            throw new IllegalArgumentException("salary cannot be negative!");
        }
        return full_salary;
    }


    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age='" + age + '\'' +
                ", phone_number=" + phone_number + '\'' +
                '}';
    }
}
