
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
			CLInputHandler.engageInput(args[1]);
		} else if(flag.equals("-o")) {
			FileInputHandler.egnageOutput(args[1]);
		} else {
			throw new IllegalArgumentException("False flag: " + args[0]);
		}
		
	}
}
