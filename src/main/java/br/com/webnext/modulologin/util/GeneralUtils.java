package br.com.webnext.modulologin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.webnext.modulologin.dto.LocalUser;
import br.com.webnext.modulologin.dto.SocialProvider;
import br.com.webnext.modulologin.dto.UserInfo;
import br.com.webnext.modulologin.model.Role;
import br.com.webnext.modulologin.model.User;

public class GeneralUtils {

	
	public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final List<Role> roles) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	public static SocialProvider toSocialProvider(String providerId) {
		for (SocialProvider socialProvider : SocialProvider.values()) {
			if (socialProvider.getProviderType().equals(providerId)) {
				return socialProvider;
			}
		}
		return SocialProvider.LOCAL;
	}

	public static UserInfo buildUserInfo(LocalUser localUser) {
		List<String> roles = localUser.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
		User user = localUser.getUser();
		return new UserInfo(user.getId().toString(), user.getDisplayName(), user.getEmail(), roles);
	}
}
