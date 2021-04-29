package by.shpak.laba1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VolumeDTO {
    @Id
    private Long id;

    private final double volume;

    public VolumeDTO() {
        volume = 1;
    }

    public VolumeDTO(Long id, double volume) {
        this.id = id;
        this.volume = volume;
    }

    public Long getId() {
        return id;
    }

    public double getVolume() {
        return volume;
    }
}
