package by.shpak.laba1.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class QueryContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final double radius;
    private final double height;

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public QueryContainer(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public QueryContainer() {
        radius = 1;
        height = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryContainer that = (QueryContainer) o;
        return radius == that.radius && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, height);
    }
}
