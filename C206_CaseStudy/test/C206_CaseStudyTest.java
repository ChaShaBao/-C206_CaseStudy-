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
	    public void testCheckEmail_EmptyEmail() {
	        assertFalse(C206_CaseStudy.checkEmail(""));
	    }

//-------------------------------------------------------------------------------------------------
// SP
	    @Test
	    public void testCheckSPName_ExistingName() {
	        ArrayList<ServiceProvider> spList = new ArrayList<>();
	        spList.add(new ServiceProvider("Existing SP", "existing@example.com", 12345678, "Some Address"));

	        assertFalse(C206_CaseStudy.checkSPName(spList, "Existing SP"));
	    }

	    @Test
	    public void testCheckSPName_NewName() {
	        ArrayList<ServiceProvider> spList = new ArrayList<>();
	        spList.add(new ServiceProvider("Existing SP", "existing@example.com", 12345678, "Some Address"));

	        assertTrue(C206_CaseStudy.checkSPName(spList, "New SP"));
	    }

	    @Test
	    public void testCheckEmail_ValidEmail() {
	        assertTrue(C206_CaseStudy.checkEmail("test@example.com"));
	    }

	    @Test
	    public void testCheckEmail_InvalidEmail() {
	        assertFalse(C206_CaseStudy.checkEmail("invalid-email"));
	    }
<<<<<<< HEAD
=======
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
	

	
} 
>>>>>>> branch 'master' of https://github.com/ChaShaBao/-C206_CaseStudy-.git

	    @Test
	    public void testCheckNumber_ValidNumber() {
	        assertTrue(C206_CaseStudy.checkNumber(12345678));
	    }

	    @Test
	    public void testCheckNumber_InvalidNumber() {
	        assertFalse(C206_CaseStudy.checkNumber(123));
	    }

	    @Test
	    public void testSPAdd_AddServiceProvider() {
	        ArrayList<ServiceProvider> spList = new ArrayList<>();
	        C206_CaseStudy.SPAdd(spList);

	        assertEquals(1, spList.size());
	    }

	    @Test
	    public void testSPView_ViewServiceProviders() {
	        ArrayList<ServiceProvider> spList = new ArrayList<>();
	        spList.add(new ServiceProvider("SP 1", "sp1@example.com", 12345678, "Address 1"));
	        spList.add(new ServiceProvider("SP 2", "sp2@example.com", 87654321, "Address 2"));

	        C206_CaseStudy.SPView(spList);
	        // Since the SPView method does not return anything, we can't directly test the output.
	        // You should manually inspect the console output to verify correctness.
	    }

	    @Test
	    public void testSPDel_DeleteServiceProvider() {
	        ArrayList<ServiceProvider> spList = new ArrayList<>();
	        spList.add(new ServiceProvider("SP to delete", "delete@example.com", 98765432, "Delete Address"));

	        C206_CaseStudy.SPDel(spList);

	        assertEquals(0, spList.size());
	    }
	}