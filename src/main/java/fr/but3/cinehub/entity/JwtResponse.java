package fr.but3.cinehub.entity;

/**
 * This class represents a JSON Web Token (JWT) response.
 * <p>
 * It is used to encapsulate the JWT returned upon successful authentication.
 * </p>
 */
public class JwtResponse {
    /**
     * The JWT.
     */
    private String token;

    /**
     * Constructs a new JwtResponse with the specified JWT.
     *
     * @param token the JWT
     */
    public JwtResponse(String token) {
        this.token = token;
    }

    /**
     * Returns the JWT.
     *
     * @return the JWT
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the JWT.
     *
     * @param token the new JWT
     */
    public void setToken(String token) {
        this.token = token;
    }
}