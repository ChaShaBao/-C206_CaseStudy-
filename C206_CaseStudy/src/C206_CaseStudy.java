import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
public class C206_CaseStudy {
	private static final int OPTION_QUIT = 7;

	public static void main(String[] args) {
 	ArrayList<User> userList = new ArrayList<User>();
    ArrayList<ServiceProvider> spList = new ArrayList<ServiceProvider>();
    ArrayList<Service> servicesList = new ArrayList<Service>();
    ArrayList<Quote> quotesList = new ArrayList<Quote>();
    ArrayList<Request> requestList = new ArrayList<Request>();
    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    
  //Test Service Provider
  		spList.add(new ServiceProvider("Nigro", "black@", 12345678, "nigeria"));
  		// test for quotes
  		quotesList.add(new Quote(12345, spList.get(0),"qwerty","01/01/2000",100.00));
    
    //testForUser 
    userList.add(new User("Tom", "Tom@myrp.edu.sg","123",92012910,"Jurong West"));
	userList.add(new User("Jerry", "Jerry@myrp.edu.sg","123",92092910,"Jurong East"));
	userList.add(new User("Alex", "Alex@gmail.com","123",92092990, "Yishun"));
	userList.add(new User("Jane","Jane@gmail.com","123",92092910 ,"Woodlands"));

	//testForRequest
	requestList.add(new Request(1,1,"HHI","HOW ABOUT NO",100.0,new Date(),new Date(),"Pending"));
	requestList.add(new Request(2,2,"BYE","YES",150.0,new Date(),new Date(),"Accepted"));
	
	//testForAppointment
	 appointmentList.add(new Appointment(1,1,1,"Yes",new Date(),new Date(),"Pending"));
     appointmentList.add(new Appointment(2,2,2,"No",new Date(),new Date(),"Pending"));
	
    int choice = 0;
   
    while (choice!=OPTION_QUIT) {
    	
    	C206_CaseStudy.menu();
    	choice = Helper.readInt("Enter an option > ");
    	if (choice == 1) {
    		
    		C206_CaseStudy.menuUser();
    		int a=Helper.readInt("Enter an option > ");  		
    		if (a == 1) {
    			inputUser(userList);
    		    
    		
    		}else if (a == 2) {
    			C206_CaseStudy.viewAllUser(userList);
    			
    		}else if (a==3) {
    			String NameToDelete = Helper.readString("Enter the name of the user to delete: ");
    		    C206_CaseStudy.deleteUser(userList, NameToDelete);
    		}else {
    			System.out.println("INVALID OPTION");
    		}
    	
    	} else if (choice == 2) {
			SPMenu(spList);
			int b = Helper.readInt("Enter an option > ");
			if (b == 1) {
				SPAdd(spList);
			} else if (b == 2) {
				SPView(spList);
			} else if (b == 3) {
				SPDel(spList);
			}
    	} else if (choice == 3) {
			C206_CaseStudy.menuService();
			int c = Helper.readInt("Enter an option> ");
			if (c == 1) {
				Service s = inputService(servicesList);
				int status = C206_CaseStudy.addService(servicesList, s);
				if (status == C206_CaseStudy.ADD_SUCCESS2) {
					System.out.println("*** Service added successfully ***");

				} else if (status == C206_CaseStudy.ADD_INVALID_SERVICE1) {
					System.out.println("INVALID SERVICE: Invalid service name format. ");

				}

			} else if (c == 2) {
				System.out.println(C206_CaseStudy.viewAllService(servicesList));

			} else if (c == 3) {
				String serviceToDelete = Helper.readString("Enter the name of the service to delete: ");
				C206_CaseStudy.deleteService(servicesList, serviceToDelete);
			} else {
				System.out.println("INVALID OPTION");
			}
    	} else if (choice == 4) {
			quotemenu(quotesList);
			int ch = Helper.readInt("Enter an option > ");
			if (ch == 1) {
				viewAllquote(quotesList);
			} else if (ch == 2) {
				addQuote(quotesList, spList);
			} else if (ch == 3) {
				deleteQuote(quotesList);
			}
    	
    	}else if (choice == 5) {
    		C206_CaseStudy.menuRequest();
    		int e = Helper.readInt("Enter an option > ");
    		if  (e==1){
    			Request r = C206_CaseStudy.inputRequest(requestList);
    			int status=C206_CaseStudy.addRequest(requestList,r);
    			if (status== C206_CaseStudy.ADD_SUCCESS) {
    				System.out.println("*** Request added successfully ***");
    			}
    			else if (status==C206_CaseStudy.ADD_INVALID_REQUESTID) {
    				System.out.println("INVALID REQUEST: Invalid request ID format or request ID already exists. ");
    			}
    			else if (status==C206_CaseStudy.ADD_INVALID_USERID) {
    				System.out.println("INVALID USER: Invalid user ID format or user ID already exists.");
    			}
    			
    			
    		}
    		else if (e==2) {
    			C206_CaseStudy.viewAllRequest(requestList);
    		}
    		else if (e==3) {
    			int requestToDelete=Helper.readInt("Enter the requestID to delete: ");
    			C206_CaseStudy.deleteRequest(requestList,requestToDelete);
    		}
    		else {
    			System.out.println("INVALID OPTION");
    		}
    		}else if (choice==6) {
    			C206_CaseStudy.menuAppointment();
    		int f= Helper.readInt("Enter an option > ");
    		if (f==1) {
    			Appointment a = C206_CaseStudy.inputAppointment(appointmentList);
    			int status=C206_CaseStudy.addAppointment(appointmentList,a);
    			if (status ==C206_CaseStudy.ADD_SUCCESS) {
    				System.out.println("*** Appointment added successfully ***");
    				
    			}
    			else if (status == C206_CaseStudy.ADD_INVALID_APPOINTMENTID) {
    				System.out.println("INVALID APPOINTMENT: Invalid appointment ID format or appointment ID already exists. ");
    				
    			}
    			else if (status==C206_CaseStudy.ADD_INVALID_USERID) {
    				System.out.println("INVALID USER: Invalid user ID format or user ID already exists. ");
    				
    			}
    			else if (status==C206_CaseStudy.ADD_INVALID_SERVICEPROVIDERID) {
    				System.out.println("INVALID SERVICE PROVIDER: Invalid Service Provider ID format or Service Provider ID already exists. ");
    			}
    			
    		}
    		else if (f==2) {
    			C206_CaseStudy.viewAllAppointment(appointmentList);
    		}
    		else if (f==3) {
    			int appointmentToDelete= Helper.readInt("Enter the appointmentID to delete: ");
    			C206_CaseStudy.deleteAppointment(appointmentList, appointmentToDelete);
    		}
    		else {
    			System.out.println("INVALID OPTION");
    		}
    	
    
 	
    	
	} else if  (choice==OPTION_QUIT) {
		System.out.println("Bye!");
    		}
    }
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Renovation Portal");
		System.out.println("1. User");
		System.out.println("2. Service Provider");
		System.out.println("3. Service");
		System.out.println("4. Quote");
		System.out.println("5. Request");
		System.out.println("6. Appointment");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void menuUser() {
		C206_CaseStudy.setHeader("Users");
		System.out.println("1. Add User");
		System.out.println("2. View all User");
		System.out.println("3. Delete User");
	}
	
	public static void inputUser(ArrayList<User> userList) {
	    String name = "";
	    name = Helper.readString("Enter Username > ");
	        
	        
	        while (!checkUserName(userList, name)) {
	        	name = Helper.readString("Enter Username > ");
	        }
	    

	    String email = Helper.readString("Enter Email > ");
	    while (!checkEmail(email)) {
        	email = Helper.readString("Enter Email > ");
	    }
	    
	    String password = Helper.readString("Enter Password > ");
	    while(!checkPassword(password)) {
	    	password=Helper.readString("Enter Password > ");
	    }
	    
	    int contactNumber = Helper.readInt("Enter Contact Number > ");
	    while (!checkNumber(contactNumber)) {
	    	contactNumber = Helper.readInt("Enter Contact Number > ");
	    }
	    
	    String address = Helper.readString("Enter Address > ");
	    while(!checkAddress(address)) {
	    	address= Helper.readString("Enter Address > ");
	    }
	    
	    if (userList.add(new User(name, email, password, contactNumber, address))) {
	    	System.out.println("User Added Successfully");
	    } else {
	    	System.out.println("Adding Failed");
	    }
	    
	    }

	
	
	public static String retrieveAllUser(ArrayList<User> UserList) {
		String output = "";
		
		for (int i = 0; i < UserList.size(); i++) {

			output += String.format("%-10s %-20s %-15s %-15d %-20s\n", 
					UserList.get(i).getName(),
					UserList.get(i).getEmail(), 
					UserList.get(i).getPassword(),
					UserList.get(i).getContactNumber(),
					UserList.get(i).getAddress());
		}
		return output;
	}
	public static void viewAllUser(ArrayList<User> userList) {
	    C206_CaseStudy.setHeader("USER LIST");
	    String output = String.format("%-10s %-20s %-15s %-15s %-20s\n", "USERNAME", "EMAIL",
	            "PASSWORD", "CONTACT NUMBER", "ADDRESS");
	    output += retrieveAllUser(userList);
	    System.out.println(output);
	}
	public static void deleteUser(ArrayList<User> userList, String name) {
	    boolean found = false;
	    User userToRemove = null;

	    for (User user : userList) {
	        if (user.getName().equalsIgnoreCase(name)) {
	            userToRemove = user;
	            found = true;
	            break;
	        }
	    }

	    if (found) { 
	        String confirmation = Helper.readString("Do you want to delete this user? (yes/no) > ");
	        if (confirmation.equalsIgnoreCase("yes")) {
	            userList.remove(userToRemove);
	            System.out.println("*** User deleted ***");
	        } else {
	            System.out.println("Deletion canceled.");
	        }
	    } else {
	        System.out.println("User with the specified name not found.");
	    }
	}
	
	
	public static final int ADD_SUCCESS = 0;
	public static final int ADD_INVALID_USER = 1;
	public static final int ADD_INVALID_EMAIL = 2;

	public static int addUser(ArrayList<User> userList, User u) {
	    String trimmedName = u.getName().trim();
	    String trimmedEmail = u.getEmail().trim();

	    if (trimmedName.isEmpty()) {
	        return ADD_INVALID_USER;
	    }

	    if (trimmedEmail.isEmpty() || !trimmedEmail.contains("@")) {
	        return ADD_INVALID_EMAIL;
	    }

	    for (User user : userList) {
	        if (user.getName().equalsIgnoreCase(trimmedName)) {
	            return ADD_INVALID_USER;
	        }
	    }

	    userList.add(u);
	    return ADD_SUCCESS;
	}
	
	public static boolean checkUserName(ArrayList<User> userList, String name) {
		for (User i : userList) {
			if (name.trim().isEmpty()) {
				System.out.println("Name Cannot Be Empty");
				return false;
			} else if (i.getName().equalsIgnoreCase(name)) {
				System.out.println("Name Already Exist");
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkAddress(String address) {
		if (address.trim().isEmpty()) {
			System.out.println("Address cannot be empty");
			return false;
		}
		return true;
	}
	
	public static boolean checkPassword(String password) {
	    
	    if (password.length() < 8) {
	        System.out.println("Password must be at least 8 characters long");
	        return false;
	    }

	   
	    if (!password.matches(".*[A-Z].*")) {
	        System.out.println("Password must contain at least one uppercase letter");
	        return false;
	    }

	   
	    if (!password.matches(".*[a-z].*")) {
	        System.out.println("Password must contain at least one lowercase letter");
	        return false;
	    }


	    
	    return true;
	}
	
	public static boolean checkEmail(String email) {
		if (email.trim().isEmpty()) {
			System.out.println("Email cannot be empty");
			return false;
		} else if (!email.trim().contains("@")) {
			System.out.println("Invalid Email");
			return false;
		}
		return true;
	}

	
//-------------------------------------------------------------------------------------------------------------------------------
// SP
	
	
	public static void SPMenu(ArrayList<ServiceProvider> spList) {
		Helper.line(30, "-");
		System.out.println("Service Provider");
		Helper.line(30, "-");
		System.out.println("1. Add Service Provider\n2. View All Service Provider\n3. Delete User");
	}

	public static void SPAdd(ArrayList<ServiceProvider> spList) {
		String SPName = Helper.readString("Enter Service Provider Name > ");
		while (!checkSPName(spList, SPName)) {
			SPName = Helper.readString("Enter Service Provider Name > ");
		}
		String SPEmail = Helper.readString("Enter Email > ");
		while (!checkEmail(SPEmail)) {

			SPEmail = Helper.readString("Enter Email > ");
		}
		int SPNo = Helper.readInt("Enter Contact Number > ");
		while (!checkNumber(SPNo)) {
			System.out.println("Invalid Contact Number");
			SPNo = Helper.readInt("Enter Contact Number > ");
		}
		String BusinessAdd = Helper.readString("Enter Business Address > ");
		boolean yes = spList.add(new ServiceProvider(SPName, SPEmail, SPNo, BusinessAdd));
		if (yes) {
			System.out.println("Service Provider Added Successfully");
		} else {
			System.out.println("Adding Failed");
		}

	}

	public static void SPView(ArrayList<ServiceProvider> spList) {
		Helper.line(30, "-");
		System.out.println("SERVICE PROVIDER LIST");
		Helper.line(30, "-");
		System.out.println("");
		System.out.println(String.format("%-10s %-20s %-10s %s\n", "NAME", "EMAIL", "CONTACT", "ADDRESS"));
		for (ServiceProvider i : spList) {
			System.out.println(String.format("%-10s %-20s %-10d %s\n", i.getName(), i.getEmail(), i.getContactNumber(),
					i.getBusinessAddress()));
		}
	}

	public static void SPDel(ArrayList<ServiceProvider> spList) {
		String delname = Helper.readString("Enter service provider name to delete > ");
		boolean rmv = false;
		for (ServiceProvider i : spList) {
			if (i.getName().equalsIgnoreCase(delname)) {
				spList.remove(i);
				rmv = true;
			}
		}
		if (rmv = true) {
			System.out.println("Service Provider Removed Successfully");
		} else {
			System.out.println("Service Provider Not Found");
		}
	}

	public static boolean checkSPName(ArrayList<ServiceProvider> spList, String name) {
		for (ServiceProvider i : spList) {
			if (i.getName().equalsIgnoreCase(name)) {
				System.out.println("Name Already Exist");
				return false;
			}
		}
		return true;
	}

	

	public static boolean checkNumber(int number) {
		String numberString = Integer.toString(number);
		if (numberString.length() != 8) {
			System.out.println("Invalid Number");
			return false;
		}
		return true;
	}

	

	public void simulateUserInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
	 //----------------------------------------------
	 //Services 
	 
	 public static void menuService() {
			C206_CaseStudy.setHeader("Services");
			System.out.println("1. Add Services");
			System.out.println("2. View all Services");
			System.out.println("3. Delete Services");
		}

		public static Service inputService(ArrayList<Service> servicesList) {
			String service = "";
			String description = "";
			double price = 0.0;
			while (true) {
		        service = Helper.readString("Enter Service Name > ");

		        if (service.trim().isEmpty()) {
		            System.out.println("Service Name cannot be empty.");
		        } else {
		            boolean isDuplicate = false;
		            isDuplicate = checkinput(servicesList, service, isDuplicate);
		            
		            if (isDuplicate) {
		                System.out.println("THE SERVICE NAME ALREADY EXIST");
		            } else {
		                break;
		            }
		        }
		    }
			while (service.isEmpty()) {
				service = Helper.readString("Enter Service name > ");
				if (service.isEmpty()) {
					System.out.println("Service Name cannot be empty > ");
				}
			}
			while (description.isEmpty()) {
				description = Helper.readString("Enter Description > ");
				if (description.isEmpty()) {
					System.out.println("Description cannot be empty > ");
				}
			}
			while (price == 0.0) {
				price = Helper.readDouble("Enter price >$ ");
				if (price == 0.0) {
					System.out.println("Price cannot be empty. ");
				}
			}

			Service s = new Service(service, description, price);
			return s;
		}

		public static boolean checkinput(ArrayList<Service> servicesList, String service, boolean isDuplicate) {
			for (Service services : servicesList) {
			    if (services.getServiceName().equalsIgnoreCase(service.trim())) {
			        isDuplicate = true;
			        break;
			    }
			}
			return isDuplicate;
		}

		public static String retrieveAllService(ArrayList<Service> servicesList) {
			String output = "";

			for (int i = 0; i < servicesList.size(); i++) {

				output += String.format("%-20s %-30s %-15s\n", servicesList.get(i).getServiceName(),
						servicesList.get(i).getDescription(), "$" + servicesList.get(i).getPrice());

			}
			return output;
		}

		public static String viewAllService(ArrayList<Service> servicesList) {
			C206_CaseStudy.setHeader("SERVICE LIST");
			String output = String.format("%-20s %-30s %-15s\n", "SERVICE NAME", "DESCRIPTION", "PRICE");
			output += retrieveAllService(servicesList);
			// System.out.println(output);
			return output;
		}

		public static void deleteService(ArrayList<Service> servicesList, String serviceName) {
			Service serviceToRemove = null;
			for (Service S : servicesList) {
				if (S.getServiceName().equalsIgnoreCase(serviceName)) {
					// servicesList.remove(S);
					char confirmtoDelete = Character.toLowerCase(Helper.readChar("Confirm to delete? (y/n) > "));
					if (confirmtoDelete == 'y') {
						serviceToRemove = S;
						servicesList.remove(S);

						break;
					} else if (confirmtoDelete == 'n') {
						System.out.println("Deletion has been cancelled.");
						return;
					} else {
						System.out.println("Invalid input. Please enter 'y' or 'n'.");
					}
				}
			}

			if (serviceToRemove != null) {
				servicesList.remove(serviceToRemove);
				System.out.println("*** Service deleted ***");
			} else {
				System.out.println("Service with the specified name not found.");
			}
		}

		public static final int ADD_SUCCESS2 = 0;
		public static final int ADD_INVALID_SERVICE1 = 1;

		public static int addService(ArrayList<Service> servicesList, Service S) {
			String trimmedServiceName = S.getServiceName().trim();

			if (trimmedServiceName.isEmpty()) {
				return ADD_INVALID_SERVICE1;

			}
			for (Service s : servicesList) {
				if (s.getServiceName().equalsIgnoreCase(trimmedServiceName)) {
					return ADD_INVALID_SERVICE1;
				}
			}
			servicesList.add(S);
			return ADD_SUCCESS2;
		}
		
		//Quotes
		
		public static void quotemenu(ArrayList<Quote> quotesList) {
			Helper.line(30, "-");
			System.out.println("QUOTES");
			Helper.line(30, "-");
			System.out.println("1. View All Quotes\n2. Add New Quote\n3. Delete Quotes");
		}

		public static void viewAllquote(ArrayList<Quote> quotesList) {
			Helper.line(30, "-");
			System.out.println(String.format("%-10s %-20s %-10s %-15s %s", "Quote ID", "Service Provider", "Description",
					"Response Date", "Price"));
			for (Quote i : quotesList) {
				System.out.println(String.format("%-10s %-20s %-10s %-15s %.2f\n", i.getQuoteId(),
						i.getServiceprovider().getName(), i.getDescription(), i.getresponseDate(), i.getPrice()));
			}
		}

		public static void addQuote(ArrayList<Quote> quotesList, ArrayList<ServiceProvider> spList) {
			int quoteID = Helper.readInt("Enter Quote ID > ");
			while (!checkQuoteID(quotesList, quoteID)) {
				quoteID = Helper.readInt("Enter Quote ID > ");
			}
			ServiceProvider x = null;
			boolean found = false;

			while (!found) {
				String sp = Helper.readString("Enter Service Provider Name > ");
				for (ServiceProvider i : spList) {
					if (i.getName().equalsIgnoreCase(sp)) {
						x = i;
						found = true;
					}
				}
				if (found) {
					break;
				} else {
					System.out.println("That Service Provider Does Not Exist");
				}
			}
			String desc = Helper.readString("Enter Description > ");
			String responsedate = Helper.readString("Enter Response Date (DD/MM/YYYY) > ");
			while (!checkDate(responsedate)) {
				responsedate = Helper.readString("Enter Response Date (DD/MM/YYYY) > ");
			}
			double price = Helper.readDouble("Enter price > ");
			boolean success = quotesList.add(new Quote(quoteID, x, desc, responsedate, price));
			if (success) {
				System.out.println("Quote Created Successfully!");
			} else {
				System.out.println("Failed To Create Quote.");
			}
		}

		public static void deleteQuote(ArrayList<Quote> quotesList) {
			boolean found = false;
			int quoteid = Helper.readInt("Please enter quote ID > ");

			for (Quote quote : quotesList) {
				if (quote.getQuoteId() == quoteid) {
					quotesList.remove(quote);
					found = true;
					break;
				}
			}
			if (found) {
				System.out.println("*** quote deleted ***");
			} else {
				System.out.println("quote with the specified id not found.");
			}
		}
		
		public static boolean checkQuoteID(ArrayList<Quote> quotesList, int id) {
			for (Quote q : quotesList) {
				if (q.getQuoteId() == id) {
					System.out.println("Quote ID is already in use.");
					return false;
				}
			}
			return true;
		}
		
		public static boolean checkDate(String date) {
	        String dateP = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";
	        Pattern p = Pattern.compile(dateP);
	        Matcher m = p.matcher(date);
	        if (m.matches()) {
	        	return true;
	        }
	        System.out.println("Invalid date format");
	        return false;
	    }
		  
		  //Request
		    public static void menuRequest() {
			    C206_CaseStudy.setHeader("Requests");
			    System.out.println("1. Add Requests");
			    System.out.println("2. View all Requests");
			    System.out.println("3. Delete Requests");
		    }
		    public static Request inputRequest(ArrayList<Request> requestList) {
		        int requestID=0;
		        int userID=0;
		        String serviceName="";
		        String projectDescription="";
		        double budget=0.0;
		    
		    
		    
		        while (true) {
		            requestID = Helper.readInt("Enter Request ID > ");

		            if (requestID == 0) {
		                System.out.println("Request ID cannot be empty.");
		            } else {
		                boolean idExists = false;
		                for (Request existingRequest : requestList) {
		                    if (existingRequest.getRequestid() == requestID) {
		                        idExists = true;
		                        break;
		                    }
		                }
		            
		                if (idExists) {
		                    System.out.println("Request ID already exists. Please enter a different ID.");
		                } else {
		                    break;
		                }
		            }
		        }

		        while (true) {
		            userID = Helper.readInt("Enter User ID > ");

		            if (userID == 0) {
		                System.out.println("User ID cannot be empty.");
		            } else {
		                boolean idExists = false;
		                for (Request existingUser : requestList) {
		                if (existingUser.getUserId() == userID) {
		                    idExists = true;
		                    break;
		                }
		            }
		            
		            if (idExists) {
		                System.out.println("User ID already exists. Please enter a different ID.");
		            } else {
		                break;
		            }
		        }
		    }

		    while(serviceName.isEmpty()) {
		    	serviceName=Helper.readString("Enter Service Name > ");
		    	if(serviceName.isEmpty()) {
		    		System.out.println("Service Name cannot be empty.");
		    	}
		}
		    while(projectDescription.isEmpty()) {
		    	projectDescription=Helper.readString("Enter Project Description > ");
		    	if (projectDescription.isEmpty()) {
		    		System.out.println("Project Description cannot be empty.");
		    	}
		    }
		    while(budget==0.0) {
		    	budget=Helper.readDouble("Enter your budget > ");
		    	if(budget==0.0) {
		    		System.out.println("Budget cannot be empty.");
		    	}
		    }
		    Date requestDate;
		    while (true) {
		        String requestDateStr = Helper.readString("Enter Date Of Request (DD-MM-YYYY) > ");
		        if (isValidDateFormat(requestDateStr)) {
		            requestDate = parseDateToDate(requestDateStr, "dd-MM-yyyy");
		            break;
		        } else {
		            System.out.println("Invalid date format. Please enter date in DD-MM-YYYY format.");
		        }
		    }

		    Date startDate;
		    while (true) {
		        String startDateStr = Helper.readString("Enter Start Date (DD-MM-YYYY) > ");
		        if (isValidDateFormat(startDateStr)) {
		            startDate = parseDateToDate(startDateStr, "dd-MM-yyyy");
		            if (startDate.after(requestDate)) {
		                break;
		            } else {
		                System.out.println("Start date must be later than the request date.");
		            }
		        } else {
		            System.out.println("Invalid date format. Please enter date in DD-MM-YYYY format.");
		        }
		    }
		    
		    
		    String requestStatus;
		    while(true) {
		    	requestStatus=Helper.readString("Enter Status (Pending/Accepted/Declined) > ");
		    	if (requestStatus.equalsIgnoreCase("Pending") || requestStatus.equalsIgnoreCase("Accepted")||requestStatus.equalsIgnoreCase("Declined")){
		    		break;
		    	}
		    	else {
		    		System.out.println("Invalid status. Please enter 'Pending','Accepted' or 'Declined'. ");
		    	}
		    }   
		    Request r = new Request(requestID, userID,serviceName,projectDescription,budget,requestDate,startDate, requestStatus);
		    return r;
		}
		    public static String retrieveAllRequest(ArrayList<Request> requestList) {
		    String output = String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s %-20s\n",
		            "REQUEST ID", "USER ID", "SERVICE NAME", "PROJECT DESCRIPTION", "BUDGET", "REQUEST DATE", "START DATE", "REQUEST STATUS");
		    Helper.line(170, "-");

		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		    for (int i = 0; i < requestList.size(); i++) {
		        String formattedRequestDate = dateFormat.format(requestList.get(i).getRequestDate());
		        String formattedStartDate = dateFormat.format(requestList.get(i).getStartDate());

		        output += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s %-20s\n",
		                requestList.get(i).getRequestid(),
		                requestList.get(i).getUserId(),
		                requestList.get(i).getServiceName(),
		                requestList.get(i).getProjectdescription(),
		                requestList.get(i).getBudget(),
		                formattedRequestDate,
		                formattedStartDate,
		                requestList.get(i).getRequestStatus());
		    }
		    return output;
		}
		    public static void viewAllRequest(ArrayList<Request> requestList) {
			
		        C206_CaseStudy.setHeader("REQUEST LIST");
		        String output=retrieveAllRequest(requestList);
		        System.out.println(output);
		}
		    public static void deleteRequest(ArrayList<Request> requestList, int requestID) {
		        Request requestToRemove = null;
		        boolean requestFound = false; // Flag to indicate if the request is found
		        
		        for (Request request : requestList) {
		            if (request.getRequestid() == requestID) {
		                requestToRemove = request;
		                requestFound = true;
		                break;
		            }
		        }

		        if (requestFound) {
		            while (true) {
		                char confirmToDelete = Character.toLowerCase(Helper.readChar("Are you sure you want to delete? (y/n) > "));
		                if (confirmToDelete == 'y') {
		                    requestList.remove(requestToRemove);
		                    System.out.println("*** Request deleted ***");
		                    break; 
		                } else if (confirmToDelete == 'n') {
		                    System.out.println("Deletion of Request has been cancelled.");
		                    break; 
		                } else {
		                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
		                }
		            }
		        } else {
		            System.out.println("Request with the specified request ID not found.");
		            
		            
		            int newRequestID = Helper.readInt("Please enter the request ID again> ");
		            deleteRequest(requestList, newRequestID); // Recursively call deleteRequest
		        }
		    }


		public static final int ADD_INVALID_REQUESTID = 0;
		public static final int ADD_INVALID_USERID=1;


		public static int addRequest(ArrayList<Request> requestList, Request r) {
		    for(Request request:requestList) {
		    	if(request.getRequestid()==r.getRequestid()) {
		    		return ADD_INVALID_REQUESTID;
		    	}
		    }
		    for(Request user:requestList) {
		    	if(user.getUserId()==r.getUserId()) {
		    		return ADD_INVALID_USERID;
		    	}
		    }
		requestList.add(r);
		return ADD_SUCCESS;
		}
		public static void menuAppointment() {
			C206_CaseStudy.setHeader("Appointments");
			System.out.println("1. Add Appointments");
			System.out.println("2. View all Appointments");
			System.out.println("3. Delete Apointments");
		}
		public static Appointment inputAppointment(ArrayList<Appointment> appointmentList) {
		    int appointmentID=0;
		    int userID=0;
		    int serviceProviderID=0;
		    String additionalDetails="";
		    String appointmentStatus="";
		        
		    while(true){
		        appointmentID = Helper.readInt("Enter Appointment ID > ");

		        if (appointmentID == 0) {
		            System.out.println("Appointment ID cannot be empty.");
		        } else {
		            boolean idExists = false;
		            for (Appointment existingAppointment : appointmentList) {
		                if (existingAppointment.getAppointmentid() == appointmentID) {
		                    idExists = true;
		                    break;
		                }
		            }
		            
		            if (idExists) {
		                System.out.println("Appointment ID already exists. Please enter a different ID.");
		            } else {
		                break;
		  
		            }
		    	}
		    }
		    
		   while(true){
		       userID = Helper.readInt("Enter User ID > ");

		       if (userID == 0) {
		           System.out.println("User ID cannot be empty.");
		       } else {
		           boolean idExists = false;
		           for (Appointment existingUser : appointmentList) {
		               if (existingUser.getUserId() == userID) {
		                   idExists = true;
		                   break;
		               }
		           }
		           
		           if (idExists) {
		               System.out.println("User ID already exists. Please enter a different ID.");
		           } else {
		               break;
		 
		           }
		   	}
		   }
		   
		  while(true){
		      serviceProviderID = Helper.readInt("Enter Service Provider ID > ");

		      if (serviceProviderID == 0) {
		          System.out.println("Service Provider ID cannot be empty.");
		      } else {
		          boolean idExists = false;
		          for (Appointment existingServiceProvider : appointmentList) {
		              if (existingServiceProvider.getServiceproviderId() == serviceProviderID) {
		                  idExists = true;
		                  break;
		              }
		          }
		          
		          if (idExists) {
		              System.out.println("Service Provider ID already exists. Please enter a different ID.");
		          } else {
		              break;

		          }
		  	}
		  }
		    
		    while(additionalDetails.isEmpty()) {
		    	additionalDetails=Helper.readString("Enter Additional Details > ");
		    	if (additionalDetails.isEmpty()) {
		    		System.out.println("Additional Details cannot be empty. ");
		    	}
		    }
		    Date appointmentDate = null;
		    while (true) {
		        String appointmentDateStr = Helper.readString("Enter Date Of Appointment (DD-MM-YYYY) > ");
		        if (isValidDateFormat(appointmentDateStr)) {
		            appointmentDate = parseDateToDate(appointmentDateStr, "dd-MM-yyyy");
		            break;
		        } else {
		            System.out.println("Invalid date format. Please enter date in DD-MM-YYYY format.");
		        }
		    }
		    Date appointmentTime = null;
		    while (true) {
		        String appointmentTimeStr = Helper.readString("Enter Time Of Appointment (HH:mm a) > ");
		        if (isValidTimeFormat(appointmentTimeStr)) {
		            appointmentTime = parseTimeToDate(appointmentTimeStr, "hh:mm a");
		            break;
		        } else {
		            System.out.println("Invalid time format. Please enter time in HH:mm AM/PM format.");
		        }
		    }

		    
		  
		   
		    while(true) {
		    	appointmentStatus=Helper.readString("Enter Appointment Status (Pending/Accepted/Declined) > ");
		    	if (appointmentStatus.equalsIgnoreCase("Pending") || appointmentStatus.equalsIgnoreCase("Accepted") || appointmentStatus.equalsIgnoreCase("Declined")){
		    		break;
		    	}
		    	else {
		    		System.out.println("Invalid Appointment Status. Please enter 'Pending' , 'Accepted' or 'Declined'. ");
		    	}
		    }
		   
		    
		    Appointment a = new Appointment(appointmentID, userID,serviceProviderID,additionalDetails,appointmentDate,appointmentTime,appointmentStatus );
		    return a;
		  }
		  public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {
		       String output = String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s\n",
		            "APPOINTMENT ID", "USER ID", "SERVICE PROVIDER ID", "ADDITIONAL DETAILS", "DATE", "TIME","APPOINTMENT STATUS");

		       SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		    
		       for (int i = 0; i < appointmentList.size(); i++) {
		           String formattedDate = dateFormat.format(appointmentList.get(i).getAppointmentDate());
		           String formattedTime = new SimpleDateFormat("hh:mm a").format(appointmentList.get(i).getAppointmentTime());

		           output += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s\n",
		                appointmentList.get(i).getAppointmentid(),
		                appointmentList.get(i).getUserId(),
		                appointmentList.get(i).getServiceproviderId(),
		                appointmentList.get(i).getAdditionalDetails(),
		                formattedDate,
		                formattedTime,
		                appointmentList.get(i).getAppointmentStatus());
		    }
		        return output;
		}
		 
		   
		 
		  
		    public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {
			
		        C206_CaseStudy.setHeader("APPOINTMENT LIST");
		    
		        String output = retrieveAllAppointment(appointmentList);
		        System.out.println(output);
		}
		    
