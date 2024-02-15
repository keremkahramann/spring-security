package com.security.BasicAuth.dto;

import com.security.BasicAuth.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest (
        String name,
        String username,
        String password,
        Set<Role> authorities)
{
}
