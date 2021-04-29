package by.shpak.laba1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CylinderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final double radius;
    private final double height;
    private final double volume;

    public CylinderDTO(double radius, double height, double volume) {
        this.radius = radius;
        this.height = height;
        this.volume = volume;
    }

    public CylinderDTO() {
        radius = 1;
        height = 1;
        volume = 1;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return volume;
    }
}
