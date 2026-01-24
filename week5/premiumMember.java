package gymSys;

public class premiumMember extends member {

    private boolean personalTrainer;



    public premiumMember(String name, int age, boolean isFemale, String phoneNumber, boolean inGroup,
                         boolean personalTrainer) {
        super(name, age, isFemale, phoneNumber, inGroup);
        this.personalTrainer = personalTrainer;

    }


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

        if (personalTrainer) return 25000.0;
        return 18000.0;
    }

    public boolean hasPersonalTrainer() { return personalTrainer; }

    @Override
    public String toString() {
        return super.toString() + " (personalTrainer=" + personalTrainer + " monthly fee= " + monthlyFee() + ")";
    }
}
