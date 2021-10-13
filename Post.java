/** A class representing a post made by a user on social media */

import java.util.Calendar; // Used to assign the time to the post
import java.text.SimpleDateFormat; // Used for formatting the time of the post

public class Post implements Comparable<Post> { // Implements Comparable so that we can compare posts by time
	private String name; // the name of the user who created the post
	private String message; // the text of the post
	private Long time; // the time when the post was created


	/** Constructor of class Post.
	 * @param name The name of the user who created this post
	 * @param message The text of the post
	 */
	public Post(String name, String message) {
		// FILL IN CODE
		// Assign values to this.name and this.message

		// Record the current time and assign to this.time:
		// First, create an instance of Calendar using Calendar.getInstance();
		// Then, call getTimeInMillis() method from class Calendar to get the current time

	}

	/** Another constructor of class Post that takes three parameters.
	 * @param name The name of the user who created this post
	 * @param message The text of the post
	 * @param time The time the post was created
	 */
	public Post(String name, String message, long time) {
		// FILL IN CODE	
		
		
	}

	// Add getters as needed

	public int compareTo(Post o) {
		// FILL IN CODE
		// Compare posts based on the time. More recent post should be "less than" an older post.


		return 0; // change it as needed
	}

	public String toString() {
		String s = "";
		// FILL IN CODE to return name, time and the message on the next line.
		

		return s;

	}
}