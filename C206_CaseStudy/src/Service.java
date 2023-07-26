public class Service {
    String serviceName;
    String description;
    double price;

    public Service(String serviceName, String description, double price) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }
    public String getService() {
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
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}