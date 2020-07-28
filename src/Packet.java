public class Packet {
	
	private String data;
	private int length;
	private String signature;

	
	
	public Packet(String data) {
		this.data = data;
		this.length = data.length();
		this.signature = Utilities.generateSignature(data);
	}

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
	
	public String getTuple() {
		return length + ";" + data + ";" + signature;
	}
	
	public String getData() {
		return data;
	}

	public int getLength() {
		return length;
	}

	public String getSignature() {
		return signature;
	}
}
