package webnext.com.br.modulologin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import webnext.com.br.modulologin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 Optional<User> findByEmail(String email);

	    Boolean existsByEmail(String email);
}
