package JobPortal.src.model;

import JobPortal.src.service.JobService;

public class Admin extends User {

    private JobService service;

    public Admin(int id, String name, JobService service) {
        super(id, name);
        this.service = service;
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Jobs");
            System.out.println("2. View Applicants");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.viewJobs();
                case 2 -> service.viewApplicants();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}