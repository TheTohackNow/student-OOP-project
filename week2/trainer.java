public class trainer {
    private String name;
    private static float salary;
    private String phone_number;
    private int age;
    private int exp;

    public trainer(String name,float salary,String phone_number,int age, int exp){
        this.name = name;
        setSalary(salary);
        this.phone_number = phone_number;
        this.age = age;
        this.exp = exp;
    }
    public trainer() {
        this.name = "Unknown Name";
        this.salary = 1;
        this.phone_number = "+00000";
        this.exp = 0;
    }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            if (exp >= 0) {
                this.exp = exp;
            } else {
                System.out.println("Warning: experience cannot be negative! Setting to 0.");
                this.exp = 0;
            }

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name != null && !name.trim().isEmpty()) {
                this.name = name;
            } else {
                System.out.println("Warning: Name cannot be empty!");
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
                System.out.println("Warning: salary cannot be negative or 0! Setting to 1.");
                this.salary = 1;

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
                System.out.println("Warning: Age cannot be negative! Setting to 1.");
                this.age = 1;
            }
        }
        //additional method 1 to apply discount
        public static float salary_with_groups(int member_count){
            float full_salary;
            if(member_count>=0){
                full_salary = salary + member_count * 5000;

            }
            else{
                System.out.println("Warning: full salary cannot be negative! Setting to 0.");
                full_salary = 0;
            }
            return full_salary;
        }
        public String quality(){

            String level = "rookie";
            if (exp<=4 && exp>=0){
                level = "rookie";
            }
            else if (exp>4 && exp<=9){
                level = "good specialist";
            }
            else if (exp>=10){
                level = "master";
            }
            else{
                System.out.println("Warning: experience cannot be negative! Setting to 0.");
                exp= 0;
            }
            return level;
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

