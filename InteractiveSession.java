import java.util.*;

/* The Driver class for project 2. Also a class that allows the user to interact with social network. */

public class InteractiveSession {
	
	public static void main(String[] args) {

		SocialNetwork myWorld = new SocialNetwork();
		myWorld.readProfiles(args[0]); // we assume the name of the file with profiles is passed as a command line argument to the main method
		// To call the program, run 
		// java InteractiveSession profiles.csv
		
		InteractiveSession ui = new InteractiveSession();
		ui.interactWithUser(myWorld);
	}

	/** Allows the user to interact with the social network myWorld by giving options to login a new user, 
	* to add a friend for the user who is logged in, to see a list of friends, to add a post, to see all posts etc. 
	* See the description on Canvas and examples for details.
	* Keeps offering the user to interact with the program until the user presses Q to quit the program. 
	* @param myWorld a SocialNetwork
	*/
	public void interactWithUser(SocialNetwork myWorld) {

		Scanner sc = new Scanner(System.in);
		String choice = "";
		// FILL IN CODE as needed
		while (!choice.equals("Q")) {
			System.out.println();
			System.out.println("Press 1 to login a user " + System.lineSeparator());
			System.out.println("Press 2 to add a friend. " + System.lineSeparator());
			System.out.println("Press 3 to see a list of friends. " + System.lineSeparator());
			System.out.println("Press 4 to add a post. " + System.lineSeparator());
			System.out.println("Press 5 to see your posts " + System.lineSeparator());
			System.out.println("Press 6 to see the posts of friends " + System.lineSeparator());
			System.out.println("Press 7 to save the logged in user's profile to the file " + System.lineSeparator());
			System.out.println("Press Q to exit the program ");
			choice = sc.nextLine();
			// FILL IN CODE

		}

	}
}