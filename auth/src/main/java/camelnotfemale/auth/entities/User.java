package camelnotfemale.auth.entities;

import lombok.Value;

@Value
public class User {
    String clientId;
    String clientSecret;
}