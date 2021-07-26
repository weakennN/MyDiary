package Common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashGenerator {

    public static String generateHash(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashbytes = digest.digest(
                    str.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashbytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
