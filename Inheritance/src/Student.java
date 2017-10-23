import java.util.HashMap;
import java.util.Set;

/**
 * 
 */

/**
 * @author A00918598 Corey Valentyne
 *
 */
public class Student extends Person{
	
	private HashMap<String, Double> courses;
	/**
	 * Default constructor for class Student
	 */
	public Student() {
		super();
		courses = new HashMap<String, Double>();
	}
	
	/**
	 * 
	 * @param firstName A String for the first name to set
	 * @param lastName A String for the last name to set
	 * @param emailAddress A String for the email address to set
	 * @param bcitID A String for the bcit ID to set
	 */
	public Student(String firstName, String lastName, String emailAddress, String bcitID) {
		super(firstName, lastName, emailAddress, bcitID);
		courses = new HashMap<String, Double>();
	}
	
	/**
	 * 
	 * @param courseName A String for the course name to set
	 * @param grade A double for the grade to set
	 */
	public void addNewCourse(String courseName, double grade) {
		if(courseName != null && courseName.length() > 0 && grade >= 0 && grade <= 100) {
			courses.put(courseName, grade);
		}
	}
	
	/**
	 * 
	 * @return A HashMap of the student's courses
	 */
	public HashMap<String, Double> getCourses() {
		return courses;
	}
	
	/**
	 * 
	 * @return A double of the Student's average grade
	 */
	public double getAverageGrade() {
		double totalGrade = 0;
		int courseCount = 0;
		
		Set<String> coursesSet = courses.keySet();
		for(String course: coursesSet) {
			courseCount++;
			totalGrade += courses.get(course);
		}
		if(courseCount > 0) {
			double averageGrade = totalGrade / courseCount;
			return averageGrade;
		}
		return 0.0;
	}
	
}
