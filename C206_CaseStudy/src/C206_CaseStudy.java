import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
public class C206_CaseStudy {
	private static final int OPTION_QUIT = 7;

	public static void main(String[] args) {
 	ArrayList<User> userList = new ArrayList<User>();
    ArrayList<ServiceProvider> spList = new ArrayList<ServiceProvider>();
    ArrayList<Service> servicesList = new ArrayList<Service>();
    ArrayList<Quote> quotesList = new ArrayList<Quote>();
    ArrayList<Request> requestList = new ArrayList<Request>();
    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    
    
    
    //testForUser 
    userList.add(new User("Tom", "Tom@myrp.edu.sg","123",92012910,"Jurong West"));
	userList.add(new User("Jerry", "Jerry@myrp.edu.sg","123",92092910,"Jurong East"));
	userList.add(new User("Alex", "Alex@gmail.com","123",92092990, "Yishun"));
	userList.add(new User("Jane","Jane@gmail.com","123",92092910 ,"Woodlands"));

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
    		
    	
    	
	} else if (choice==OPTION_QUIT) {
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
	    
	    if (userList.add(new User(name, email, password, contactNumber, address))) {
	    	System.out.println("User Added Successfully");
	    } else {
	    	System.out.println("Adding Failed");
	    }
	    
	    }

	
	
	public static String retrieveAllUser(ArrayList<User> UserList) {
		String output = "";
		
		for (int i = 0; i < UserList.size(); i++) {

			output += String.format("%-10s %-20s %-10s %-15d %-20s\n", 
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
	    String output = String.format("%-10s %-20s %-10s %-15s %-20s\n", "USERNAME", "EMAIL",
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
		while (!checkSPName(spList, SPName)){
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
			System.out.println(String.format("%-10s %-20s %-10d %s\n", i.getName(),i.getEmail(),i.getContactNumber(),i.getBusinessAddress()));
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
	
	public static boolean checkNumber(int number) {
		String numberString = Integer.toString(number);
		if (numberString.length() != 8) {
	    	System.out.println("Invalid Number");
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
	 public void simulateUserInput(String input) {
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	    }
}

