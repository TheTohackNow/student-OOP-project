public class main_gym {
    public static void main(String[] args){
        System.out.println("===================Gym Management System===================" + '\n' + "---------------Developed by Nauruzov Aliyar---------------" + '\n' +" ");

        member person1 = new member("Akyl111", 17, false, "+777799999", false);
        trainer trainer1 = new trainer("john cena", 150000, "+77777888", 45, 11);
        branch building1 = new branch("baker street", true, 4, "Islambek jr",true);

        System.out.println("--------------members---------------");
        System.out.println(person1);
        System.out.println("apply discount: " + person1.apply_discount());

        System.out.println("--------------trainers---------------");
        System.out.println(trainer1);
        System.out.println("skill level:" + trainer1.quality());
        System.out.println("current salary: " + trainer.salary_with_groups(member.getCount()));
        System.out.println();

        System.out.println("--------------branch---------------");
        System.out.println(building1);
        System.out.println("total_price: " + building1.pricelist(person1.apply_discount()));
        System.out.println("is_overcrowded:" + building1.space(member.getCount()));

        System.out.println("--------------test getters---------------");
        System.out.println("person1 name: " + person1.getName());
        System.out.println("trainer 1 name: " + trainer1.getName());
        System.out.println("building 1 location:" + building1.getLocation());

        System.out.println("--------------test setters---------------");
        System.out.println("updating... ");
        person1.setName("Naruto");
        trainer1.setAge(77);
        building1.setVip(false);

        System.out.println("person1 name: " + person1.getName());
        System.out.println("trainer 1 age: " + trainer1.getAge());
        System.out.println("building 1 is_vip:" + building1.isVip());
        System.out.println('\n' + "===================the end of execution===================");
    }
}