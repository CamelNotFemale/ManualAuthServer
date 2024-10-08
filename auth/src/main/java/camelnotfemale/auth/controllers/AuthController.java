package camelnotfemale.auth.controllers;

import camelnotfemale.auth.data.ClientService;
import camelnotfemale.auth.data.TokenService;
import camelnotfemale.auth.entities.ErrorResponse;
import camelnotfemale.auth.entities.TokenResponse;
import camelnotfemale.auth.entities.User;
import camelnotfemale.auth.utils.RegistrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ClientService clientService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) {
        clientService.register(user.getClientId(), user.getClientSecret());
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody User user) {
        clientService.checkCredentials(
            user.getClientId(), user.getClientSecret());
        return new TokenResponse(
            tokenService.generateToken(user.getClientId()));
    }

    @ExceptionHandler({RegistrationException.class, LoginException.class})
    public ResponseEntity<ErrorResponse> handleUserRegistrationException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }
}