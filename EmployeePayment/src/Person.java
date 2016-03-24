
public class Person {
     private String firstName;
     private String lastName;
     private double hourlyRate;
	/**
	 * 
	 */
	public Person() {
	this.firstName ="John";
	this.lastName="Doe";
	this.hourlyRate =10;
	
		
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param hourlyRate
	 */
	public Person(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}
	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", hourlyRate=" + hourlyRate + "]";
	}
	public double getPayment(int hours){
		return this.hourlyRate*hours;	
	}
	
}
	
	
