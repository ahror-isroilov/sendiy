package com.sendiy.user.port.out;

import com.sendiy.user.model.User;

import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
public interface UserCreatePort {
  UUID create(User domain);
}
