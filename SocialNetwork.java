/*
 * Class SocialNetwork - keeps track of the profiles of all users.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SocialNetwork {

	private ArrayList<Profile> profiles; // User profiles are stored in the ArrayList

	/**
	 * Constructor for SocialNetwork
	 */
	public SocialNetwork() {
		profiles = new ArrayList<>(); // initializing the profiles ArrayList
	}

	/** 
	 * Reads the file with information about user profiles, creates Profile objects, and adds them to the ArrayList profiles
	 * @param filename Name of the file 
	 */
	public void readProfiles(String filename) {
		// FILL IN CODE: read profiles from the file
		// You are required to use the BufferedReader for this method


	}



	/**
	 * This method  iterates over profiles and returns the profile associated with the given name. 
	 * If there is no profile with this name, the method returns null.
	 * @param name
	 * @return profile for the user with this name
	 */
	public Profile getProfile(String name) {
		// FILL IN CODE

		return null;
	}

}
