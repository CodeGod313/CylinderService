package by.shpak.laba1.service;

import by.shpak.laba1.cache.Cache;
import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.CylinderDTOListStat;
import by.shpak.laba1.dto.QueryContainer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CylinderServiceStreamAPI {

    @Autowired
    CylinderService cylinderService;

    public List<CylinderDTO> CalculateVolumeList(@NotNull List<QueryContainer> queryContainerList){
        return queryContainerList
                .stream()
                .map(x->cylinderService.calculateVolume(x))
                .collect(Collectors.toList());
    }

    public CylinderDTOListStat CalculateVolumeListStat(List<QueryContainer> queryContainerList){
        List<CylinderDTO> outList = CalculateVolumeList(queryContainerList);
        int unique = new HashSet<>(queryContainerList)
                .size();
        double max = outList
                .stream()
                .max(Comparator.comparingDouble(CylinderDTO::getVolume))
                .get()
                .getVolume();
        double min = outList
                .stream()
                .min(Comparator.comparingDouble(CylinderDTO::getVolume))
                .get()
                .getVolume();
        double average = outList
                .stream()
                .mapToDouble(CylinderDTO::getVolume)
                .average()
                .getAsDouble();
        return new CylinderDTOListStat(unique, max, min, average, outList);
    }
}
