
public class ServiceProvider {
	
     String ServiceName;
     String email;
     String contactNumber;
     String businessAddress;
    

    public ServiceProvider(String name, String email, String contactNumber, String businessAddress) {
        this.ServiceName = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.businessAddress = businessAddress;   
    }
    public String getName() {
        return ServiceName;
    }

    public String getEmail() {
        return email;
    }
    public String getContactNumber() {
    	return contactNumber;
    }
    public String getBusinessAddress() {
    	return businessAddress;
    }
    public void setName(String name) {
        this.ServiceName = name;
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