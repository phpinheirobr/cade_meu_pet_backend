package webnext.com.br.modulologin.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import webnext.com.br.modulologin.dto.SignUpRequest;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, SignUpRequest> {

	@Override
	public boolean isValid(final SignUpRequest user, final ConstraintValidatorContext context) {
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
