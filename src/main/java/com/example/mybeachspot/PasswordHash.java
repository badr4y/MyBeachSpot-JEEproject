package com.example.mybeachspot;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHash {
    private static final int SALT_LENGTH = 16;
    private static final int HASH_ITERATIONS = 10000;
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int HASH_LENGTH = 32;
    private static final int ITERATIONS = 10000;
    private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";


    public static String hashPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        byte[] hash = hashWithSalt(password.getBytes(), salt);

        return String.format("%s:%s", bytesToHex(salt), bytesToHex(hash));
    }

    public static boolean validatePassword(String password, String passwordHash) {
        String[] parts = passwordHash.split(":");
        byte[] salt = hexToBytes(parts[0]);
        byte[] expectedHash = hexToBytes(parts[1]);

        byte[] actualHash = hashWithSalt(password.getBytes(), salt);

        return MessageDigest.isEqual(expectedHash, actualHash);
    }

    private static byte[] hashWithSalt(byte[] data, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);

            md.reset();
            md.update(salt);

            byte[] hash = data;
            for (int i = 0; i < HASH_ITERATIONS; i++) {
                hash = md.digest(hash);
                md.reset();
                md.update(salt);
            }

            return hash;
        } catch (NoSuchAlgorithmException e) {
            // Should never happen, since SHA-256 is a standard algorithm
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static byte[] hexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            bytes[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
        }
        return bytes;
    }

    public static String createHash(String password) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        byte[] hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, HASH_LENGTH);

        return ITERATIONS + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }

    private static String toHex(byte[] array) throws Exception {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

}

