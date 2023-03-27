package com.example.userservice.Entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "/fullUser"  , types = User.class)
public interface UserProjection {

    public String getName();
    public String getEmail();
}
