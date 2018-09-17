import java.util.ArrayList;

public class Course {
	
	// INSTANCE VARIABLES AND CONSTANTS - ORGANIZED BY TYPE THEN ALPHABETICAL
	private String courseName;
	private int maxNumberRoster;
	private int maxNumberWaitlist;
	private int rosterStudentCount;
	private int waitlistStudentCount;
	private Student[] roster;
	private Student[] waitlist;	
	
	
	
	
	
	// CONSTRUCTORS - ORGANIZED BY MOST PARAMETERS TO LEAST
	public Course(String courseName, int maxNumberRoster, int maxNumberWaitlist) {
		this.courseName = courseName;
		this.maxNumberRoster = maxNumberRoster;
		this.maxNumberWaitlist = maxNumberWaitlist;
		this.roster = new Student[maxNumberRoster];
		this.waitlist = new Student[maxNumberWaitlist];
	}
	
	
	
	
	
	
	// METHODS - ORGANIZED IN ALPHABETICAL ORDER
	public boolean addStudent(Student student) {
		boolean eligibleStudent = !this.isStudentOnRoster(student) & !this.isStudentOnWaitlist(student) & student.isTuitionPaid();
		if(eligibleStudent & this.getRosterStudentCount() < this.maxNumberRoster) {
			for(int i=0; i<this.roster.length; i++) {
				if(roster[i] == null) {
					roster[i] = student;
					this.rosterStudentCount++;
					return true;
				}
			}
		} else if(eligibleStudent & this.getWaitlistStudentCount() < this.maxNumberWaitlist) {
			for(int i=0; i<this.waitlist.length; i++) {
				if(waitlist[i] == null) {
					waitlist[i] = student;
					this.waitlistStudentCount++;
					return true;
				}
			}
		} 
		return false;
	}
	
	
	public ArrayList<Student> createRosterArrayList() {
		ArrayList<Student> studentsOnRoster = new ArrayList<Student>();
		for(Student student : roster) {
			if(student != null) {
				studentsOnRoster.add(student);
			}
		}
		return studentsOnRoster;
	}
	
	
	public ArrayList<Student> createWaitlistedArrayList() {
		ArrayList<Student> studentsWaitlisted = new ArrayList<Student>();
		for(Student student : waitlist) {
			if(student != null) {
				studentsWaitlisted.add(student);
			}
		}
		return studentsWaitlisted;
	}
	
	
	public boolean dropStudent(Student student) {
		if(this.isStudentOnRoster(student)) {
			for(int i=0; i<this.roster.length; i++) {
				if(roster[i] == student) {
					roster[i] = null;
					this.rosterStudentCount--;
					this.moveWaitlistedStudentToRoster();
					return true;
				}
			}
		} else if(this.isStudentOnWaitlist(student)) {
			for(int j=0; j<this.waitlist.length; j++) {
				if(waitlist[j] == student) {
					waitlist[j] = null;
					this.waitlistStudentCount--;
					return true;
				}
			}
		}
		return false;
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
	
	
	public ArrayList<Student> getRosterArrayList(){
		return this.createRosterArrayList();
	}
	
	
	public int getRosterStudentCount() {
		return this.rosterStudentCount;
	}
	
	
	public ArrayList<Student> getWaitlistedStudents(){
		return this.createWaitlistedArrayList();
	}
	
	
	public int getWaitlistStudentCount() {
		return this.waitlistStudentCount;
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
		for(int i=0; i<this.waitlist.length; i++) {
			if(waitlist[i] != null) {
				for(int j=0; j<this.roster.length; j++) {
					if(roster[j] == null) {
						roster[j] = waitlist[i];
						waitlist[i] = null;
						this.rosterStudentCount++;
						this.waitlistStudentCount--;
						return true;
					}
				}
			}
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
	    	   "Number of students erolled = " + this.rosterStudentCount + "\n" + 
	    	   "Maximum number of students that can enroll = " + this.maxNumberRoster + "\n" +
	    	   "Students on roster = " + this.createRosterArrayList() + "\n" +
	    	   "Number of students on waitlist = " + this.waitlistStudentCount + "\n" + 
	    	   "Maximum number of students that can be on the waitlist = " + this.maxNumberWaitlist + "\n" +
	    	   "Students on waitlist = " + this.createWaitlistedArrayList() + "\n";	
	}

	
	
	
//// END OF CLASS ////
}
