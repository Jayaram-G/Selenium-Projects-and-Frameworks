package stepDefinitions;

import io.cucumber.java.en.Given;

public class ExpressionStepDef {
	
	@Given("^I have (\\d+) laptop$")
	public void I_have_1_laptop(int count) {
		System.out.println("Laptop count "+count);
	}
	
	@Given("^I have a (\\d+\\.\\d+) CGPA$")
	public void i_have_a_CGPA(float num) {
		System.out.println("CGPA is "+num);
	}
	
	@Given("^\"(.*?)\" is elder to \"(.*?)\" and \"(.*?)\"$")
	public void is_elder_to_and(String name1, String name2, String name3) {
	    System.out.println(name1+" is elder to "+name2+" and "+name3);
	}

}
