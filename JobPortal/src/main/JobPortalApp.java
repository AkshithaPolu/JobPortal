package JobPortal.src.main;

import JobPortal.src.model.*;
import JobPortal.src.service.JobService;
import java.util.Scanner;

public class JobPortalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JobService service = new JobService();

        System.out.println("=== Job Portal System ===");
        System.out.println("1. Admin");
        System.out.println("2. Company");
        System.out.println("3. Candidate");
        System.out.println("0. Exit");

        int choice = sc.nextInt();

        User user = null;

        switch (choice) {
            case 1 -> user = new Admin(1, "Admin", service);
            case 2 -> user = new Company(101, "Google", service);
            case 3 -> user = new Candidate(201, "John", service);
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Invalid choice");
                return;
            }
        }
        user.showMenu();
    }

}
