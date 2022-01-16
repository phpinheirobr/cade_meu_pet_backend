package br.com.webnext.modulologin.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import br.com.webnext.modulologin.dto.LocalUser;
import br.com.webnext.modulologin.dto.SignUpRequest;
import br.com.webnext.modulologin.exception.UserAlreadyExistAuthenticationException;
import br.com.webnext.modulologin.model.User;

public interface UserService {

	public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

	User findUserByEmail(String email);

	Optional<User> findUserById(Long id);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
