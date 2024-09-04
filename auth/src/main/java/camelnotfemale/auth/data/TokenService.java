package camelnotfemale.auth.data;

public interface TokenService {
    String generateToken(String clientId);
}