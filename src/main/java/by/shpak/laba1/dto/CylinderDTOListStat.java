package by.shpak.laba1.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CylinderDTOListStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "unique_req")
    private final int unique;
    private final double maxValue;
    private final double minValue;
    private final double average;

    public int getUnique() {
        return unique;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getAverage() {
        return average;
    }

    public CylinderDTOListStat() {
        unique = 1;
        maxValue = 1;
        minValue = 1;
        average = 1;
    }

    public void setCylinderDTOList(List<CylinderDTO> cylinderDTOList) {
        this.cylinderDTOList = cylinderDTOList;
    }

    public List<CylinderDTO> getCylinderDTOList() {
        return cylinderDTOList;
    }
    @OneToMany
    private List<CylinderDTO> cylinderDTOList;

    public CylinderDTOListStat(int unique, double maxValue, double minValue, double average, List<CylinderDTO> cylinderDTOList) {
        this.unique = unique;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.average = average;
        this.cylinderDTOList = cylinderDTOList;
    }
}
