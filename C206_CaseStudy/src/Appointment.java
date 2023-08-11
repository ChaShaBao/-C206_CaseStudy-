import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
     int appointmentId;
     Service service;
     ServiceProvider serviceProvider;
     User user;
     Date date;
     String additionalDetails;

    public Appointment(int appointmentId, Service service, ServiceProvider serviceProvider, User user, String date, String additionalDetails) {
        this.appointmentId = appointmentId;
        this.service = service;
        this.serviceProvider = serviceProvider;
        this.user = user;
        this.date = parseDate(date);
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
    public Date getDate() {
      return date;
    }
    public String getAdditionaldetails() {
      return additionalDetails;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setAdditionaldetils(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            return inputFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null;
        }
    }
}