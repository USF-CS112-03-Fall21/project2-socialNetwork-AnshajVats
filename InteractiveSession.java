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
		String name="";
		Profile currProfile = null;
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
			
			if(choice.equals("1")){
				System.out.println("Enter the username:");
				 name = sc.nextLine();
				System.out.println("Enter the password:");
				String password = sc.nextLine();
				System.out.println(checkingUsernameAndPassword(name, password, myWorld));
				currProfile = myWorld.getProfile(name);

						
			}
			else if(choice.equals("2") && currProfile != null){
				System.out.println("Enter the name of the friend you want to add");
				String friendName = sc.nextLine();
				System.out.println(checksTheProfileOfTheFriend(friendName, myWorld, name));

			}
			

			else if(choice.equals("3") && currProfile != null){
				System.out.println(currProfile.getFriends());
			}
			else if(choice.equals("4") && currProfile != null){
				System.out.println("Enter your post");
				String message = sc.nextLine();
				currProfile.addPost(name, message);
			}
			else if(choice.equals("5") && currProfile != null){

				for(Post s : currProfile.getPosts()){
					System.out.println(s);
				
				}
			}
			else if(choice.equals("6") && currProfile != null){

				for(Post s : currProfile.newFeeds(myWorld)){
					System.out.println(s);
					
				}

				
			}
			else if(choice.equals("7") && currProfile != null){

				currProfile.writeProfileToFile("Output/"+name);
			}
			else if(currProfile == null && (!choice.equals("Q"))) {
				System.out.println("You have to log in first");
			}
			else if(!(choice.equals("3")) && (!choice.equals("4")) && (!choice.equals("5")) && (!choice.equals("6")) 
				&& (!choice.equals("2")) && (!choice.equals("1")) && (!choice.equals("7")) && (!choice.equals("Q"))){
				System.out.println("Enter a number between 1-7 or Q");
			}

			System.out.println("*****************************************");


		}

	}
	// checks the password and and returns a string. 
	// takes  String name, String password, SocialNetwork myWorld. 
	public String checkingUsernameAndPassword(String name, String password, SocialNetwork myWorld){
		String login = "";
		 if(myWorld.getProfile(name) != null)
				 {
						 if(myWorld.getProfile(name).authenticate(name, password)){
						 	login = login + "Login of the user " + name + " was successful";
						 }
						 else
						 {
						 	login = login + "Login of the user " + name + " was not successful." + " password was wrong";
						 }
				 }
		 else{

		 	login = login + "There is no one profile named " + name + " in the system";

		 }

		 return login;
	}
	// returns a string. 
	// takes the parameter String friendName, SocialNetwork myWorld, String name. 
	public String checksTheProfileOfTheFriend(String friendName, SocialNetwork myWorld, String name){
		String login = "";
		 if(myWorld.getProfile(friendName) != null)
				 {
				 	if(myWorld.getProfile(name).addFriend(friendName, myWorld)){
				 		login = login + name +" was able to add " + friendName + " in the friend list";  
				 	}
				 	else{
				 		login=login + name +" was not able to add " + friendName + " in the friend list"; 
				 	}
						 
				 }
		 else{

		 	login = login + "There is no one profile named " + friendName + " in the system";

		 }
		 return login;

	}
}
 