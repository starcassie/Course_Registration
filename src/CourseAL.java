import java.util.ArrayList;

public class CourseAL {
	
	// INSTANCE VARIABLES AND CONSTANTS - ORGANIZED BY TYPE THEN ALPHABETICAL
	private String courseName;
	private int maxNumberRoster;
	private int maxNumberWaitlist;
	private ArrayList<Student> roster;
	private ArrayList<Student> waitlist;	
	
	
	
	
	
	// CONSTRUCTORS - ORGANIZED BY MOST PARAMETERS TO LEAST
	public CourseAL(String courseName, int maxNumberRoster, int maxNumberWaitlist) {
		this.courseName = courseName;
		this.maxNumberRoster = maxNumberRoster;
		this.maxNumberWaitlist = maxNumberWaitlist;
		this.roster = new ArrayList<Student>();
		this.waitlist = new ArrayList<Student>();
	}
	
	
	
	
	
	
	// METHODS - ORGANIZED IN ALPHABETICAL ORDER
	public boolean addStudent(Student student) {
		boolean eligibleStudent = !this.isStudentOnRoster(student) & !this.isStudentOnWaitlist(student) & student.isTuitionPaid();
		if(eligibleStudent & this.roster.size() < this.maxNumberRoster) {
			roster.add(student);
			return true;
		} else if(eligibleStudent & this.waitlist.size() < this.maxNumberWaitlist) {
			waitlist.add(student);
			return true;
		} 
		return false;
	}
	
	
	public boolean dropStudent(Student student) {
		if( this.roster.remove(student) ) {
			this.moveWaitlistedStudentToRoster();
			return true;
		} else{
			return this.waitlist.remove(student);
		}
	}
	
	
	public String getCourseName() {
		return this.courseName;
	}
	
	
	public int getMaxNumberRoster() {
		return this.maxNumberRoster;
	}
	
	
	public int getMaxNumberWaitlist() {
		return this.maxNumberWaitlist;
	}
	
	
	public ArrayList<Student> getRoster(){
		return this.roster;
	}
	
	
	public ArrayList<Student> getWaitlistedStudents(){
		return this.waitlist;
	}
	
	
	public boolean isStudentOnRoster(Student studentToCheck) {
		for(Student rosterStudent : this.roster) {
			if( studentToCheck != null & studentToCheck == rosterStudent ){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isStudentOnWaitlist(Student studentToCheck) {
		for(Student waitlistedStudent : this.waitlist) {
			if( studentToCheck != null & studentToCheck == waitlistedStudent ){
				return true;
			}
		}
		return false;
	}
	
	
	// helper method
	private boolean moveWaitlistedStudentToRoster() {
		if( this.waitlist.get(0) != null & this.roster.size() < this.maxNumberRoster) {
			this.roster.add(this.waitlist.get(0));
			this.waitlist.remove(0);
			return true;
		}
		return false;
	}
	
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	// still needs to update roster since change in size
	public void setMaxNumberRoster(int maxNumberRoster) {
		this.maxNumberRoster = maxNumberRoster;
	}
	
	
	// still needs to update waitlist since change in size
	public void setMaxNumberWaitlist(int maxNumberWaitlist) {
		this.maxNumberWaitlist = maxNumberWaitlist;
	}
	
	
	public String toString() {
		return "Course name = " + this.courseName + "\n" +
	    	   "Number of students erolled = " + this.roster.size() + "\n" + 
	    	   "Maximum number of students that can enroll = " + this.maxNumberRoster + "\n" +
	    	   "Students on roster = " + this.roster + "\n" +
	    	   "Number of students on waitlist = " + this.waitlist.size() + "\n" + 
	    	   "Maximum number of students that can be on the waitlist = " + this.maxNumberWaitlist + "\n" +
	    	   "Students on waitlist = " + this.waitlist + "\n";	
	}

	
	
	
//// END OF CLASS ////
}
