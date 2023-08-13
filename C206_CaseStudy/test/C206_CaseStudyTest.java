import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class C206_CaseStudyTest {
	
	 private Service s1;
	  private Service s2;
	  private ArrayList<Service> servicesList;
	
	ArrayList<User> userList=new ArrayList<>();

	@Before
	public void setUp() throws Exception {
	userList = new ArrayList<User>();
    userList.add(new User("Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West"));
     userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));
      
     s1 = new Service("Purchase", "Laptop", 2134.0);
     s2 = new Service("Rent", "Iphone", 324.0);

     servicesList = new ArrayList<Service>();
     
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
	      testOutput += String.format("%-10s %-20s %-10s %-15d %-20s\n", "Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West");
	      testOutput += String.format("%-10s %-20s %-10s %-15d %-20s\n", "Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East");	      
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

	    // Method to simulate user input for testing purposes
	    public void simulateUserInput(String input) {
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        // Redirecting System.in to the simulated input stream
	        System.setIn(in);
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
	   

	
} 








	
	  
	   
	 


