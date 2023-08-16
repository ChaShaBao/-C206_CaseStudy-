import static org.junit.Assert.*; 
import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class C206_CaseStudyTest {
	
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;
	
	 private Service s1;
	  private Service s2;
	  private ArrayList<Service> servicesList;
	
	ArrayList<User> userList=new ArrayList<>();
	ArrayList<ServiceProvider> spList = new ArrayList<ServiceProvider>();
	ArrayList<Request> requestList= new ArrayList<>();
	ArrayList<Appointment> appointmentList=new ArrayList<>();


	@Before
	public void setUp() throws Exception {
		 
	
    userList.add(new User("Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West"));
     userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));
      
     s1 = new Service("Purchase", "Laptop", 2134.0);
     s2 = new Service("Rent", "Iphone", 324.0);

     
     servicesList = new ArrayList<Service>();
     
     requestList=new ArrayList<>();
     appointmentList=new ArrayList<>();
     appointmentList=new ArrayList<Appointment>();
     requestList.add(new Request(1,1,"HHI","HOW ABOUT NO",100.0,new Date(),new Date(),"Pending"));
 	requestList.add(new Request(2,2,"BYE","YES",150.0,new Date(),new Date(),"Accepted"));
     appointmentList.add(new Appointment (1,1,1,"NIL",new Date(), new Date(),"Declined"));
     appointmentList.add(new Appointment(2,2,2,"Please help to...", new Date(), new Date(),"Accepted"));
     
	}
	 
	 @After
	    public void tearDown() throws Exception {
	      s1 = null;
	      s2 = null;
	      
	      servicesList = null;
	    }
	 
	
	
	
	//--------Users-------

	 @Test
	    public void testAddUser() {
	        // Test adding a new user
	        User newUser = new User("Alex", "Alex@gmail.com", "123", 92092990, "Yishun");
	        C206_CaseStudy.addUser(userList, newUser);
	        assertEquals("Checking if the user was added", 3, userList.size());
	        assertEquals("Checking if the user was added correctly", newUser, userList.get(2));

	        // Test adding a duplicate user
	        User duplicateUser = new User("Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West");
	        C206_CaseStudy.addUser(userList, duplicateUser);
	        assertEquals("Checking if duplicate user was added", 3, userList.size());
	    }
	 
	 @Test
	 public void testAddUserWithEmailValidation() {
	     // Creating a new user with a valid email
	     User newUserValidEmail = new User("John", "john@example.com", "123", 98765432, "Somewhere");	     
	     // Adding the user to the userList using the addUser method
	     C206_CaseStudy.addUser(userList, newUserValidEmail);	     
	     // Asserting that the user was added successfully
	     assertEquals("Checking if the user was added", 3, userList.size());	     
	     // Asserting that the user added is the same as the one in the list
	     assertEquals("Checking if the user was added correctly", newUserValidEmail, userList.get(2));	     
	     // Creating a new user with an invalid email
	     User newUserInvalidEmail = new User("Jane", "invalid-email.com", "456", 87654321, "Nowhere");	     
	     // Adding the user with an invalid email to the userList
	     C206_CaseStudy.addUser(userList, newUserInvalidEmail);	     
	     // Asserting that the user with an invalid email was rejected and the list size remains unchanged
	     assertEquals("Checking if the user with invalid email was rejected", 3, userList.size());
	 }
	 
	 @Test
	 public void testValidContactNumber() {
	     // Creating a new user with a valid contact number
	     User ValidContactNumber = new User("John", "john@example.com", "123", 12345678, "Somewhere");    
	     // Adding the user to the userList
	     C206_CaseStudy.addUser(userList, ValidContactNumber);	     
	     // Asserting that the contact number is valid and the user was added
	     assertEquals("Checking if the contact number is valid", 3, userList.size());
	     assertEquals("Checking if the contact number was added correctly", ValidContactNumber, userList.get(2));
	     // Creating a new user with an invalid contact number
	     User InvalidContactNumber = new User("John", "john@example.com", "123", 1234567, "Somewhere");	     
	     // Adding the user with an invalid contact number to the userList
	     C206_CaseStudy.addUser(userList, InvalidContactNumber);	     
	     // Asserting that the user with an invalid contact number was rejected and the list size remains unchanged
	     assertEquals("Checking if the user with invalid contact number was rejected", 3, userList.size());
	 }
	 @Test
	 public void testAddUser_ValidUsername() {
	     // Creating a new user with a valid username
	     User testUser = new User("ValidUsername", "valid@example.com", "password", 12345678, "Test Address");	     
	     // Adding the user to the userList and capturing the result
	     int result = C206_CaseStudy.addUser(userList, testUser);
	     // Asserting that the add operation was successful and the user is in the list
	     assertEquals(C206_CaseStudy.ADD_SUCCESS, result);
	     assertTrue(userList.contains(testUser));
	 }
	  @Test
	  public void testRetrieveAllUser() {
	      // Clearing the userList for testing
	      userList.clear();	      
	      // Initializing a test output string
	      String testOutput = "";      
	      // Calling the retrieveAllUser method with an empty userList
	      String allUser = C206_CaseStudy.retrieveAllUser(userList);	      
	      // Asserting that the correct output is displayed for an empty userList
	      assertEquals("Test nothing is displayed for empty userList", testOutput, allUser);	      
	      // Clearing the userList and adding sample users
	      userList.clear();
	      userList.add(new User("Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West"));
	      userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));	      
	      // Creating a formatted test output
	      testOutput = "";
	      testOutput += String.format("%-10s %-20s %-15s %-15d %-20s\n", "Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West");
	      testOutput += String.format("%-10s %-20s %-15s %-15d %-20s\n", "Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East");	      
	      // Calling the retrieveAllUser method with the populated userList
	      allUser = C206_CaseStudy.retrieveAllUser(userList);	      
	      // Asserting that the displayed output matches the expected testOutput
	      assertEquals("Test that the display is correct for non-empty userList", testOutput, allUser);
	  }

	  @Test
	    public void testCheckPassword_ValidPassword() {
	        assertTrue(C206_CaseStudy.checkPassword("Abcdefgh1@"));
	    }

	    @Test
	    public void testCheckPassword_NoUppercase() {
	        assertFalse(C206_CaseStudy.checkPassword("abcdefg1@"));
	    }

	    @Test
	    public void testCheckPassword_NoLowercase() {
	        assertFalse(C206_CaseStudy.checkPassword("ABCDEFG1@"));
	    }


	    @Test
	    public void testCheckUserName_ExistingName() {
	        userList.add(new User("John", "john@example.com", "Password123", 12345678, "Address"));
	        assertFalse(C206_CaseStudy.checkUserName(userList, "John"));
	    }

	    @Test
	    public void testCheckUserName_EmptyName() {
	        assertFalse(C206_CaseStudy.checkUserName(userList, ""));
	    }

	    @Test
	    public void testCheckEmail_ValidEmail() {
	        assertTrue(C206_CaseStudy.checkEmail("user@example.com"));
	    }

	    @Test
	    public void testCheckEmail_EmptyEmail() {
	        assertFalse(C206_CaseStudy.checkEmail(""));
	    }

	    @Test
	    public void testCheckEmail_InvalidEmail() {
	        assertFalse(C206_CaseStudy.checkEmail("invalidemail"));
	    }
	    
	    @Test
	    public void testAddress_Valid() {
	    	assertTrue(C206_CaseStudy.checkAddress("Jurong"));
	    }
	    @Test 
	    public void testAddress_EmptyAddress() {
	    	assertFalse(C206_CaseStudy.checkAddress(""));
	    }
	    

	    
	    @Test
	    public void testDeleteUser() {
	        // Creating a list of User objects for testing
	        ArrayList<User> userList = new ArrayList<>();
	        userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));	        
	        // Name of the user to be deleted
	        String nameToDelete = "Jerry";	        
	        // Simulating user input to accept deletion confirmation
	        simulateUserInput("yes\n");	        
	        // Calling the deleteUser method to test user deletion
	        C206_CaseStudy.deleteUser(userList, nameToDelete);	        
	        // Asserting that the user was deleted from the list
	        assertEquals("Checking if the user was deleted", 0, userList.size());	        
	        // Asserting that the deleted user is no longer in the list
	        assertFalse("Checking if the deleted user is no longer in the list",
	        userList.contains(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East")));	        
	        // Adding a new user to the list for further testing
	        userList.add(new User("Alice", "alice@myrp.edu.sg", "456", 98765432, "Bukit Timah"));	        
	        // Name of a non-existing user for deletion testing
	        String nonExistingName = "Bob";	        
	        // Calling the deleteUser method with a non-existing name
	        C206_CaseStudy.deleteUser(userList, nonExistingName);        
	        // Asserting that the list remains unchanged after attempting to delete non-existing user
	        assertEquals("Checking if the list remains unchanged", 1, userList.size());
	    }

	     
	    public void simulateUserInput(String input) {
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        // Redirecting System.in to the simulated input stream
	        System.setIn(in);
	    }
	    
	  //------------SERVICE PROVIDER---------------//
	    

	    
	  

	  

	    @Test
	    public void testCheckSPName() {
	        ArrayList<ServiceProvider> spList = new ArrayList<>();
	        spList.add(new ServiceProvider("Existing Provider", "existing@example.com", 12345678, "Existing Address"));

	        assertFalse(C206_CaseStudy.checkSPName(spList, "Existing Provider"));
	        assertTrue(C206_CaseStudy.checkSPName(spList, "New Provider"));
	        assertFalse(C206_CaseStudy.checkSPName(spList, ""));
	    }

	    @Test
	    public void testCheckNumber() {
	        assertFalse(C206_CaseStudy.checkNumber(123));
	        assertFalse(C206_CaseStudy.checkNumber(123456789));
	        assertTrue(C206_CaseStudy.checkNumber(12345678));
	    }
	


	    
	    //------------SERVICE---------------//
	    @Test
	    public void testAddService() {
	      // Test that service list is not null, so that can add a new service - boundary
	      assertNotNull("Test if there is valid service arraylist to add to", servicesList);

	      // Given an empty list, after adding 1 service, the size of the list is 1 -
	      // normal
	      // The service just added is as same as the first item of the list
	      C206_CaseStudy.addService(servicesList, s1);
	      assertEquals("Test that service arraylist size is 1", 1, servicesList.size());
	      assertSame("Test that service is added", s1, servicesList.get(0));

	      // Add another service. test The size of the list is 2? - normal
	      // The service just added is as same as the second item of the list
	      C206_CaseStudy.addService(servicesList, s2);
	      assertEquals("Test that service arraylist size is 2", 2, servicesList.size());
	      assertSame("Test that service is added", s2, servicesList.get(1));

	    }

	    @Test
	    public void testRetrieveAllServicesList() {
	      // fail("Not yet implemented");
	      // Test if Service list is not null but empty - boundary
	      assertNotNull("Test if there is valid service arraylist to retrieve services from", servicesList);

	  // test if the list of Services retrieved from the CaseStudy is empty -
	      // boundary
	      String allService = C206_CaseStudy.retrieveAllService(servicesList);
	      String testOutput = "";
	      assertEquals("Check that viewservice", testOutput, allService);

	      // Given an empty list, after adding 2 service, test if the size of the list is
	      // 2
	      // - normal 
	      C206_CaseStudy.addService(servicesList, s1);
	      C206_CaseStudy.addService(servicesList, s2);
	      assertEquals("Test that service arraylist size is 2", 2, servicesList.size());

	      // test if the expected output string same as the list of services retrieved
	      // from the c206_casestudy
	      allService = C206_CaseStudy.retrieveAllService(servicesList);
	      testOutput += String.format("%-20s %-30s %-15s\n", "Purchase", "Laptop", "$2134.0");
	      testOutput += String.format("%-20s %-30s %-15s\n", "Rent", "Iphone", "$324.0");
	      assertEquals("Test that ViewAllServicesList", testOutput, allService);
	    }

	    @Test
	    public void testDeleteService() {
	      // Test deleting an existing service
	      String serviceToDelete = "Iphone";
	      C206_CaseStudy.deleteService(servicesList, serviceToDelete);
	      assertEquals("Checking if the service was deleted", 0, servicesList.size());
	      assertFalse("Checking if the deleted service is no longer in the list",
	          servicesList.contains(new Service("Rent", "Iphone", 324)));

	      // Test deleting a non-existing service
	      String nonExistingservice = "nonexistingIphone";
	      C206_CaseStudy.deleteService(servicesList, nonExistingservice);
	      assertEquals("Checking if the list remains unchanged", 0, servicesList.size());

	      // Test that service list is not null, so that can delete a service - boundary
	      assertNotNull("Test if there is valid service arraylist to delete from", servicesList);
	    }
	    
	    @Test
	      public void testAddRequest() {
	        // Test adding a new Request (Boundary and Normal Test)
	            Request newRequest = new Request(3,3,"Hello","OK",140.0,new Date(), new Date(), "Declined");
	            C206_CaseStudy.addRequest(requestList, newRequest);
	            assertEquals("Checking if the Request was added", 3, requestList.size());
	            assertEquals("Checking if the Request was added correctly", newRequest, requestList.get(2));

	    
	           
	            requestList.clear();
	            //Test adding invalid data (Error Test)
	            Request invalidRequest = new Request(-1, -1, "Invalid", "Error", 50.0, new Date(), new Date(), "Pending");
	            C206_CaseStudy.addRequest(requestList, invalidRequest);
	            //Check if the list size remains unchanged
	            assertEquals("Checking if invalid Request was rejected", 1, requestList.size());
	    }
		  @Test
		  public void testAddRequest_DuplicateUserID() {
			  //Boundary and Normal Test
			  Request UserID = new Request(3,3,"Work","Sleep",123.0,new Date(), new Date(),"Declined");
		      requestList.add(UserID);

		      Request duplicateUserID = new Request(4,3,"Hi","BYE",40.0, new Date(), new Date(),"Accepted");
		      int result = C206_CaseStudy.addRequest(requestList, duplicateUserID);

		      assertEquals(C206_CaseStudy.ADD_INVALID_USERID, result);
		      assertFalse(requestList.contains(duplicateUserID));
		      
		      requestList.clear();
		      //Test adding invalid data (Error Test)
		      Request invalidRequest = new Request(-1, -1, "Invalid", "Error", 50.0, new Date(), new Date(), "Pending");
		      C206_CaseStudy.addRequest(requestList, invalidRequest);
		      //Check if the list size remains unchanged
		      assertEquals("Checking if invalid Request was rejected", 1, requestList.size());
		    
			 
			  
		  }
		  @Test
		  public void testAddRequest_ValidRequestDateFormat() {
			  //Normal Test
			// Test valid dates in the correct format of ("dd-MM-yyyy")
			  //Boundary
			   assertTrue(isValidDateFormat("07-10-2023"));
		       assertTrue(isValidDateFormat("13-12-2022"));
		       assertTrue(isValidDateFormat("15-01-2023"));
		        //Error Test
		        // Test invalid dates ( anything that is not ("dd-MM-yyyy"))
		        assertFalse(isValidDateFormat("2023-10-010"));
		        assertFalse(isValidDateFormat("01-2023-15"));
		        assertFalse(isValidDateFormat("01-04-29"));
		        assertFalse(isValidDateFormat("31/11/2023"));
		        assertFalse(isValidDateFormat("01.04.2023"));
			  
		  }
		  @Test
		  public void testAddRequest_ValidStartDateFormat() {
			  // Normal Test
			  // Test valid dates in the correct format of ("dd-MM-yyyy")
			  //Boundary
			   assertTrue(isValidDateFormat("18-10-2023"));
		       assertTrue(isValidDateFormat("19-12-2022"));
		       assertTrue(isValidDateFormat("14-01-2023"));
		        //Error Test
		        // Test invalid dates ( anything that is not ("dd-MM-yyyy"))
		        assertFalse(isValidDateFormat("2023-01-04"));
		        assertFalse(isValidDateFormat("01-2024-01"));
		        assertFalse(isValidDateFormat("01-01-22"));
		        assertFalse(isValidDateFormat("31/05/2023"));
		        assertFalse(isValidDateFormat("10.10.2023"));
		  }
		  @Test
		  public void testAddRequest_ValidRequestStatus() {
	          //Normal Test
			  //Test valid Request status (Accepted, Declined, Pending)
			  //Boundary Test
			  String status="accepted";
			  assertTrue(isValidRequestStatus(status));
			  
			  String status1="Declined";
			  assertTrue(isValidRequestStatus(status1));
			  
			  String status2="PENDING";
			  assertTrue(isValidRequestStatus(status2));
			  //Error Test
			  //Test Invalid Request Status(Anything that is not Accepted, Declined or Pending)
			  String status3="Rejected";
			  String status4="Not Accepted";
			  String status5="Waiting";
			  assertFalse(isValidRequestStatus(status3));
			  assertFalse(isValidRequestStatus(status4));
			  assertFalse(isValidRequestStatus(status5));
		  }
		  @Test
		  public void testRetrieveAllRequest() {
			    
			  //Boundary Test
			    assertNotNull("Test if there is valid Request arraylist to retrieve requests from", requestList);           
			    
			  //Normal Test
			    String allRequest = C206_CaseStudy.retrieveAllRequest(requestList);
			    
			   
			    String testOutput = "";
			    Request r1 = new Request(1, 1, "HHI", "HOW ABOUT NO", 100.0, new Date(), new Date(), "Pending");
			    C206_CaseStudy.addRequest(requestList, r1);
			    Request r2 = new Request(2, 2, "BYE", "YES", 150.0, new Date(), new Date(), "Accepted");
			    C206_CaseStudy.addRequest(requestList, r2);

			    // Format date using SimpleDateFormat with the desired format
			    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			    
			    // Format the expected output string with formatting placeholders and formatted dates
			    testOutput += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s %-20s\n",
			            "REQUEST ID", "USER ID", "SERVICE NAME", "PROJECT DESCRIPTION", "BUDGET", "REQUEST DATE", "START DATE", "REQUEST STATUS");
			    testOutput += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s %-20s\n",
			            1, 1, "HHI", "HOW ABOUT NO", 100.0, dateFormat.format(r1.getStartDate()), dateFormat.format(r1.getRequestDate()), "Pending");
			    testOutput += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s %-20s\n",
			            2, 2, "BYE", "YES", 150.0, dateFormat.format(r2.getStartDate()), dateFormat.format(r2.getRequestDate()), "Accepted");
	            
			    assertEquals("Test that ViewAllRequestsList", testOutput.trim(), allRequest.trim());
			    
			  
			}