		    public static void deleteAppointment(ArrayList<Appointment> appointmentList, int appointmentID) {
		    	 Appointment appointmentToRemove = null;
		         boolean appointmentFound = false; 
		         
		         for (Appointment a : appointmentList) {
		             if (a.getAppointmentid() == appointmentID) {
		                 appointmentToRemove = a;
		                 appointmentFound = true;
		                 break;
		             }
		         }

		         if (appointmentFound) {
		             while (true) {
		                 char confirmToDelete = Character.toLowerCase(Helper.readChar("Are you sure you want to delete? (y/n) > "));
		                 if (confirmToDelete == 'y') {
		                     appointmentList.remove(appointmentToRemove);
		                     System.out.println("*** Appointment deleted ***");
		                     break; 
		                 } else if (confirmToDelete == 'n') {
		                     System.out.println("Deletion of Appointment has been cancelled.");
		                     break; 
		                 } else {
		                     System.out.println("Invalid input. Please enter 'y' or 'n'.");
		                 }
		             }
		         } else {
		             System.out.println("Appointment with the specified appointment ID not found.");
		             
		             
		             int newAppointmentID = Helper.readInt("Please enter the appointment ID again> ");
		             deleteAppointment(appointmentList, newAppointmentID); // Recursively call deleteRequest
		         }
		     }
		   
