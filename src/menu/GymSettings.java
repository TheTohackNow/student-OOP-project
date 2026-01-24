package menu;
import java.util.ArrayList;
import java.util.Scanner;
import gymSys.*;




public class GymSettings implements menu {
    private static ArrayList<member> members = new ArrayList<>();
    private static ArrayList<trainer> trainers = new ArrayList<>();
    private static ArrayList<branch> branches = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("         GYM MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1  - Add GENERAL member");
        System.out.println("2  - Add STUDENT member");
        System.out.println("3  - Add PREMIUM member");
        System.out.println("4  - View all members");
        System.out.println("5  - Make all members work() (polymorphism)");
        System.out.println("6  - View students only");
        System.out.println("7  - View premium only");
        System.out.println("9  - Add trainer");
        System.out.println("10 - View all trainers");
        System.out.println("11 - Add branch");
        System.out.println("12 - View all branches");
        System.out.println("0  - Exit");
        System.out.print("Enter choice: ");
    }

    @Override
    public void run(){
        boolean running = true;

        while (running) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addGeneralMember();
                    break;
                case 2:
                    addStudentMember();
                    break;
                case 3:
                    addPremiumMember();
                    break;
                case 4:
                    viewAllMembers();
                    break;
                case 5:
                    makeAllMembersWork();
                    break;
                case 6:
                    viewStudentsOnly();
                    break;
                case 7:
                    viewPremiumOnly();
                    break;
                case 8:
                    polymorphismDemo();
                    break;
                case 9:
                    addTrainer();
                    break;
                case 10:
                    viewAllTrainers();
                    break;
                case 11:
                    addBranch();
                    break;
                case 12:
                    viewAllBranches();
                    break;
                case 0:
                    System.out.println("\nGoodbye! ");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }



    private static void addGeneralMember() {
        System.out.println("\n--- ADD MEMBER ---");

        try {
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

            System.out.println("\nMember added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void addStudentMember() {
        System.out.println("\n--- ADD STUDENT MEMBER ---");
        try {
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

            System.out.print("Enter university: ");
            String university = scanner.nextLine();
            System.out.print("Has card? (true/false): ");
            boolean has_card = scanner.nextBoolean();
            scanner.nextLine();

            member m = new studentMember(name, age, is_female, phone_number, is_in_group, university, has_card);

            members.add(m);

            System.out.println("\nStudent member added successfully!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void addPremiumMember() {
        try {
            System.out.println("\n--- ADD PREMIUM MEMBER ---");

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


            System.out.print("has personal trainer? (true/false): ");
            boolean personal_trainer = scanner.nextBoolean();
            scanner.nextLine();

            member m = new premiumMember(name, age, is_female, phone_number, is_in_group, personal_trainer);
            members.add(m);

            System.out.println("\nPremium member added successfully!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
    private static void polymorphismDemo() {
        System.out.println("\n--- instanceof + downcasting demo ---");
        for (member m : members) {
            System.out.println("\n" + m.getName() + " -> " + m.getRole());
        }
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
            member m = members.get(i);

            System.out.println((i + 1) + ". " + m.getName() + " - " + m.getAge() + " y.o.");
            System.out.println("role: " + m.getRole());
            System.out.println("phone number: " + m.getPhone_number());
            System.out.println("is female: " + (m.isIs_female() ? "Yes" : "No"));
            System.out.println("is in group: " + (m.isIn_group() ? "Yes" : "No"));


            if (m instanceof studentMember) {
                studentMember s = (studentMember) m;
                System.out.println("university: " + s.getUniversity());
            }

            System.out.println();
        }
    }

    private static void makeAllMembersWork() {
        System.out.println("\n--- MAKE ALL MEMBERS WORK() ---");

        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (int i = 0; i < members.size(); i++) {
            member m = members.get(i);
            m.work();
        }
    }

    private static void viewStudentsOnly() {
        System.out.println("\n--- STUDENT MEMBERS ONLY ---");

        boolean found = false;

        for (int i = 0; i < members.size(); i++) {
            member m = members.get(i);
            if (m instanceof studentMember) {
                studentMember s = (studentMember) m;
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student members found.");
        }
    }

    private static void viewPremiumOnly() {
        System.out.println("\n--- PREMIUM MEMBERS ONLY ---");

        boolean found = false;

        for (int i = 0; i < members.size(); i++) {
            member m = members.get(i);
            if (m instanceof premiumMember) {
                premiumMember s = (premiumMember) m;
                System.out.println(s);
                found = true;
            }
        }


        if (!found) {
            System.out.println("No premium members found.");
        }
    }
        private static void addTrainer () {
            try {
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
                scanner.nextLine();

                trainer person_new = new trainer(name, salary, phone_number, age, exp);
                trainers.add(person_new);

                System.out.println("\nTrainer added successfully!");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }

        private static void viewAllTrainers () {
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
                System.out.println((i + 1) + ". " + trainer_i.getName() + " - " + trainer_i.getAge() + " y.o.");
                System.out.println("phone number: " + trainer_i.getPhone_number());
                System.out.println("basic salary: " + trainer_i.getSalary());
                System.out.println("full salary: " + trainer_i.salary_with_groups(member.getCount()));
                System.out.println("gymSys.trainer experience: " + trainer_i.getExp());
                System.out.println("gymSys.trainer level: " + trainer_i.quality());
                System.out.println();
            }
        }

        private static void addBranch () {
            try {
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

                branch building_new = new branch(location, is_main, floor, manager_name, is_vip);
                branches.add(building_new);

                System.out.println("\nBuilding added successfully!");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }

        private static void viewAllBranches () {
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
                System.out.println("floors: " + branch_i.getFloors());
                System.out.println("manager's name: " + branch_i.getManager_name());
                System.out.println("is main building: " + (branch_i.isMain_building() ? "Yes" : "No"));
                System.out.println("is vip: " + (branch_i.isVip() ? "Yes" : "No"));

                if (branch_i.space(member.getCount())) {
                    System.out.println("this building is overcrowded");
                }
                System.out.println();
            }
        }
    }