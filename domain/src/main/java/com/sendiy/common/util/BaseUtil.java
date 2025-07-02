package com.sendiy.common.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * author: ahror
 <p>
 * since: 28/10/2024
 */
public final class BaseUtil {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();
    private static final SecureRandom secureRandom = new SecureRandom();
    public static String generateOtp() {
        return "" + (11111 + random.nextInt(99999 - 11111 + 1));
    }

    public static String formatPhone(String phone) {
        phone = (phone != null && phone.length() > 9) ? phone.substring(phone.length() - 9) : phone;
        return phone;
    }

    public static String genRandomString(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be positive.");
        long nanos = System.nanoTime();
        StringBuilder result = new StringBuilder(Long.toHexString(nanos));
        if (result.length() < length) {
            while (result.length() < length) {
                int index = random.nextInt(CHARACTERS.length());
                result.append(CHARACTERS.charAt(index));
            }
        } else if (result.length() > length) {
            result.setLength(length);
        }
        return result.toString();
    }
}
