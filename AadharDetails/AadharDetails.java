package AadharDetails;

public class AadharDetails {

	String name, add, dob,	 aadharNo;

	int age;
	
	public  AadharDetails() {
		// TODO Auto-generated constructor stub
		
	}

	public AadharDetails(String name, String add, String dob, int age, String aadharNo) {
		super();
		this.name = name;
		this.add = add;
		this.dob = dob;
		this.age = age;
		this.aadharNo=aadharNo;
		
		
		
		
	}

	@Override
	public String toString() {
		return "[name=" + name + ", add=" + add + ", dob=" + dob + ", aadharNo=" + aadharNo + ", age="
				+ age + "]";
	}
}
