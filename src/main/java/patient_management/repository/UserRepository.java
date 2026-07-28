package patient_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patient_management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
