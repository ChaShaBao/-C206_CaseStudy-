public class Request {
     int requestId;
     Service service;
     String projectDescription;
     String requirements;

    public Request(int requestId, Service service, String projectDescription, String requirements) {
        this.requestId = requestId;
        this.service = service;
        this.projectDescription = projectDescription;
        this.requirements = requirements;
    }
    public int getRequestid() {
        return requestId;
    }

    public Service getService() {
        return service;
    }
    public String getProjectdescription() {
        return projectDescription;
    }

    public String getRequiremnts() {
        return requirements;
    }
    public void setProjectdescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}