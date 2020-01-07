package springtest.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import springtest.service.ApiService;

import java.util.Optional;

public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    ApiService api;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
         //Nothing to do here
    }


    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        final Object token = usernamePasswordAuthenticationToken.getCredentials();
        return Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(api::findByToken)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
    }
}
