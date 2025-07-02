package com.sendiy.common.util;

import java.util.regex.Pattern;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
public final class RegexUtil {
    public static boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile("(\\+998)?(90|91|93|94|77|95|99|88|97|98|55)\\d{7}");
        return pattern.matcher(phone).matches();
    }
}