//		  @Test
//		  public void testDeleteExistingRequest() {
//	            //Normal Test
//			    ArrayList<Request> requestList = new ArrayList<>();
//			    requestList.add(new Request(3, 3,"HIHI","OK then",45.0, new Date(), new Date(), "Pending"));
//
//		    // Test deleting an existing request
//		        int existingRequestID = 3; // ID of the existing request
//			    C206_CaseStudy.deleteRequest(requestList, existingRequestID);
//			//Error Test: Check if the deleted request is no longer in the list   
//			    assertFalse("Checking if the deleted request is no longer in the list",
//			            requestList.contains(new Request(3, 3,"HIHI","OK then",35.0, new Date(), new Date(), "Pending")));
//
//			 
//	       }
		  @Test
		  public void testDeleteNonExistingRequest() {
			  //Normal Test
		      ArrayList<Request> requestList = new ArrayList<>();
		      requestList.add(new Request(3, 3, "HIHI", "OK then", 45.0, new Date(), new Date(), "Pending"));
	          //Boundary Test
		      // Test deleting a non-existing request
		      int nonExistingID = 5; // Choose Request ID that is not present in the list
		      int initialSize = requestList.size(); // Store the initial size of the list
	          
		      // Simulate user input to cancel the deletion
		      //Error Test
		      char confirmToDelete = 'N'; // 'N' to cancel, 'Y' to confirm deletion
	             
		      if (confirmToDelete == 'Y') {
		          C206_CaseStudy.deleteRequest(requestList, nonExistingID);
		      }

		      // Check that the list size remains unchanged
		      //Boundary Test
		      assertEquals("Checking if the list size remains unchanged", initialSize, requestList.size());
		  }
		  

			  
		  


		
		  @Test
	      public void testAddAppointment() {
	              //Normal Test
	        
	              // Test adding a new Appointment
	              //Boundary Test
	              Appointment newAppointment = new Appointment(3,3,3, "Hi", new Date(), new Date(), "Pending");
	              C206_CaseStudy.addAppointment(appointmentList, newAppointment);
	              assertEquals("Checking if the Appointment was added", 3, appointmentList.size());
	              assertEquals("Checking if the Appointment was added correctly", newAppointment, appointmentList.get(2));
	                  
	              
	              
	              appointmentList.clear();
	              //Test adding invalid data (Error Test)
	              Appointment invalidAppointment = new Appointment(-1, -1,-1, "Invalid", new Date(), new Date(), "Pending");
	              C206_CaseStudy.addAppointment(appointmentList, invalidAppointment);
	              //Check if the list size remains unchanged
	              assertEquals("Checking if invalid Appointment was rejected", 1, appointmentList.size());
	      }
		  @Test
		  public void testAddAppointment_DuplicateUserID() {
			  //Normal Test
			  
			    //Test adding a new appointment
			  //Boundary Test
			    Appointment UserID = new Appointment(3,3,3,"NIL",new Date(), new Date(),"Declined");
			    appointmentList.add(UserID);
	            //create appointment with the same userID
			    //Boundary Test
		        Appointment duplicateUserID = new Appointment(4,3,4,"Hi", new Date(), new Date(),"Accepted");
		        //check if result matches the expected error code
		        int result = C206_CaseStudy.addAppointment(appointmentList, duplicateUserID);
	            //check if the result matches the expected error code. 
		        assertEquals(C206_CaseStudy.ADD_INVALID_USERID, result);
		        //check if the duplicate User ID is not in the list 
		        assertFalse(appointmentList.contains(duplicateUserID));
		        
		        
		        appointmentList.clear();
		        //Test adding invalid data (Error Test)
		        Appointment invalidAppointment = new Appointment(-1, -1,-1, "Invalid", new Date(), new Date(), "Pending");
		        C206_CaseStudy.addAppointment(appointmentList, invalidAppointment);
		        //Check if the list size remains unchanged
		        assertEquals("Checking if invalid Appointment was rejected", 1, appointmentList.size());
			  
		  }
		  @Test 
		  public void testAddAppointment_DuplicateServiceProviderID() {
			    //Test adding a new appointment
			  //Normal Test
			  //Boundary Test
			    Appointment serviceProvider = new Appointment(3,3,3,"NIL",new Date(), new Date(),"Declined");
		        appointmentList.add(serviceProvider);
	            //Create appointment with same Service Provider ID
		        //Boundary Test
		        Appointment duplicateServiceProviderID = new Appointment(5,4,3,"Hi", new Date(), new Date(),"Accepted");
		        //Call out the addAppointment method and get the result
		        int result = C206_CaseStudy.addAppointment(appointmentList, duplicateServiceProviderID);
	            //check if result matches the expected error code
		        assertEquals(C206_CaseStudy.ADD_INVALID_SERVICEPROVIDERID, result);
		        //check if the duplicate service provider ID is not in the list
		        assertFalse(appointmentList.contains(duplicateServiceProviderID));
		        
		        appointmentList.clear();
		        //Test adding invalid data (Error Test)
		        Appointment invalidAppointment = new Appointment(-1, -1,-1, "Invalid", new Date(), new Date(), "Pending");
		        C206_CaseStudy.addAppointment(appointmentList, invalidAppointment);
		        //Check if the list size remains unchanged
		        assertEquals("Checking if invalid Appointment was rejected", 1, appointmentList.size());
		  }
		  @Test
		  public void testAddAppointment_ValidDateFormat(){
			  //Normal Test
			   // Test valid dates in the correct format of ("dd-MM-yyyy")
			    //Boundary Test
			    assertTrue(isValidDateFormat("05-10-2023"));
		        assertTrue(isValidDateFormat("11-12-2022"));
		        assertTrue(isValidDateFormat("12-01-2023"));
		        
		        
		        // Test invalid dates ( anything that is not ("dd-MM-yyyy"))
		        //Error Test
		        assertFalse(isValidDateFormat("2023-01-01"));
		        assertFalse(isValidDateFormat("01-2023-01"));
		        assertFalse(isValidDateFormat("01-01-23"));
		        assertFalse(isValidDateFormat("31/12/2023"));
		        assertFalse(isValidDateFormat("01.01.2023"));
			  
		  }
		  @Test
		  public void testAddAppointment_ValidTimeFormat() {
			  //Test valid times in the correct format of ("hh:mm a")
			  //Boundary Test
			  assertTrue(isValidTimeFormat("03:00 AM"));
		      assertTrue(isValidTimeFormat("11:00 PM"));
		      assertTrue(isValidTimeFormat("10:25 AM"));
		      assertTrue(isValidTimeFormat("09:30 PM"));
		      
		      
		      
		      // Test invalid times (anything that is not ("hh:mm a"))
		      //Error Test
		      assertFalse(isValidTimeFormat("19:00 AM"));
		      assertFalse(isValidTimeFormat("11:00 AB"));
		      assertFalse(isValidTimeFormat("12:60 PM"));
		      assertFalse(isValidTimeFormat("14:00 AM "));
		      assertFalse(isValidTimeFormat("00:00 AM"));
		  }
		  @Test
		  public void testAddAppointment_ValidAppointmentStatus() {
			  // Normal Test
			  //Test valid appointment status (Accepted, Declined, Pending)
			  //Boundary Test
			  String status="accepted";
			  assertTrue(isValidAppointmentStatus(status));
			  
			  String status1="Declined";
			  assertTrue(isValidAppointmentStatus(status1));
			  
			  String status2="PENDING";
			  assertTrue(isValidAppointmentStatus(status2));
			  //Test Invalid Appointment Status(Anything that is not Accepted, Declined or Pending)
			  //Error Test
			  String status3="Rejected";
			  String status4="Not Accepted";
			  String status5="Waiting";
			  assertFalse(isValidAppointmentStatus(status3));
			  assertFalse(isValidAppointmentStatus(status4));
			  assertFalse(isValidAppointmentStatus(status5));
		  }
		  @Test
		  public void testRetrieveAllAppointment() {
			  //Normal Test
			    assertNotNull("Test if there is valid Appointment arraylist to retrieve appointments from", appointmentList);

			    String allAppointment = C206_CaseStudy.retrieveAllAppointment(appointmentList);

			    String testOutput = "";
			    Appointment a1 = new Appointment(1,1,1,"NIL",new Date(), new Date(),"Declined");
			    C206_CaseStudy.addAppointment(appointmentList, a1);
			    Appointment a2 = new Appointment(2,2,2,"Please help to...", new Date(), new Date(),"Accepted");
			    C206_CaseStudy.addAppointment(appointmentList, a2);

			    // Format date using SimpleDateFormat with the desired format
			    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");		    
			    // Format the expected output string with formatting placeholders and formatted dates
			    testOutput += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s\n",
			    		"APPOINTMENT ID", "USER ID", "SERVICE PROVIDER ID", "ADDITIONAL DETAILS", "DATE", "TIME", "APPOINTMENT STATUS" );
			    testOutput += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s\n",
			    		1,1,1,"NIL",dateFormat.format(a2.getAppointmentDate()), timeFormat.format(a2.getAppointmentTime()),"Declined");
			    testOutput += String.format("%-15s %-20s %-30s %-20s %-20s %-20s %-20s\n",
			    		2,2,2,"Please help to...", dateFormat.format(a2.getAppointmentDate()),timeFormat.format(a2.getAppointmentTime()),"Accepted");
	   
			    assertEquals("Test that ViewAllAppointmentList", testOutput.trim(), allAppointment.trim());
			    
			    
			 
		  }
		  
