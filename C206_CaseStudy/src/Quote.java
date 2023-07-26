public class Quote {
    int quoteId;
    Service service;
    ServiceProvider serviceProvider;
    double price;
    String additionalInfo;

    public Quote(int quoteId, Service service, ServiceProvider serviceProvider, double price, String additionalInfo) {
        this.quoteId = quoteId;
        this.service = service;
        this.serviceProvider = serviceProvider;
        this.price = price;
        this.additionalInfo = additionalInfo;
    }
    public int getQuoteId() {
        return quoteId;
    }
    public Service getService() {
        return service;
    }
    public ServiceProvider getServiceprovider() {
        return serviceProvider;
    }
    public double getPrice() {
        return price;
    }
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}