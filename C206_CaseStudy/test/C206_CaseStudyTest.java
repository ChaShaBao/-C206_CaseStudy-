import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest {
	
	ArrayList<User> userList=new ArrayList<>();

	@Before
	public void setUp() throws Exception {
	userList = new ArrayList<User>();
    userList.add(new User("Tom", "Tom@myrp.edu.sg", "123", 92012910, "Jurong West"));
     userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));
        
	}
	
	

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
	 public void testDeleteUser() {
		    
		    ArrayList<User> userList = new ArrayList<>();
		    userList.add(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East"));

		    // Test deleting an existing user
		    String nameToDelete = "Jerry"; // Name of the user to delete
		    C206_CaseStudy.deleteUser(userList, nameToDelete); 
		    assertEquals("Checking if the user was deleted", 0, userList.size()); 
		    assertFalse("Checking if the deleted user is no longer in the list", 
		    		userList.contains(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East")));

		    // Add a new user to the list for the next test
		    userList.add(new User("Alice", "alice@myrp.edu.sg", "456", 98765432, "Bukit Timah"));

		    // Test deleting a non-existing user
		    String nonExistingName = "Bob"; 
		    C206_CaseStudy.deleteUser(userList, nonExistingName); 
		    assertEquals("Checking if the list remains unchanged", 1, userList.size());
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
	
} 








	
	  
	   
	 