//		  @Test
//		  public void testDeleteExistingAppointment() {
//			  //Normal Test
//			  ArrayList<Appointment> appointmentList = new ArrayList<>();
//			    appointmentList.add(new Appointment(3, 3, 3, "HIHI", new Date(), new Date(), "Pending"));
//
//			    // Test deleting an existing appointment
//			    int existingAppointmentID = 3; // ID of the existing appointment
//			    C206_CaseStudy.deleteAppointment(appointmentList, existingAppointmentID);
//			    assertFalse("Checking if the deleted appointment is no longer in the list",
//			            appointmentList.contains(new Appointment(3, 3, 3, "HIHI", new Date(), new Date(), "Pending")));
//
//			    
//		  }
		  @Test
		  public void testDeleteNonExistingAppointment() {
			  //Normal Test
			  ArrayList<Appointment> appointmentList = new ArrayList<>();
			  appointmentList.add(new Appointment(3, 3, 3, "HIHI", new Date(), new Date(), "Pending"));
			  // Test deleting a non-existing appointment
			  //Boundary Test
			    int nonExistingID = 5; // Choose appointment ID that is not present in the list
			    int initialSize = appointmentList.size(); // Store the initial size of the list

			    // Simulate user input to cancel the deletion
			    // Error Test
			    char confirmToDelete = 'N'; // 'N' to cancel, 'Y' to confirm deletion

			    if (confirmToDelete == 'Y') {
			        C206_CaseStudy.deleteAppointment(appointmentList, nonExistingID);
			    }

			    // Check that the list size remains unchanged
			    assertEquals("Checking if the list size remains unchanged", initialSize, appointmentList.size());
			}

		  
		  
		  private boolean isValidDateFormat(String date) {
		        // The Regular expression to match "dd-MM-yyyy" format
		        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$";
		        return date.matches(regex);
		    }
		  private boolean isValidRequestStatus(String status) {
		        // Define the valid Request statuses
		        String[] validStatuses = { "accepted", "declined", "pending" };

		        // Check if the provided status is in the list of valid Request statuses
		        for (String validStatus : validStatuses) {
		            if (validStatus.equalsIgnoreCase(status)) {
		                return true;
		            }
		        }
		        return false;
		    }
		  private boolean isValidTimeFormat(String time) {
		        // The Regular expression to match "hh:mm a" format
		        String regex = "^(0?[1-9]|1[0-2]):[0-5][0-9] [APap][Mm]$";
		        return time.matches(regex);
		    }
		    private boolean isValidAppointmentStatus(String status) {
		        // Define the valid appointment statuses
		        String[] validStatuses = { "accepted", "declined", "pending" };

		        // Check if the provided status is in the list of valid appointment statuses
		        for (String validStatus : validStatuses) {
		            if (validStatus.equalsIgnoreCase(status)) {
		                return true;
		            }
		        }
		        return false;
		    }
	   

	
} 








	
	  
	   
	 


