
public class ServiceProvider {
	
     String name;
     String email;
     String contactNumber;
     String businessAddress;

    public ServiceProvider(String name, String email, String contactNumber, String businessAddress) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.businessAddress = businessAddress;   
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getContact() {
    	return contactNumber;
    }
    public String getBusiness() {
    	return businessAddress;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setBusiness(String business) {
        this.businessAddress = business;
    }


}