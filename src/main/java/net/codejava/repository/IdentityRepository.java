package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.codejava.model.Identity;

public interface IdentityRepository extends JpaRepository<Identity, Long> {
}
