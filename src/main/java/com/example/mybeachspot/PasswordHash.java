package com.example.mybeachspot;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHash {

    private static final int SALT_LENGTH = 16;
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int HASH_ITERATIONS = 10000;

    public static String createHash(String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            md.update(salt);

            byte[] hash = md.digest(password.getBytes());
            for (int i = 0; i < HASH_ITERATIONS - 1; i++) {
                md.reset();
                hash = md.digest(hash);
            }

            return String.format("%s:%s:%s", HASH_ALGORITHM, toHexString(salt), toHexString(hash));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error creating password hash", e);
        }
    }

    public static boolean validatePassword(String password, String correctHash) {
        try {
            String[] parts = correctHash.split(":");
            String algorithm = parts[0];
            byte[] salt = fromHexString(parts[1]);
            byte[] hash = fromHexString(parts[2]);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);

            byte[] testHash = md.digest(password.getBytes());
            for (int i = 0; i < HASH_ITERATIONS - 1; i++) {
                md.reset();
                testHash = md.digest(testHash);
            }

            return MessageDigest.isEqual(hash, testHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error validating password", e);
        }
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    private static byte[] fromHexString(String hexString) {
        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hexString.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

}