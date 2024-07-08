package api.models.request;

import lombok.Data;

@Data
public class AuthTokenRequest {
    private String username;
    private String password;
}
