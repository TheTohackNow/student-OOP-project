public class member {
    private String name;
    private int age;
    private boolean is_female;
    private String phone_number;
    private boolean in_group;
    private static int count = 0;
    public member(String name,int age,boolean is_female,String phone_number, boolean in_group){
        this.age = age;
        this.name = name;
        this.is_female = is_female;
        this.phone_number = phone_number;
        this.in_group = in_group;
        count++;
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
        this.name = name;
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
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    //additional method 1 to apply discount
    public boolean apply_discount(){
        if (isIs_female() == true && age>=18 && in_group){
            return true;
        }
        else{
            return false;
        }
    }

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