		    public static final int ADD_INVALID_APPOINTMENTID = 1;
		    public static final int ADD_INVALID_SERVICEPROVIDERID=2;
		    		


		    public static int addAppointment(ArrayList<Appointment> appointmentList, Appointment a) {
		        for(Appointment appointment:appointmentList) {
		    	    if(appointment.getAppointmentid()==a.getAppointmentid()) {
		    		    return ADD_INVALID_APPOINTMENTID;
		    	}
		    }
		        for(Appointment user:appointmentList) {
		        	if(user.getUserId()== a.getUserId()) {
		        		return ADD_INVALID_USERID;
		        	}
		        	
		        }
		        	
		        for(Appointment serviceProvider:appointmentList) {
		        	if(serviceProvider.getServiceproviderId()==a.getServiceproviderId()) {
		        		return ADD_INVALID_SERVICEPROVIDERID;
		        	}
		        	
		        }
		    
		         appointmentList.add(a);
		         return ADD_SUCCESS;
		}
		    
		    public static boolean isValidDateFormat(String date) {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        dateFormat.setLenient(false); // Strict parsing
		    try {
		        dateFormat.parse(date);
		        return true;
		    } catch (ParseException e) {
		        return false;
		    }
		}
		    public static boolean isValidTimeFormat(String time) {
		        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		        timeFormat.setLenient(false); // Strict parsing

		        try {
		            timeFormat.parse(time);
		            return true;
		        } catch (ParseException e) {
		            return false;
		        }
		}
		    public static Date parseTimeToDate(String timeString, String format) {
		        SimpleDateFormat formatter = new SimpleDateFormat(format);
		        try {
		            return formatter.parse(timeString);
		        } catch (ParseException e) {
		            return null;
		        }
		    }
		    public static Date parseDateToDate(String dateString, String format) {
		        SimpleDateFormat formatter = new SimpleDateFormat(format);
		        try {
		            return formatter.parse(dateString);
		        } catch (ParseException e) {
		            return null;
		        }
		    }
		    public static LocalTime parseTimeToLocalTime(String timeString, String format) {
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		        return LocalTime.parse(timeString, formatter);
		    }
		    

		    public static boolean isValidPhoneNumber(int phoneNumber) {
		        String phoneNumberStr = Integer.toString(phoneNumber);
		        return phoneNumberStr.matches("[89]\\d{7}");
		}
	 
}

