import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Utilities {

	static String generateSignature(String word) {
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
