package gymSys;

public class trainer extends staff{
    private int exp;

    public trainer(String name, float salary, String phone_number, int age, int exp) {
        super(name, salary, phone_number, age);
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        if (exp >= 0) {
            this.exp = exp;
        } else {
            throw new IllegalArgumentException("Experience cannot be negative!");
        }

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
}

