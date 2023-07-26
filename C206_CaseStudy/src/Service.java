public class Service {
    String serviceName;
    String description;
    double price;

    public Service(String serviceName, String description, double price) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }
    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }
    public double getPrice() {
    	return price;
    }
    public void setService(String service) {
        this.serviceName = service;
    }
    public void setPrice(double price) {
        this.price = price;
    }
   
}