import java.util.Date;

public class Request {
     int requestId;
     User user;
     Service service;
     String projectDescription;  
     Date requestDate;
     Date startDate;
     double budget;

    public Request(int requestId, User user ,Service service, String projectDescription, Date requestDate, Date startDate,double budget) {
        this.requestId = requestId;
        this.user=user;
        this.service = service;
        this.projectDescription = projectDescription;     
        this.requestDate=requestDate;
        this.startDate=startDate;
        this.budget=budget;
    }
    public int getRequestid() {
        return requestId;
    }
    public User getUser() {
    	return user;
    }

    public Service getService() {
        return service;
    }
    
    public String getProjectdescription() {
        return projectDescription;
    }

   
    public Date getRequestDate() {
    	return requestDate;
    	
    }
    public Date getStartDate() {
    	return startDate;
    }
    public double getBudget() {
    	return budget;
    }
    public void setProjectdescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
   
    public void setRequestDate(Date requestDate) {
    	this.requestDate=requestDate;
    	
    }
    public void setStartDate(Date startDate) {
    	this.startDate=startDate;
    }
    public void setBudget(double budget) {
    	this.budget=budget;
    }
}