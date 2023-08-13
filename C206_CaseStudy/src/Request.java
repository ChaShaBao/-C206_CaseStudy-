import java.util.Date;

public class Request {
     int requestId;
     int userId;
     String serviceName;
     String projectDescription; 
     Double budget;
     Date requestDate;
     Date startDate;
     String requestStatus;
     

    public Request(int requestId, int userId ,String serviceName, String projectDescription,Double budget, Date requestDate, Date startDate,String requestStatus) {
        this.requestId = requestId;
        this.userId=userId;
        this.serviceName = serviceName;
        this.projectDescription = projectDescription;
        this.budget=budget;
        this.requestDate=requestDate;
        this.startDate=startDate;
        this.requestStatus=requestStatus;
     
    }
    public int getRequestid() {
        return requestId;
    }
    public int getUserId() {
    	return userId;
    }

    public String getServiceName() {
        return serviceName;
    }
    
    public String getProjectdescription() {
        return projectDescription;
    }
    public Double getBudget() {
    	return budget;
    }

   
    public Date getRequestDate() {
    	return requestDate;
    	
    }
    public Date getStartDate() {
    	return startDate;
    }
    public String getRequestStatus() {
    	return requestStatus;
    }
    public void setServiceName(String serviceName) {
    	this.serviceName=serviceName;
    }
    public void setProjectdescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public void setBudget(Double budget) {
    	this.budget=budget;
    }
   
    public void setRequestDate(Date requestDate) {
    	this.requestDate=requestDate;
    	
    }
    public void setStartDate(Date startDate) {
    	this.startDate=startDate;
    }
    public void setRequestStatus(String requestStatus) {
    	this.requestStatus=requestStatus;
    }
}


