import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInputHandler {
	
	/**
	* Handles the -o flag and the file input. Checks integrity and prints the 
	* data to the console.
	*
	* @param  fileName	filename of the input file containing the packets
	* @return void
	*/
	public static void egnageFileInput(String fileName) {
		Scanner read = null;
		try {
			read = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		read.useDelimiter("\\|");
		ArrayList<String> tuples = new ArrayList<String>();
		while (read.hasNext()) {
			String in = read.next();
			tuples.add(in);
		}

		ArrayList<Packet> packets = parsePackets(tuples);

		for (Packet p : packets) {
			System.out.print(p.getData());
		}

	}
	//returns an arrayList containing all the packets from the file
	private static ArrayList<Packet> parsePackets(ArrayList<String> tuples) {
		ArrayList<Packet> packets = new ArrayList<Packet>();
		for (String t : tuples) {
			String[] splitTuple = t.split(";");
			if (splitTuple.length != 3) {
				throw new IllegalArgumentException(
						"Integrity compromised; incorrect number of data points in tuple");
			}
			int length = 0;
			try {
				length = Integer.parseInt(splitTuple[0]);
			} catch (NumberFormatException e) {
				System.out.println("Cannot parse length");
				e.printStackTrace();
			}
			// creating the packet successfuly means it's not compromised
			// since the checks are baked in the Packet class
			try {
				packets.add(new Packet(length, splitTuple[1], splitTuple[2]));
			} catch(IllegalArgumentException e) {
				System.out.println("Integrity Compromised");
				e.printStackTrace();
			}
		}
		return packets;
	}

}
