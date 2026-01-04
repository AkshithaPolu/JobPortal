package JobPortal.src.model;

import JobPortal.src.service.JobService;

public class Company extends User {

    private JobService service;

    public Company(int id, String name, JobService service) {
        super(id, name);
        this.service = service;
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\n--- Company Menu ---");
            System.out.println("1. Post Job");
            System.out.println("2. Close Job");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.addJob(name);
                case 2 -> service.closeJob();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

}
