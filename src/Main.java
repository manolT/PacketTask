

/**
* This implements a command line program for managing the serializaon and 
* deserializaon of data packets, using MD5 hashing and Base64 encoding
*
* @author  Manol Tonchev
* @version 1.0
* @since   28/01/2020
*/
public class Main {
	/**
	* Main method, only reads the flag and checks the arguments are correct.
	*
	* @param  args console arguments
	* @return void
	*/
	public static void main (String[] args) {
		//checks if the correct number of arguments is passed
		if(args.length !=  2) {
			throw new IllegalArgumentException(args.toString());
		}
		
		String flag = args[0];
		if(flag.equals("-i")) {
			CLInputHandler.engageCLInput(args[1]);
		} else if(flag.equals("-o")) {
			FileInputHandler.egnageFileInput(args[1]);
		} else {
			throw new IllegalArgumentException("False flag: " + args[0]);
		}
		
	}
}
