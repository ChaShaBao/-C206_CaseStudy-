import static org.junit.Assert.*;



import org.junit.After;
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
	

	@After
	public void tearDown() throws Exception {
		userList.clear();
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
	        // Test deleting an existing user
	        String emailToDelete = "Jerry@myrp.edu.sg";
	        C206_CaseStudy.deleteUser(userList, emailToDelete);
	        assertEquals("Checking if the user was deleted", 1, userList.size());
	        assertFalse("Checking if the deleted user is no longer in the list", userList.contains(new User("Jerry", "Jerry@myrp.edu.sg", "123", 92092910, "Jurong East")));

	        // Test deleting a non-existing user
	        String nonExistingEmail = "nonexisting@myrp.edu.sg";
	        C206_CaseStudy.deleteUser(userList, nonExistingEmail);
	        assertEquals("Checking if the list remains unchanged", 1, userList.size());
	    }
	 @Test
	 public void testAddUserWithEmailValidation() {
	     // Test adding a new user with a valid email format
	     User newUserValidEmail = new User("John", "john@example.com", "123", 98765432, "Somewhere");
	     C206_CaseStudy.addUser(userList, newUserValidEmail);
	     assertEquals("Checking if the user was added", 3, userList.size());
	     assertEquals("Checking if the user was added correctly", newUserValidEmail, userList.get(2));

	     // Test adding a new user with an invalid email format (missing @ symbol)
	     User newUserInvalidEmail = new User("Jane", "invalid-email.com", "456", 87654321, "Nowhere");
	     C206_CaseStudy.addUser(userList, newUserInvalidEmail);
	     assertEquals("Checking if the user with invalid email was rejected", 3, userList.size());
	 }
	 

}
