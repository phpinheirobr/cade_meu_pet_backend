package webnext.com.br.modulologin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import webnext.com.br.modulologin.dto.LocalUser;
import webnext.com.br.modulologin.dto.SocialProvider;
import webnext.com.br.modulologin.dto.UserInfo;
import webnext.com.br.modulologin.model.Role;
import webnext.com.br.modulologin.model.User;

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
