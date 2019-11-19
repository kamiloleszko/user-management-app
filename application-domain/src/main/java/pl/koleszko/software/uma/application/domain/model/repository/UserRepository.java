package pl.koleszko.software.uma.application.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koleszko.software.uma.application.domain.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}