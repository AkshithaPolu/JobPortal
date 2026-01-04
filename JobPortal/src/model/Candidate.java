package JobPortal.src.model;

import JobPortal.src.service.JobService;

public class Candidate extends User {

    private JobService service;

    public Candidate(int id, String name, JobService service) {
        super(id, name);
        this.service = service;
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\n--- Candidate Menu ---");
            System.out.println("1. View Jobs");
            System.out.println("2. Apply Job");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.viewJobs();
                case 2 -> service.applyJob(id);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

}
