import java.util.Scanner;
public class Driver {
	private static boolean quit = false;

	public static void main(String args[]) {
		Course firstClass = new Course("History 101", 5, 5);
		intro();
		while (quit == false) {
			courseAction();
		}
	}

	public static void intro() {
		System.out.println("Welcome to the Course Registration system for:");
		System.out.println(firstClass.getCourseName());
		System.out.println("0 enrolled (maximum allowed " + firstClass.getMaxNumberRoster() + ")"
			+"\n0 on waitlist (maximum allowed "+ firstClass.getMaxNumberWaitlist() + ")");
	}

	public static void courseAction() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nWhat action would you like to take?");
		System.out.println("1 to add a student"
			+ "\n2 to drop a student"
			+ "\n3 to print the course" 
			+ "\n4 to exit");
		boolean vaildEntry = true;
		do {
			int option = input.nextInt();

			if (option == 1) {
				System.out.println(addStudent());
			} else if (option == 2) {
				dropStudent();
			} else if (option == 3) {
				printCourse();
			} else if (option == 4) {
				quit = true;
				System.out.println("Thank you for using the system.");
				System.out.println(firstClass.toString());
			} else {
				vaildEntry = false;
				System.out.println("Please enter a number 1 through 4:");
			}
		} while (vaildEntry == false);
	}

	public static String addStudent() {
		Scanner input = new Scanner(System.in);
		boolean studentAdded;
		String success;
		System.out.println("Enter the first name:");
		String name = input.nextLine();
		System.out.println("Enter the last name:");
		String lastName = input.nextLine();
		System.out.println("Enter the id name:");
		String id = input.nextLine();
		System.out.println("Has the student paid tuition? Enter y or n.");
		String paidTuition = input.nextLine();

		if (paidTuition.equals("y")) {
			studentAdded = firstClass.addStudent(makeStudent(name, lastName, id, paidTuition));
		} else if (paidTuition.equals("n")) {
			studentAdded = firstClass.addStudent(makeStudent(name, lastName, id, paidTuition));
		} else {
			studentAdded = false;
		}

		if (studentAdded == true) {
			success = "added successfully";
		} else {
			success = "not added";
		}

		return (name + " " + lastName + " (" + id + ") " + success);

	}

	public static Student makeStudent(String name, String lastName, String id, String paidTuition) {
		Student create = new Student(name, lastName, id, paidTuition);
		return (create);
	}

	public static String dropStudent() {
		Scanner input = new Scanner(System.in);
		boolean studentDropped;
		String success;
		System.out.println("Enter the first name:");
		String name = input.nextLine();
		System.out.println("Enter the last name:");
		String lastName = input.nextLine();
		System.out.println("Enter the id name:");
		String id = input.nextLine();
		System.out.println("Has the student paid tuition? Enter y or n.");
		String paidTuition = input.nextLine();

		if (paidTuition.equals("y")) {
			studentDropped = firstClass.dropStudent(makeStudent(name, lastName, id, paidTuition));
		} else if (paidTuition.equals("n")) {
			studentDropped = firstClass.dropStudent(makeStudent(name, lastName, id, paidTuition));
		} else {
			studentDropped = false;
		}

		if (studentDropped == true) {
			success = "dropped successfully";
		} else {
			success = "not dropped";
		}

		return (name + " " + lastName + " (" + id + ") " + success);
	}

	public static boolean printCourse() {
		System.out.println(firstClass.toString());
	}
}
