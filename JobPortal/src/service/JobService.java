package JobPortal.src.service;

import JobPortal.src.model.Job;
import java.util.*;

public class JobService {

    private List<Job> jobs = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addJob(String companyName) {
        try {
            System.out.print("Enter Job ID: ");
            int id = sc.nextInt();

            for (Job j : jobs) {
                if (j.getJobId() == id) {
                    throw new Exception("Job ID already exists!");
                }
            }

            sc.nextLine();
            System.out.print("Enter Job Title: ");
            String title = sc.nextLine();

            System.out.print("Required Experience: ");
            int exp = sc.nextInt();

            jobs.add(new Job(id, title, companyName, exp));
            System.out.println("✅ Job Posted Successfully!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void viewJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
            return;
        }
        for (Job j : jobs) {
            System.out.println(j);
        }
    }

    public void closeJob() {
        System.out.print("Enter Job ID to close: ");
        int id = sc.nextInt();

        for (Job j : jobs) {
            if (j.getJobId() == id) {
                j.closeJob();
                System.out.println("🔒 Job Closed Successfully!");
                return;
            }
        }
        System.out.println("Job not found.");
    }

    public void applyJob(int candidateId) {
        System.out.print("Enter Job ID: ");
        int id = sc.nextInt();

        for (Job j : jobs) {
            if (j.getJobId() == id) {
                if (!j.getStatus().equals("OPEN")) {
                    System.out.println("❌ Job is CLOSED.");
                    return;
                }
                if (!j.getApplicants().add(candidateId)) {
                    System.out.println("❌ Already applied!");
                    return;
                }
                System.out.println("✅ Applied Successfully!");
                return;
            }
        }
        System.out.println("Job not found.");
    }

    public void viewApplicants() {
        for (Job j : jobs) {
            System.out.println(j);
            System.out.println("Applicants: " + j.getApplicants());
        }
    }
}