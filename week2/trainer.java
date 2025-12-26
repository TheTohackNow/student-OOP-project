public class trainer {
    private String name;
    private static float salary;
    private String phone_number;
    private int age;
    private int exp;

    public trainer(String name,float salary,String phone_number,int age, int exp){
        this.name = name;
        this.salary = salary;
        this.phone_number = phone_number;
        this.age = age;
        this.exp = exp;
    }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
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
            this.age = age;
        }
        //additional method 1 to apply discount
        public static float salary_with_groups(int member_count){

            float full_salary = salary + member_count * 5000;
            return full_salary;
        }
        public String quality(){
            String level = "rookie";
            if (exp<=4){
                level = "rookie";
            }
            else if (exp>4 && exp<=9){
                level = "good specialist";
            }
            else if (exp>=10){
                level = "master";
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

