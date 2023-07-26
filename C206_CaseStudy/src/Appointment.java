public class Appointment {
     int appointmentId;
     Service service;
     ServiceProvider serviceProvider;
     User user;
     String date;
     String additionalDetails;

    public Appointment(int appointmentId, Service service, ServiceProvider serviceProvider, User user, String date, String additionalDetails) {
        this.appointmentId = appointmentId;
        this.service = service;
        this.serviceProvider = serviceProvider;
        this.user = user;
        this.date = date;
        this.additionalDetails = additionalDetails;
    }

    public int getAppointmentid() {
        return appointmentId;
    }
    public Service getService() {
        return service;
    }
    public ServiceProvider getServiceprovider() {
        return serviceProvider;
    }
    public User getUser() {
    	return user;
    }
    public String getDate() {
    	return date;
    }
    public String getAdditionaldetails() {
    	return additionalDetails;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setAdditionaldetils(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}