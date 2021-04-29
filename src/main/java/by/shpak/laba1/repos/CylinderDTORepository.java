package by.shpak.laba1.repos;

import by.shpak.laba1.dto.CylinderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CylinderDTORepository extends JpaRepository<CylinderDTO, Long> {
}
