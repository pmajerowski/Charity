package pl.coderslab.charity.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("select u from AppUser u where u.email=?1")
    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findWithRolesByEmail(String email);
}
