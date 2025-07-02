package com.sendiy.common.config.security;

import com.sendiy.auth.model.MyUserDetails;
import com.sendiy.user.dto.UserWithRole;
import com.sendiy.user.port.out.UserGetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * author: ahror
 * <p>
 * since: 8/28/24 5:27 PM
 */
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserGetPort userGetPort;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        UserWithRole user = userGetPort.getWithRole(phone);
        return createUser(user);
    }

    public MyUserDetails createUser(UserWithRole user) {
        return new MyUserDetails(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getPasswordHash(),
                user.getPhone(),
                user.getRole()
        );
    }
}
