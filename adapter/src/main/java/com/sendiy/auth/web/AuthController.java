package com.sendiy.auth.web;

import com.sendiy.common.util.PathNames;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: ahror
 *
 * <p>since: 03/10/2024
 */
@RestController
@RequestMapping(PathNames.AUTH_V1)
@RequiredArgsConstructor
@SecurityRequirements
public class AuthController {

}
