package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		
	        try {
	            // We use MD5 with 128 bits digest
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            
	            // Compute the hash of the input 'entity'
	            byte[] digest = md.digest(entity.getBytes());
	            
	            // Convert the hash into hex format
	            String hex = toHex(digest);
	            
	            // Convert the hex into BigInteger
	            hashint = new BigInteger(hex, 16);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return hashint;
		
		
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		// Compute the number of bits = bitSize()
        int bits = bitSize();
        
        // Compute the address size = 2 ^ number of bits
        BigInteger size = BigInteger.valueOf(2).pow(bits);
        
        // Return the address size
        return size;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		
		
        try {
            // Find the digest length
            MessageDigest md = MessageDigest.getInstance("MD5");
            digestlen = md.getDigestLength();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digestlen * 8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}