import java.util.ArrayList;
public class C206_CaseStudy {
	public static void main(String[] args) {
 	ArrayList<User> userList = new ArrayList<User>();
    ArrayList<ServiceProvider> serviceProvidersList = new ArrayList<ServiceProvider>();
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
   
    while (choice!=7) {
    	
    	C206_CaseStudy.menu();
    	choice = Helper.readInt("Enter an option > ");
    	if (choice == 1) {
    		
    		C206_CaseStudy.menuUser();
    		int a=Helper.readInt("Enter an option > ");
    		if(a==1) {
    			User u = inputUser();
				C206_CaseStudy.addUser(userList, u);
				System.out.println("*** User added ***");
    		}else if (a == 2) {
    			C206_CaseStudy.viewAllUser(userList);
    		}else if (a==3) {
    			String emailToDelete = Helper.readString("Enter the email of the user to delete: ");
    		    C206_CaseStudy.deleteUser(userList, emailToDelete);
    			
    		}else {
    			System.out.println("INVALID OPTION");
    		}
    	
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
		System.out.println("6. appointment");
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
	public static User inputUser() {
		String name = Helper.readString("Enter Username > ");
		String email = Helper.readString("Enter Email > ");
		String password=Helper.readString("Enter Password > ");
		int contactNumber= Helper.readInt("Enter Contact Number > ");
		String address=Helper.readString("Enter Address > ");
		User u = new User(name,email,password,contactNumber,address);
		return u;
	}
	public static void addUser(ArrayList<User>UserList,User u) {
		User user;
		for(int i = 0; i < UserList.size(); i++) {
			user = UserList.get(i);
			if (user.getName().equalsIgnoreCase(u.getName()) )
				return;
		}
		if ((u.getName().isEmpty()) || (u.getAddress().isEmpty()) ) {
			return;
		}
		UserList.add(u);
	}
	public static String retrieveAllUser(ArrayList<User> UserList) {
		String output = "";
		
		for (int i = 0; i < UserList.size(); i++) {

			output += String.format("%-10s %-20s %-10s %-15d %-10s\n", 
					UserList.get(i).getName(),
					UserList.get(i).getEmail(), 
					UserList.get(i).getPassword(),
					UserList.get(i).getContactNumber(),
					UserList.get(i).getAddress());
		}
		return output;
	}
	public static void viewAllUser(ArrayList<User> UserList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-20s %-10s %-15s %-10s\n", "USERNAME", "EMAIL",
				 "PASSWORD", "CONTACT NUMBER","ADDRESS");
		 output += retrieveAllUser(UserList);
		System.out.println(output);
	}
	public static void deleteUser(ArrayList<User> userList, String email) {
	    boolean found = false;
	    for (User user : userList) {
	        if (user.getEmail().equalsIgnoreCase(email)) {
	            userList.remove(user);
	            found = true;
	            break;
	        }
	    }

	    if (found) {
	        System.out.println("*** User deleted ***");
	    } else {
	        System.out.println("User with the specified email not found.");
	    }
	}
		

}

