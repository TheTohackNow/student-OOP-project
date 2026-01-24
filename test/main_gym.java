import java.util.ArrayList;
import java.util.Scanner;

public class main_gym {
    private static ArrayList<member> members = new ArrayList<>();
    private static ArrayList<trainer> trainers = new ArrayList<>();
    private static ArrayList<branch> branches = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("        Gym Management System");
        System.out.println("========================================");

        // Some starter data (simple)
        members.add(new member("Akyl", 17, false, "+777799999", false));
        members.add(new studentMember("Aigerim", 19, true, "+777700001", true, "KBTU", true));
        members.add(new premiumMember("Dias", 25, false, "+777700002", false, true, 2));

        trainers.add(new trainer("Alina", 200000, "+777700003", 28, 5));
        branches.add(new branch("Almaty", true, 3, "Manager A", true));

        boolean running = true;

        while (running) {
            printMenu();   // or displayMenu()

            int choice = readInt("Enter your choice: ");

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
                    viewBranches();
                    break;
                case 0:
                    System.out.println("\nBye!");
                    running = false; // exit loop
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // wait for user
            }
        }

    private static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("1. Add Member (General)");
        System.out.println("2. Add Student Member");
        System.out.println("3. Add Premium Member");
        System.out.println("4. View All Members (Polymorphic)");
        System.out.println("5. Make All Members Work (Polymorphism Demo)");
        System.out.println("6. View Students Only");
        System.out.println("7. View Premium Only");
        System.out.println("8. Polymorphism + instanceof + downcasting demo");
        System.out.println("9. View Branches");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    private static void addGeneralMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter age: ");

        boolean isFemale = readBoolean("Is female? (true/false): ");

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        boolean inGroup = readBoolean("In group classes? (true/false): ");

        member m = new member(name, age, isFemale, phone, inGroup);
        members.add(m);

        System.out.println("General gymSys.member added.");
    }

    private static void addStudentMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter age: ");

        boolean isFemale = readBoolean("Is female? (true/false): ");

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        boolean inGroup = readBoolean("In group classes? (true/false): ");

        System.out.print("Enter university: ");
        String uni = scanner.nextLine();

        boolean hasCard = readBoolean("Has student card? (true/false): ");

        member m = new studentMember(name, age, isFemale, phone, inGroup, uni, hasCard);
        members.add(m); // stored as parent type (polymorphism)

        System.out.println("Student gymSys.member added.");
    }

    private static void addPremiumMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter age: ");

        boolean isFemale = readBoolean("Is female? (true/false): ");

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        boolean inGroup = readBoolean("In group classes? (true/false): ");

        boolean personalTrainer = readBoolean("Personal gymSys.trainer included? (true/false): ");

        int guestPasses = readInt("Free guest passes: ");

        member m = new premiumMember(name, age, isFemale, phone, inGroup, personalTrainer, guestPasses);
        members.add(m); // stored as parent type (polymorphism)

        System.out.println("Premium gymSys.member added.");
    }

    private static void viewAllMembers() {
        System.out.println("\n--- All Members ---");
        if (members.size() == 0) {
            System.out.println("No members.");
            return;
        }
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ") " + members.get(i));
        }
    }

    private static void makeAllMembersWork() {
        System.out.println("\n--- All Members Work() ---");
        for (member m : members) {
            // Polymorphism: calls overridden method depending on real object type
            m.work();
        }
    }

    private static void viewStudentsOnly() {
        System.out.println("\n--- Students Only ---");
        boolean found = false;
        for (member m : members) {
            if (m instanceof studentMember) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) System.out.println("No student members.");
    }

    private static void viewPremiumOnly() {
        System.out.println("\n--- Premium Only ---");
        boolean found = false;
        for (member m : members) {
            if (m instanceof premiumMember) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) System.out.println("No premium members.");
    }

    private static void polymorphismDemo() {
        System.out.println("\n--- instanceof + downcasting demo ---");
        for (member m : members) {
            System.out.println("\n" + m.getName() + " -> " + m.getRole());

            if (m instanceof studentMember) {
                // downcast to access child-only methods
                studentMember s = (studentMember) m;
                s.applyStudentDiscount();
                s.requestStudyWorkout();
            } else if (m instanceof premiumMember) {
                premiumMember p = (premiumMember) m;
                p.accessVipZone();
                p.useGuestPass();
            } else {
                System.out.println("No extra features for general gymSys.member.");
            }
        }
    }

    private static void viewBranches() {
        System.out.println("\n--- Branches ---");
        for (int i = 0; i < branches.size(); i++) {
            branch b = branches.get(i);
            System.out.println((i + 1) + ") " + b.getLocation());
            System.out.println(" floors: " + b.getFloors());
            System.out.println(" manager: " + b.getManager_name());
            System.out.println(" main building: " + (b.isMain_building() ? "Yes" : "No"));
            if (b.space(member.getCount())) {
                System.out.println(" WARNING: this building is overcrowded");
            }
            System.out.println();
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int x = Integer.parseInt(scanner.nextLine());
                return x;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim().toLowerCase();
            if (s.equals("true")) return true;
            if (s.equals("false")) return false;
            System.out.println("Please enter true or false.");
        }
    }
}
