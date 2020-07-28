import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Utilities {

	/**
	* Generates a signature based on a string that is its MD5 encoding and then
	* Base64 encoding.
	*
	* @param  word the string that will be processed
	* @return      the signature of the string
	*/
	public static String generateSignature(String word) {
		String signature = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	
		byte[] md5Bytes = md.digest(word.getBytes());
		signature = Base64.getEncoder().encodeToString(md5Bytes);
	
		return signature;
	}

	

}
