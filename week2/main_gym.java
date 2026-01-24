import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

public class main_gym {
    private static ArrayList<member> members = new ArrayList<>();
    private static ArrayList<trainer> trainers = new ArrayList<>();
    private static ArrayList<branch> branches = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("===================Gym Management System===================" + '\n' + "---------------Developed by Nauruzov Aliyar---------------" + '\n' +" ");

        member person1 = new member("Akyl111", 17, false, "+777799999", false);
        trainer trainer1 = new trainer("john cena", 150000, "+77777888", 45, 11);
        branch building1 = new branch("baker street", true, 4, "Islambek jr",true);

        members.add(person1);
        trainers.add(trainer1);
        branches.add(building1);

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

        boolean running = true;
        while (running) {
            displayMenu(); // Show menu options
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // IMPORTANT: consume leftover newline
            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                   viewAllMembers();
                    break;
                case 3:
                    addTrainer();
                    break;
                case 4:
                    viewAllTrainers();
                    break;
                case 5:
                    addBranch();
                    break;
                case 6:
                    viewAllBranches();
                    break;
                case 0:
                    System.out.println("\nGoodbye! ");
                    running = false; // Exit loop
                    break;
                default:
                    System.out.println("\n Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // Wait for user
            }
        }
        scanner.close();
        System.out.println('\n' + "===================the end of execution===================");




    }



    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("===================Gym Management System===================" + '\n' + "---------------Developed by Nauruzov Aliyar---------------" + '\n' +" ");
        System.out.println("========================================");
        System.out.println("1. Add Member");
        System.out.println("2. View All members");
        System.out.println("3. Add trainer");
        System.out.println("4. View All trainers");
        System.out.println("5. Add building");
        System.out.println("6. View All buildings");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addMember() {
        System.out.println("\n--- ADD MEMBER ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone_number = scanner.nextLine();
        System.out.print("Is female? (true/false): ");
        boolean is_female = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Is in group? (true/false): ");
        boolean is_in_group = scanner.nextBoolean();
        scanner.nextLine();

        member person_new = new member(name, age, is_female, phone_number, is_in_group);

        members.add(person_new);
        System.out.println("\n member added successfully!");
    }

    private static void addTrainer() {
        System.out.println("\n--- ADD TRAINER ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone_number = scanner.nextLine();
        System.out.print("Enter salary: ");
        int salary = scanner.nextInt();
        System.out.print("Enter experience: ");
        int exp = scanner.nextInt();

        trainer person_new = new trainer(name, salary,  phone_number,age, exp);

        trainers.add(person_new);
        System.out.println("\n trainer added successfully!");
    }
    private static void addBranch() {
        System.out.println("\n--- ADD BRANCH ---");

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Is main building? (true/false): ");
        boolean is_main = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter floors: ");
        int floor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter manager name: ");
        String manager_name = scanner.nextLine();

        System.out.print("Is vip? (true/false): ");
        boolean is_vip = scanner.nextBoolean();
        scanner.nextLine();

        branch building_new = new branch(location, is_main,floor, manager_name, is_vip);

        branches.add(building_new);
        System.out.println("\n building added successfully!");
    }

    private static void viewAllMembers() {
        System.out.println("\n========================================");
        System.out.println(" ALL MEMBERS");
        System.out.println("========================================");

        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("Total members: " + members.size());
        System.out.println();

        for (int i = 0; i < members.size(); i++) {
            member member_i = members.get(i);
            System.out.println((i + 1) + ". " + member_i.getName() +
                    " - " + member_i.getAge() + " y.o.");
            System.out.println(" phone number: " + member_i.getPhone_number());
            System.out.println("is female : " +
                    (member_i.isIs_female() ? " Yes" : " No"));
            System.out.println("is in group : " +
                    (member_i.isIn_group() ? " Yes" : " No"));
            if (member_i.apply_discount()) {
                System.out.println("discount is available!");
            }
            System.out.println();
        }
    }
    private static void viewAllTrainers() {
        System.out.println("\n========================================");
        System.out.println(" ALL TRAINERS");
        System.out.println("========================================");

        if (trainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }
        System.out.println("Total trainers: " + trainers.size());
        System.out.println();

        for (int i = 0; i < trainers.size(); i++) {
            trainer trainer_i = trainers.get(i);
            System.out.println((i + 1) + ". " + trainer_i.getName() +
                    " - " + trainer_i.getAge() + " y.o.");
            System.out.println(" phone number: " + trainer_i.getPhone_number());
            System.out.println(" basic salary: " + trainer_i.getSalary());
            System.out.println(" full salary: " + trainer.salary_with_groups(member.getCount()));
            System.out.println(" trainer experience: " + trainer_i.getExp());
            System.out.println(" trainer level: " + trainer_i.quality());
            System.out.println();
        }
    }
    private static void viewAllBranches() {
        System.out.println("\n========================================");
        System.out.println(" ALL BUILDINGS");
        System.out.println("========================================");

        if (branches.isEmpty()) {
            System.out.println("No buildings found.");
            return;
        }
        System.out.println("Total buildings: " + branches.size());
        System.out.println();

        for (int i = 0; i < branches.size(); i++) {
            branch branch_i = branches.get(i);
            System.out.println((i + 1) + ". " + branch_i.getLocation());
            System.out.println(" floors: " + branch_i.getFloors());
            System.out.println(" manager's name: " + branch_i.getManager_name());
            System.out.println("is main building : " +
                    (branch_i.isMain_building() ? " Yes" : " No"));
            if (branch_i.space(member.getCount())) {
                System.out.println("this building is overcrowded");
            }
            System.out.println();
        }
    }
}