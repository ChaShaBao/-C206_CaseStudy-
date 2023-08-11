
import java.util.Date;

public class Appointment {
     int appointmentId;
     User user;
     ServiceProvider serviceProvider;
     String description;
     Date appointmentDate;
     Date appointmentTime;
     String status;   
     String additionalDetails;

    public Appointment(int appointmentId, User user, ServiceProvider serviceProvider,String description, Date appointmentDate, Date appointmentTime, String status, String additionalDetails) {
        this.appointmentId = appointmentId;
        this.user=user;
        this.serviceProvider = serviceProvider;
        this.description=description;
        this.appointmentDate = appointmentDate;
        this.appointmentTime=appointmentTime;
        this.status=status;
        this.additionalDetails = additionalDetails;
        
        
    }

    public int getAppointmentid() {
        return appointmentId;
    }
    public User getUser() {
    	return user;
    }
    
    public ServiceProvider getServiceprovider() {
        return serviceProvider;
    }
    public String getDescription(){
    	return description;
    	
    }
  
    public Date getAppointmentDate() {
    	return appointmentDate;
    }
    public Date getAppointmentTime() {
    	return appointmentTime;
    }
    public String getStatus() {
    	return status;
    }
    public String getAdditionaldetails() {
    	return additionalDetails;
    }
    public void setDescription(String description) {
    	this.description=description;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public void setAppointmentTime(Date appointmentTime) {
    	this.appointmentTime=appointmentTime;
    }
    public void setStatus(String status) {
    	this.status=status;
    }
    
    public void setAdditionaldetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}