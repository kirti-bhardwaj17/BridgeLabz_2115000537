class Course{
	String courseName;
	int duration;
	Course(String courseName,int duration){
	this.courseName = courseName;
	this.duration = duration;
	}
	void getCourseDetails(){
	System.out.println("courseName "+courseName+" duration "+duration);
	}
	}
class OnlineCourse extends Course{
	String platform;
	boolean isRecorded;
	OnlineCourse(String courseName, int duration , String platform , boolean isRecorded){
	super(courseName, duration);
	this.platform = platform;
	this.isRecorded = isRecorded;
	}
	void getCourseDetails(){
	        super.getCourseDetails();
	System.out.println(courseName);
	System.out.println(platform+" "+isRecorded);
	}
}
class PaidOnlineCourse extends OnlineCourse{
	double fee;
	double discount;
	PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount)
{
	super(courseName , duration,platform, isRecorded);
	this.fee = fee;
	this.discount = discount;
	}
	double getFinalFee() {
        return fee - (fee * discount / 100);
    }
    void getCourseDetails() {
        super.getCourseDetails();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%, Final Price: $" + getFinalFee());
    }
}

public class EducationSystem {
    public static void main(String[] args) {
        Course course = new Course("Java Basics", 6);
        course.getCourseDetails();

        System.out.println();

        OnlineCourse onlineCourse = new OnlineCourse("Web Development", 8, "Udemy", true);
        onlineCourse.getCourseDetails();

        System.out.println();

        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Machine Learning", 12, "Coursera", true, 500, 20);
        paidCourse.getCourseDetails();
    }
}

