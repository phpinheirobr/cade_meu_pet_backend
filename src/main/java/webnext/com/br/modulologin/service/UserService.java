package webnext.com.br.modulologin.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import webnext.com.br.modulologin.dto.LocalUser;
import webnext.com.br.modulologin.dto.SignUpRequest;
import webnext.com.br.modulologin.exception.UserAlreadyExistAuthenticationException;
import webnext.com.br.modulologin.model.User;

public interface UserService {

	public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

	User findUserByEmail(String email);

	Optional<User> findUserById(Long id);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
