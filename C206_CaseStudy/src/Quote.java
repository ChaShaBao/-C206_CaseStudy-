import java.util.Date;

public class Quote {
    int quoteId;
    int serviceProviderId;
    String description;
    double price;
    Date responseDate;
    Date proposedTimeline;
  

    public Quote(int quoteId,int serviceProviderId,String description,double price,Date responseDate,Date proposedTimeline) {
        this.quoteId = quoteId;
        this.serviceProviderId=serviceProviderId;
       
        this.description = description;
        this.price=price;
        this.responseDate=responseDate;
        this.proposedTimeline=proposedTimeline;
    }
    public int getQuoteId() {
        return quoteId;
    }
    public int getServiceProviderId() {
    	return serviceProviderId;
    }
    public String getDescription() {
    	return description;
    }

    public double getPrice() {
        return price;
    }
    public Date getResponseDate() {
    	return responseDate;
    
    
    }
    public Date getProposedTimeline() {
    	return proposedTimeline;
    
    }
   
    public void setDescription(String description) {
    	this.description=description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setresponseDate(Date responseDate) {
    	this.responseDate=responseDate;
    }
    public void setProposedTimeline(Date proposedTimeline) {
    	this.proposedTimeline=proposedTimeline;
    }
    
    
	
}
