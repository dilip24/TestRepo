package APISessions.APIs;

public class BasicInformation 
{
	String id;
	String firstname;
	String lastname;
	String designation;
	AddressDetails[] address;
	
	
	public AddressDetails[] getAddress() {
		return address;
	}
	public void setAddress(AddressDetails[] address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
