/**
 * This abstract data type represents the backend for a streaming radio service.
 * It stores the songs, stations, and users in the system, as well as the
 * ratings that users assign to songs.
 */
public interface StreamingRadio {

	/*
	 * The abstract methods below are declared as void methods with no
	 * parameters. You need to expand each declaration to specify a return type
	 * and parameters, as necessary.
	 *
	 * You also need to include a detailed comment for each abstract method describing
	 * its effect, its return value, any corner cases that the client may need to
	 * consider, any exceptions the method may throw (including a description of the
	 * circumstances under which this will happen), and so on.
	 *
	 * You should include enough details that a client could use this data structure
	 * without ever being surprised or not knowing what will happen, even though they
	 * haven't read the implementation.
	 */

	/**
	 * Adds a new song to the system.
	 * @param s the song object
	 * @throws NullPointerException when the song is null
	 */
	void addSong(Song s)throws NullPointerException;

	/**
	 * Removes an existing song from the system.
	 * if the song is not in the queue, return false
	 * @param s the song object 
	 * @throws NullPointerException when the song is null
	 * @return true if the song is not in radio, otherwise, return false
	 */
	boolean removeSong(Song s) throws NullPointerException;

	/**
	 * Adds an existing song to the playlist for an existing radio station.
	 * @param s the song object
	 * @param station the station object
	 * @throws NullPointerException when the station or the song is null
	 */
	void addToStation(Station station, Song s) throws NullPointerException;

	/**
	 * Removes a song from the playlist for a radio station.
	 * return false if the song is not in the radio
	 * @param s the song object
	 * @param station the station object
	 * @throws NullPointerException when the station or the song is null
	 * @return true if the song is not in radio, otherwise, return false
	 */
	boolean removeFromStation(Station station, Song s) throws NullPointerException;

	/**
	 * Sets a user's rating for a song, as a number of stars from 1 to 5.
	 * @param u the User object
	 * @param rating from 1 to 5
	 * @param s the Song object
	 * @throws IllegalArgumentException when the rating is not from 1  to 5
	 * @throws NullPointerException when the user or song is null
	 */
	void rateSong(User u, int rating, Song s)throws IllegalArgumentException, NullPointerException;

	/**
	 * Clears a user's rating on a song. If this user has rated this song and
	 * the rating has not already been cleared, then the rating is cleared and
	 * the state will appear as if the rating was never made. If there is no
	 * such rating on record (either because this user has not rated this song,
	 * or because the rating has already been cleared), then this method will
	 * throw an IllegalArgumentException.
	 *
	 * @param theUser user whose rating should be cleared
	 * @param theSong song from which the user's rating should be cleared
	 * @throws IllegalArgumentException if the user does not currently have a
	 * rating on record for the song
	 * @throws NullPointerException if either the user or the song is null
	 */
	public void clearRating(User theUser, Song theSong)
		throws IllegalArgumentException, NullPointerException;

	/**
	 * Predicts the rating a user will assign to a song that they have not yet
	 * rated, as a number of stars from 1 to 5.
	 * @param u the User object
	 * @param s the Song object
	 * @throws IllegalArgumentException when the users already rate the songs
	 * @throws NullPointerException when the users or song is null
	 */
	void predictRating(User u, Song s)throws IllegalArgumentException, NullPointerException;

	/**
	 * Suggests a song for a user that they are predicted to like.
	 * @param u the User object
	 * @throws NullPointerException when the user is null
	 * @return suggested song based predicted rating 
	 */
	Song suggestSong(User u) throws NullPointerException;
}