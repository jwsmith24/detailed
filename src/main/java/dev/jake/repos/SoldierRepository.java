package dev.jake.repos;

import dev.jake.entities.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier, Long> {


}
