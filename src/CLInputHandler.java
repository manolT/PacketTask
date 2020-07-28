import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CLInputHandler {

	/**
	* Handles the -i flag and the command line input. It generates packets 
	* based on the command line input and writes the to a file.
	*
	* @param  fileName	filename of the output file
	* @return void
	*/
	public static void engageCLInput(String fileName) {
		File output = new File(fileName);

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		String input = "";

		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// if the input is empty we create an empty file otherwise we continue
		if (input.isEmpty()) {
			System.out.print("Empty input..");

			try {
				output.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			String[] inputStrings = parseWords(input.toCharArray());
			ArrayList<Packet> packets = new ArrayList<Packet>();
			for (String s : inputStrings) {
				packets.add(new Packet(s));
			}
			
			exportToFile(packets, output);
		}

	}
	
	//separates the words
	private static String[] parseWords(char[] inputArr) {
		ArrayList<String> inputStrings = new ArrayList<String>();

		// Using for loop since we know how many
		// times we will loop (inputArr.length/5 + 1)
		// First loop is for each word, second for each char in the word
		for (int i = 0; i < inputArr.length;) {
			ArrayList<Character> word = new ArrayList<Character>();
			for (int j = 0; i < inputArr.length && j < 5; j++) {
				word.add(inputArr[i]);
				i++;
			}
			// list to char array
			char[] wordCharArr = new char[word.size()];
			for (int p = 0; p < word.size(); p++) {
				wordCharArr[p] = word.get(p).charValue();
			}
			// char array to string
			String wordString = String.valueOf(wordCharArr);
			inputStrings.add(wordString);

		}

		return inputStrings.toArray(new String[0]);
	}

	/*
	 * This is kept distinct from generateSignature() so the output format can 
	 * be changed without needing to touch the signature generating algorithm
	 */

	private static void exportToFile(ArrayList<Packet> packets, File outFile) {
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Packet p : packets) {
			try {
				writer.write(p.getTuple() + "|");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
