import java.util.Date;

public class Quote {
    int quoteId;
    ServiceProvider serviceProvider;
    String description;
    Date responseDate;
    double price;

    public Quote(int quoteId, ServiceProvider serviceProvider,String description, Date responseDate,double price) {
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
    public Date responseDate() {
    	return responseDate;
    }
    public double getPrice() {
        return price;
    
    }
   
    public void setDescription(String description) {
    	this.description=description;
    }
    public void setresponseDate(Date responseDate) {
    	this.responseDate=responseDate;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
	
}