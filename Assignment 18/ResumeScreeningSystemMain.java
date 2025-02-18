import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;
    
    public JobRole(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleName() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    
    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }
    
    public void displayResume() {
        System.out.println("Candidate: " + candidateName + ", Role: " + jobRole.getRoleName());
    }
}

class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();
    
    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }
    
    public void displayResumes() {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResume();
        }
    }
    
    public static <T extends JobRole> void validateResume(T jobRole) {
        System.out.println("Validating resume for: " + jobRole.getRoleName());
    }
}

public class ResumeScreeningSystemMain {
    public static void main(String[] args) {
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();
        
        Resume<SoftwareEngineer> seResume = new Resume<>("Alice Johnson", new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Bob Smith", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Charlie Brown", new ProductManager());
        
        screeningSystem.addResume(seResume);
        screeningSystem.addResume(dsResume);
        screeningSystem.addResume(pmResume);
        
        System.out.println("\n--- Resume Screening ---");
        screeningSystem.displayResumes();
        
        ResumeScreeningSystem.validateResume(new SoftwareEngineer());
        ResumeScreeningSystem.validateResume(new DataScientist());
        ResumeScreeningSystem.validateResume(new ProductManager());
    }
}
