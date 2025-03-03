import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminFunc {
    Scanner sc = new Scanner(System.in);
    protected ArrayList<Underwriter> underwriters = new ArrayList<>();

    protected void underwriterRegistration() {

        System.out.println("---ENTER UNDERWRITER DETAILS---");
        System.out.print("Enter name >> ");
        String name = sc.nextLine();


        System.out.print("Enter your date of birth (dd-MM-yyyy) >> ");
        String inputDOB = sc.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dob = LocalDate.parse(inputDOB, formatter);

            Underwriter newUnderwriter = new Underwriter(name, dob);
            underwriters.add(newUnderwriter);
            System.out.println("\nUnderwriter Registered Successfully!\n");

        } catch (Exception e) {
            System.out.println("\nInvalid date format. Please use dd-MM-yyyy.");
        }
    }

    protected Underwriter searchUnderwriterByID(long id) {
        Underwriter found = null;

        for (Underwriter underwriter: underwriters) {
            if (id == underwriter.getId()) {
                found = underwriter;
                break;
            }
        }

        return found;
    }

    protected void updateUnderwriterPassword(long id) {

        Underwriter found = null;

        for (Underwriter underwriter: underwriters) {
            if (id == underwriter.getId()) {
                found = underwriter;
                break;
            }
        }

        if (found == null) {
            System.out.println("\nNo such Underwriter exist with the given ID");
            return;
        }

        System.out.print("Enter New Password >> ");
        String newPassword = sc.nextLine();

        System.out.print("Renter New Password >> ");
        String confirmPassword = sc.nextLine();

        if (!newPassword.equals(confirmPassword)) {
            System.out.println("\nPasswords did not match. Try again");
            return;
        }

        found.setPassword(newPassword);
        System.out.println("\nPassword updated for ID: " + id);
    }

    protected void deleteUnderwriterByID(long id) {
        ArrayList<Underwriter> newList = new ArrayList<>();
        boolean flag = false;

        for (Underwriter underwriter: underwriters) {
            if (id != underwriter.getId()) {
                newList.add(underwriter);
                flag = true;
            }
        }

        if (flag) {
            System.out.println("\nNo such UnderWriter exist with the given ID");
        }
        else {
            underwriters = newList;
            System.out.println("\nUnderWriter with ID: " + id + " is deleted");
        }

    }

    protected void viewAllUnderwriters() {

        if (underwriters.isEmpty()) {
            System.out.println("\nEmpty List!");
            return;
        }
        for (Underwriter underwriter: underwriters) {
            System.out.println("ID: " + underwriter.getId());
            System.out.println("Name: " + underwriter.getName());
            System.out.println("DOB: " + underwriter.getDob());
            System.out.println("JoiningDate: " + underwriter.getJoiningDate());
            System.out.println("--------------------------------");
        }
    }

    protected void vehiclesSpecificToUnderwriter(long id) {
        Underwriter found = null;

        for (Underwriter underwriter: underwriters) {
            if (id == underwriter.getId()) {
                found = underwriter;
                break;
            }
        }

        if (found == null) {
            System.out.println("\nNo Underwriter with the ID exists!");
            return;
        }
//        TODO
    }
}
