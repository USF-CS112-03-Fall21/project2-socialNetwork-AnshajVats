import java.util.*;

/* The Driver class for project 2. Also a class that allows the user to interact with social network. */

public class InteractiveSession {
	
	public static void main(String[] args) {

		SocialNetwork myWorld = new SocialNetwork();
		myWorld.readProfiles(args[0]); // we assume the name of the file with profiles is passed as a command line argument to the main method
		// To call the program, run 
		// java InteractiveSession profiles.csv
		if(myWorld.getProfile("Pablo") != null)
		{
			System.out.println(myWorld.getProfile("Helen").getFriends());
		}
		else
			System.out.println("profile not found");
		
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
		int count =0;
		String name="";
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

				count++;		
			}
			else if(choice.equals("2") && count != 0){
				System.out.println("Enter the name of the friend you want to add");
				String friendName=sc.nextLine();
				System.out.println(checksTheProfileOfTheFriend(friendName, myWorld, name));

			}
			

			else if(choice.equals("3") && count != 0){
				System.out.println(myWorld.getProfile(name).getFriends());
			}
			else if(choice.equals("4") && count != 0){
				System.out.println("Enter your post");
				String message = sc.nextLine();
				myWorld.getProfile(name).addPost(name, message);
			}
			else if(choice.equals("5") && count != 0){

				for(Post s : myWorld.getProfile(name).getPosts())
					System.out.println(s);
			}
			else if(choice.equals("6") && count != 0){

				for(Post s : myWorld.getProfile(name).newFeeds(myWorld))
					System.out.println(s);
				System.out.println(myWorld.getProfile(name));
			}
			else {
				System.out.println("You have to log in first and only type number between [1,7]");
			}

			System.out.println("*****************************************");


		}

	}
	public String checkingUsernameAndPassword(String name, String password, SocialNetwork myWorld){
		String login="";
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
	public String checksTheProfileOfTheFriend(String friendName, SocialNetwork myWorld, String name){
		String login="";
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
