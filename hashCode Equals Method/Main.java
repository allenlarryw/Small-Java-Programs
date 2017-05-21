import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Student> listOfStudents = new ArrayList<>();

		Scanner input = new Scanner(System.in);

		boolean continueInput = true;

		while (continueInput) {
			boolean duplication = false;
			System.out.println(
					"Please enter the student's information: Student id, First Name, Last Name, Math Grade, Science Grade, and History Grade.");
			Student temp = new Student();
			temp.setStudentIdNumber(input.nextInt());
			temp.setStudentFirstName(input.next());
			temp.setStudentLastName(input.next());
			temp.setMathGrade(input.nextInt());
			temp.setScienceGrade(input.nextInt());
			temp.setHistoryGrade(input.nextInt());
			for (int i = 0; i < listOfStudents.size(); i++) {

				if (temp.equals(listOfStudents.get(i))) {
					System.out.println("Duplicate entry please try again.");
					duplication = true;

				}

			}
			if (duplication == false) {
				System.out.println("Is this students information correct?\n" + temp
						+ "\nIf so , press Y or y to submit this students information or press N o n to re enter this students information");

				if (input.next().equalsIgnoreCase("Y")) {
					listOfStudents.add(temp);
				}

				System.out.println("Would you like to continue? Y or N");
				if (!input.next().equalsIgnoreCase("y")) {
					continueInput = false;

				}
			}
			input.nextLine();
		}

		for (int i = 0; i < listOfStudents.size(); i++) {

			System.out.println(listOfStudents.get(i));

		}
	}

}
