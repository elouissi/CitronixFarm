package com.elouissi.sitronix.service;

import com.elouissi.sitronix.web.rest.controller.auth.AuthenticateRequest;
import com.elouissi.sitronix.web.rest.controller.auth.AuthenticationResponse;
import com.elouissi.sitronix.web.rest.controller.auth.RegisterRequest;

public interface AuthenticationInterface {
    AuthenticationResponse authenticate(AuthenticateRequest request);

    AuthenticationResponse register(RegisterRequest request);
}
