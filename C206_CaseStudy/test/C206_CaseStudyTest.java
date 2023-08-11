import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
	    
	     User newUserValidEmail = new User("John", "john@example.com", "123", 98765432, "Somewhere");
	     C206_CaseStudy.addUser(userList, newUserValidEmail);
	     assertEquals("Checking if the user was added", 3, userList.size());
	     assertEquals("Checking if the user was added correctly", newUserValidEmail, userList.get(2));
	     
	     User newUserInvalidEmail = new User("Jane", "invalid-email.com", "456", 87654321, "Nowhere");
	     C206_CaseStudy.addUser(userList, newUserInvalidEmail);
	     assertEquals("Checking if the user with invalid email was rejected", 3, userList.size());
	 }
	 
	 @Test
	    public void testValidContactNumber() {
	       User ValidContactNumber = new User("John", "john@example.com", "123", 12345678, "Somewhere");
	        C206_CaseStudy.addUser(userList, ValidContactNumber);
	        assertEquals("Checking if the contact number is valid", 3,userList.size());
	        assertEquals("Checking if the contact number was added correctly", ValidContactNumber, userList.get(2));
	        User InvalidContactNumber = new User("John", "john@example.com", "123", 1234567, "Somewhere");
	        C206_CaseStudy.addUser(userList, InvalidContactNumber);
	        assertEquals("Checking if the user with invalid contact number was rejected", 3, userList.size());
	    }
	  
	  @Test
	    public void testAddUser_ValidUsername() {
	        User testUser = new User("ValidUsername", "valid@example.com", "password", 12345678, "Test Address");
	        int result = C206_CaseStudy.addUser(userList, testUser);

	        assertEquals(C206_CaseStudy.ADD_SUCCESS, result);
	        assertTrue(userList.contains(testUser));
	    }
	  @Test
	  public void testRetrieveAllUser() {
	      userList.clear(); 
	      String testOutput = "";	      
	      String allUser = C206_CaseStudy.retrieveAllUser(userList);
	      assertEquals("Test nothing is displayed for empty userList", testOutput, allUser);	      
	      userList.clear(); 
	      userList.add(new User("Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West"));
	      userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));	      
	      testOutput = "";
	      testOutput += String.format("%-10s %-20s %-10s %-15d %-20s\n", "Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West");
	      testOutput += String.format("%-10s %-20s %-10s %-15d %-20s\n", "Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East");	      
	      allUser = C206_CaseStudy.retrieveAllUser(userList);     
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
	    public void testDeleteUser() {
	        ArrayList<User> userList = new ArrayList<>();
	        userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));
	        String nameToDelete = "Jerry";
	        simulateUserInput("yes\n");
	        C206_CaseStudy.deleteUser(userList, nameToDelete); 
	        assertEquals("Checking if the user was deleted", 0, userList.size()); 
	        assertFalse("Checking if the deleted user is no longer in the list", 
	        userList.contains(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East")));
	        userList.add(new User("Alice", "alice@myrp.edu.sg", "456", 98765432, "Bukit Timah"));
	        String nonExistingName = "Bob"; 
	        C206_CaseStudy.deleteUser(userList, nonExistingName); 
	        assertEquals("Checking if the list remains unchanged", 1, userList.size());
	        
	        
	    }
	    public void simulateUserInput(String input) {
	        InputStream in = new ByteArrayInputStream(input.getBytes());
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
	    @After
	    public void tearDown() throws Exception {
	      s1 = null;
	      s2 = null;
	      
	      servicesList = null;
	    }
	

	
} 








	
	  
	   
	 


