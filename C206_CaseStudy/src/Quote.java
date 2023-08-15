

public class Quote {
    int quoteId;
    ServiceProvider serviceProvider;
    String description;
    String responseDate;
    double price;

    public Quote(int quoteId, ServiceProvider serviceProvider,String description, String responseDate,double price) {
        this.quoteId = quoteId;
        this.serviceProvider = serviceProvider;
        this.description = description;
        this.responseDate=responseDate;
        this.price=price;
    }
    public int getQuoteId() {
        return quoteId;
    }
    
    public ServiceProvider getServiceprovider() {
        return serviceProvider;
    }
    public String getDescription() {
    	return description;
    }
    public String getresponseDate() {
    	return responseDate;
    }
    public double getPrice() {
        return price;
    
    }
   
    public void setDescription(String description) {
    	this.description=description;
    }
    public void setresponseDate(String responseDate) {
    	this.responseDate=responseDate;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
	
}