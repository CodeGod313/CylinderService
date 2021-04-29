package by.shpak.laba1.repos;

import by.shpak.laba1.dto.QueryContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryContainerRepository extends JpaRepository<QueryContainer, Long> {
}
