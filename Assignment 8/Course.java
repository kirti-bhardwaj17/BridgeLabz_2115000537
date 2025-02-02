class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Default Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course.updateInstituteName("Tech Academy");
        Course c1 = new Course("Java Programming", 6, 15000);
        Course c2 = new Course("Web Development", 4, 12000);
        
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
