import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Select your role: \nPress 1 : Admin \nPress 2: UnderWriter");
        System.out.print(">> ");

        Scanner sc = new Scanner(System.in);
        int role = sc.nextInt();
        sc.nextLine();

        AdminFunc adminFunc = new AdminFunc();

        switch (role) {
            case 1:
                while (true) {
                    System.out.println("\n--- Admin Dashboard ---");

                    System.out.println("A -> Underwriter Registration\n" +
                            "B -> Search Underwriter by ID\n" +
                            "C -> Update Underwriter Password\n" +
                            "D -> Delete Underwrite by ID\n" +
                            "E -> View all Underwriters\n" +
                            "F -> View all vehicle specific to Underwriter ID\n");
                    System.out.print(">> ");
                    String task = sc.nextLine();

                    switch (task) {
                        case "A":
                            adminFunc.underwriterRegistration();
                            break;

                        case "B":
                            System.out.print("Enter ID >> ");
                            long id1 = sc.nextLong();
                            sc.nextLine();
                            Underwriter underwriter = adminFunc.searchUnderwriterByID(id1);

                            if (underwriter == null) {
                                System.out.println("No such UnderWriter exist with the given ID");
                            } else {
                                System.out.println("ID: " + underwriter.getId());
                                System.out.println("Name: " + underwriter.getName());
                                System.out.println("DOB: " + underwriter.getDob());
                                System.out.println("JoiningDate: " + underwriter.getJoiningDate());
                                System.out.println("--------------------------------");
                            }
                            break;

                        case "C":
                            System.out.print("Enter ID >> ");
                            long id2 = sc.nextLong();
                            sc.nextLine();
                            adminFunc.updateUnderwriterPassword(id2);
                            break;

                        case "D":
                            System.out.print("Enter ID >> ");
                            long id3 = sc.nextLong();
                            sc.nextLine();
                            adminFunc.deleteUnderwriterByID(id3);
                            break;

                        case "E":
                            adminFunc.viewAllUnderwriters();
                            break;

                        case "F":
                            System.out.print("Enter ID >> ");
                            long id4 = sc.nextLong();
                            sc.nextLine();
                            adminFunc.vehiclesSpecificToUnderwriter(id4);
                            break;

                        default:
                            System.out.println("\nInvalid Option");
                            break;

                    }
                }

            case 2:
                System.out.println("UnderWriter");
                break;
            default:
                System.out.println("\nInvalid Option");
                break;

        }
    }
}