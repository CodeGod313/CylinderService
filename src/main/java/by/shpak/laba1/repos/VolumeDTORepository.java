package by.shpak.laba1.repos;

import by.shpak.laba1.dto.VolumeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeDTORepository extends JpaRepository<VolumeDTO, Long> {
}
