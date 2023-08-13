
import java.util.Date;

public class Appointment {
     int appointmentId;
     int userId;
     int serviceProviderId;
     String additionalDetails;
     Date appointmentDate;
     Date appointmentTime;
     String appointmentStatus;   
 

    public Appointment(int appointmentId, int userId, int serviceProviderId , String additionalDetails, Date appointmentDate,Date appointmentTime,  String appointmentStatus) {
        this.appointmentId = appointmentId;
        this.userId=userId;
        this.serviceProviderId = serviceProviderId;
       
        this.additionalDetails = additionalDetails;
        this.appointmentDate = appointmentDate;
        this.appointmentTime=appointmentTime;
        this.appointmentStatus=appointmentStatus;
       
        
        
    }

    public int getAppointmentid() {
        return appointmentId;
    }
    public int getUserId() {
    	return userId;
    }
    
    public int getServiceproviderId() {
        return serviceProviderId;
    	
    }

    public String getAdditionalDetails() {
	    return additionalDetails;
    }
    public Date getAppointmentDate() {
    	return appointmentDate;
   
    }
    public Date getAppointmentTime() {
    	return appointmentTime;
    }
    public String getAppointmentStatus() {
    	return appointmentStatus;
    
    }
    public void setAdditionaldetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
 
    }
    public void setAppointmentTime(Date appointmentTime) {
    	this.appointmentTime=appointmentTime;
    }
    public void setAppointmentStatus(String appointmentStatus) {
    	this.appointmentStatus=appointmentStatus;
    }
    
   
}