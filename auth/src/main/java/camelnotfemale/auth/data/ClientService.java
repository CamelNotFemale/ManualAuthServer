package camelnotfemale.auth.data;

import javax.security.auth.login.LoginException;

public interface ClientService {
    void register(String clientId, String clientSecret);
    void checkCredentials(String clientId, String clientSecret);
}