
public class Person {
	public String fname="";
	public String lname="";
	
	public Person(String fname, String lname) {
		this.fname=fname;
		this.lname=lname;
	}
	public String getInfo() {
		return "firstname: "+fname+"\nlastname: "+lname;
	}
}
