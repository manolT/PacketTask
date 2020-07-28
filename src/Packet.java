/**
* This implements a Packet object representing a Packet containing data, length
* and a signature.
*
* @author  Manol Tonchev
* @version 1.0
* @since   28/01/2020
*/
public class Packet {
	
	private String data;
	private int length;
	private String signature;

	
	/**
	   * Creates a packet based on data for the purpose of exporting it.
	   * @param 	data 	the contents of the packet
	   * @return  	void
	   */
	public Packet(String data) {
		this.data = data;
		this.length = data.length();
		this.signature = Utilities.generateSignature(data);
	}

	/**
	   * Creates a packet based on data, length and singature, while checking 
	   * their integrity.
	   * 
	   * @param 	data 		the contents of the packet
	   * @param 	length 		the contents of the packet
	   * @param 	signature 	the contents of the packet
	   * @return  	void
	   */
	public Packet(int length, String data, String signature) {
		if (length != data.length()) {
			throw new IllegalArgumentException(
					"Integrity compromised in packet with data: " + data);
			
		} else if (!Utilities.generateSignature(data).equals(signature)) {
			throw new IllegalArgumentException(
					"Integrity compromised in packet with data: " + data);
			
		} else {
			this.data = data;
			this.length = length;
			this.signature = signature;
		}
	}
	/**
	   * Returns the packet in tuple form for export.
	   * 
	   * @return  	a string that represents the packet
	   */
	public String getTuple() {
		return length + ";" + data + ";" + signature;
	}
	
	/**
	   * Returns the data of the packet.
	   * 
	   * @return  	a string that is the data of the packet
	   */
	public String getData() {
		return data;
	}

	/**
	   * Returns the length of the packet.
	   * 
	   * @return  	an int that is the length of the data
	   */
	public int getLength() {
		return length;
	}

	/**
	   * Returns the signature of the packet.
	   * 
	   * @return  	a string that is the signature of the packet
	   */
	public String getSignature() {
		return signature;
	}
}
