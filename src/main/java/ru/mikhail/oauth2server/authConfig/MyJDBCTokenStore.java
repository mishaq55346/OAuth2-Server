package ru.mikhail.oauth2server.authConfig;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

public class MyJDBCTokenStore extends JdbcTokenStore {
    public MyJDBCTokenStore(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        OAuth2AccessToken accessToken = null;

        try {
            accessToken = new DefaultOAuth2AccessToken(tokenValue);
        }
        catch (EmptyResultDataAccessException e) {
            System.err.println("Failed to find access token for token "+tokenValue);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Failed to deserialize access token for " +tokenValue);
            System.err.println(e.getLocalizedMessage());
            removeAccessToken(tokenValue);
        }
        return accessToken;
    }


}
