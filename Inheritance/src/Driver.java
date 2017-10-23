/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person person1 = new Person();
		person1.setFirstName("Jerry");
		person1.setLastName("Seinfeld");
		
		System.out.println(person1.getFirstName() + " " + person1.getLastName());
		
		Student student1 = new Student("Jerry", "Miles", "emailAddress", "A001");
		student1.addNewCourse("COMP2912", 42.0);
		student1.addNewCourse("COMP1650", 96);
		
		Student student2 = new Student();
		
		
		System.out.println(student1.getFirstName() + "'s average grade is: " + student1.getAverageGrade());
		System.out.println(student2.getFirstName() + "'s average grade is: " + student2.getAverageGrade());
		
		Instructor instructor1 = new Instructor("Jason", "Milesy", "instruct1@bcit.ca", "A0019", 30);
		System.out.println("The instructor's name is: " + instructor1.getFirstName() + "Their wage is: " + instructor1.getHourlyWage());
		
		Database db1 = new Database();
		
		db1.addPerson(student1);
		db1.addPerson(instructor1);
		
		db1.displayDetails();
	}

}
