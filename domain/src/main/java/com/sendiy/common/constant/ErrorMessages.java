package com.sendiy.common.constant;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
public interface ErrorMessages {
    // Not found exceptions
    String USER_NOT_FOUND = "User not found";
    String ROLE_NOT_FOUND = "Role not found";
    String REFRESH_TOKEN_NOT_FOUND = "Refresh token not found";

    // Bad request exceptions
    String INVALID_PHONE_NUMBER = "Invalid phone number";
    String USER_ALREADY_EXISTS = "user already exists";
    String DATA_INSERTION_ERROR = "Exception thrown while inserting new data";
    String INCORRECT_PASSWORD = "Incorrect password";
    String INVALID_OTP = "Invalid otp";
    String MISSING_FIELDS = "Missing fields";
    String EXPIRED_OTP = "Otp code has expired";

    // Not acceptable exceptions
    String USER_BLOCKED = "User blocked";
    String USER_DISABLED = "User disabled";
    String PASSWORD_ALREADY_SET = "Password already set";
    String PASSWORDS_DIDNT_MATCH = "Passwords did not match";
    String SET_PASSWORD_FIRST = "Password didn't set yet. Please set password first";
    String OLD_PASSWORD_IS_INCORRECT = "Old password is incorrect!";
    String FILE_NOT_FOUND = "File not found";
}
