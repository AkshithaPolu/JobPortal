package JobPortal.src.model;

import java.util.HashSet;
import java.util.Set;

public class Job {
    private int jobId;
    private String title;
    private String companyName;
    private int requiredExperience;
    private String status; // OPEN / CLOSED
    private Set<Integer> applicants = new HashSet<>();

    public Job(int jobId, String title, String companyName, int requiredExperience) {
        this.jobId = jobId;
        this.title = title;
        this.companyName = companyName;
        this.requiredExperience = requiredExperience;
        this.status = "OPEN";
    }

    public int getJobId() {
        return jobId;
    }

    public String getStatus() {
        return status;
    }

    public void closeJob() {
        this.status = "CLOSED";
    }

    public Set<Integer> getApplicants() {
        return applicants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Job))
            return false;
        Job job = (Job) o;
        return jobId == job.jobId;
    }

    @Override
    public int hashCode() {
        return jobId;
    }

    @Override
    public String toString() {
        return jobId + " | " + title + " | " + companyName +
                " | Exp: " + requiredExperience + " | " + status;
    }
}