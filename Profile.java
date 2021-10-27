/*
 * Class Profile - represents a profile of a person on the social network. 
 * Contains the name, the password (note: this is a toy project, otherwise no one stores passwords in plain text!),
 * a list of friends, and a list of posts of this person.
 */

import java.util.*;
import java.io.*;

public class Profile {
	// TODO: Create instance variables: name, password, friends and posts.
	// Store friends and posts in ArrayList-s
	private String name;
	private String password;
	private ArrayList<String> friends;
	private ArrayList<Post> posts;


	/**
	 * Constructor for class Profile
	 * @param name The name of the user
	 * @param password The password of the user
	 */
	public Profile(String name, String password) {
		// FILL IN CODE: assign values to this.name and this.password
		// Initialize friends and posts ArrayList-s
		this.name = name;
		this.password = password;
		friends = new ArrayList<>();
		posts = new ArrayList<>();
		
	}

	/* adds friend to the arraylist of the friends*/
	public void startingFriends(String friendName){
		friends.add(friendName);
	}


	
	//retruns the name of the profile
	public String getName(){
		return name;
	}

	/** 
	 * Used to login the user.
	 * @param name The name of the user
	 * @param password The password entered by the user
	 * @return true if the name and the password match what is stored for this object, and false otherwise
	 * 
	 */
	public boolean authenticate(String name, String password) {
		
		// FILL IN CODe
		//System.out.println(password);


		return this.password.equals(password) && this.name.equals(name);
	}

	// FILL IN CODE: Add other getters as needed

	/**
	 * Creates a post with the given name and message and adds it to the ArrayList of posts
	 * @param name
	 * @param message
	 */
	public void addPost(String name, String message) {
		// FILL IN CODE
		posts.add(new Post(name, message));
		
	}


	/**
	 * Getter for the posts.
	 * @return ArrayList of posts (a copy of the list of posts of this user)
	 */
	public ArrayList<Post> getPosts() { // sorted by time, most recent first
		ArrayList<Post> copyOfPosts = new ArrayList<>();
		// FILL IN CODE
		for(int i = 0; i < posts.size(); i++){
			Post p = posts.get(i);
			Post copyOfP = new Post(p.getName(), p.getMessage(), p.getTime());
			copyOfPosts.add(copyOfP);
		}
		Collections.sort(copyOfPosts);

		return copyOfPosts;
	}

	// returns a copy of friends post and more recent ones first

	public ArrayList<Post> newFeeds(SocialNetwork sn){
		ArrayList<Post> copyOfFriendPosts = new ArrayList<>();
		ArrayList<Post> tempHoldsArrayList = new ArrayList<>();
		for(int i = 0; i < friends.size(); i++)
		{
			Profile frindProfile = sn.getProfile(friends.get(i));
			 tempHoldsArrayList = frindProfile.getPosts();
			 for(Post p : tempHoldsArrayList)
			 	copyOfFriendPosts.add(p);
		}

		Collections.sort(copyOfFriendPosts);

		


		return copyOfFriendPosts;


	}

	/**
	 * This method adds newFriend to the list of friends of "this" user. 
	 * It also adds "this" user's name to the list of friends for the newFriend.
	 * @return true if the friend's name was not in the list of friends earlier
	 * and was successfully added to the list.
	 * Returns false if the friend was already in the list of friends for
	 * this profile (in which case, the newFriend is not added to the
	 * list of friends the second time.)
	 */
	public boolean addFriend(String newFriend, SocialNetwork sn) {
		// FILL IN CODE
		if(!friends.contains(newFriend)){
			this.friends.add(newFriend);
			sn.getProfile(newFriend).friends.add(name);
			return true;
		}

		else{
			return false;
		}
		  // change as needed
	}


	/**
	 * Getter for the friends.
	 * @return a copy of the ArrayList of the names of friends
	 */
	public ArrayList<String> getFriends() {
		ArrayList<String> copyOfFriends = new ArrayList<>();
		// FILL IN CODE
		for(String nameOfFriend : friends){
			copyOfFriends.add(nameOfFriend);
		}

		return copyOfFriends;
	}

	
	/* @return returns a string representation of the user profile (name, posts, friends). Example:

	   Name: Helen

	   Posts:	
	   Going to Santa Cruz now, so excited (posted on 13-10-2021 11:35)
	   Hi all, what's new? (posted on 12-10-2021 09:20)

	   Friends: Jenny, Cody, Pablo,
	 
	 */
	public String toString() {
		// Use a StringBuilder, append all info to the StringBuilder, then call
		// sb.toString() to return a string
		StringBuilder sb = new StringBuilder();
		String buildName = "Name:"+ name + System.lineSeparator() + System.lineSeparator();
		sb.append(buildName);
		String buildPost = "Post:" + System.lineSeparator();
		String addPostString = "";
		for(Post p : getPosts()){
			addPostString = addPostString + p.toString() +System.lineSeparator();

		}
		buildPost = buildPost + addPostString + System.lineSeparator();
		sb.append(buildPost);
		String stringOfFriends = "";
		for(String f : friends){
			stringOfFriends = stringOfFriends + f + ", ";
		}
		sb.append("Friends:" + stringOfFriends);
		// FILL IN CODE
		
		
		return sb.toString();
	}
	
	// FILL IN CODE: Feel free to add some helper methods as needed

	/*
	 * Write information about this profile (name, posts, friends) to the file with the given filename.
	 * Here is the example of what is expected:
	 
	 Name: Helen

	 Posts:	
	 Going to Santa Cruz now, so excited (posted on 13-10-2021 11:35)
	 Hi all, what's new? (posted on 12-10-2021 09:20)

	 Friends: Jenny, Cody, Pablo,
	 
	 * @param filename
	 */
	public void writeProfileToFile(String filename) {
		// FILL IN CODE
		// Hint: use toString method to get the String representation of this profile
		try( PrintWriter writer = new PrintWriter(filename) ){

			String line = toString();
			writer.println(line);
			writer.flush();

		}
		catch(IOException e){
			System.out.println(e);
		}
		System.out.println("Successfully put on the file");

	}
}