package by.shpak.laba1.service;

import by.shpak.laba1.dto.QueryContainer;
import by.shpak.laba1.dto.VolumeDTO;
import by.shpak.laba1.exceptions.AlreadyTakenIdException;
import by.shpak.laba1.exceptions.NegativeParameterException;
import by.shpak.laba1.repos.CylinderDTOListStatRepository;
import by.shpak.laba1.repos.VolumeDTORepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CylinderServiceAsync {

    private static Logger logger = Logger.getLogger(CylinderServiceAsync.class);
    @Autowired
    private CylinderService cylinderService;

    @Autowired
    private VolumeDTORepository volumeDTORepository;

    @Autowired
    private CylinderServiceStreamAPI cylinderServiceStreamAPI;

    @Autowired
    CylinderDTOListStatRepository cylinderDTOListStatRepository;

    public void calculateAsync(Long id, QueryContainer queryContainer) throws NegativeParameterException, AlreadyTakenIdException {
        if(volumeDTORepository.existsById(id)) throw new AlreadyTakenIdException();
        if(queryContainer.getRadius() < 0 || queryContainer.getHeight() < 0 || id < 0) throw new NegativeParameterException();
        logger.info("Starting new thread");
        CompletableFuture.supplyAsync(()->cylinderService.calculateVolume(queryContainer))
                .thenAccept(x->volumeDTORepository.save(new VolumeDTO(id,x.getVolume())));
    }

    public void calculateListAsync(Long id, List<QueryContainer> queryContainerList) throws AlreadyTakenIdException {
        if(cylinderDTOListStatRepository.existsById(id)) throw new AlreadyTakenIdException();
        CompletableFuture.supplyAsync(()->cylinderServiceStreamAPI
                .CalculateVolumeListStat(queryContainerList))
                .thenAccept((x)->{
                    x.setId(id);
                    cylinderDTOListStatRepository.save((x));
                });
    }
}
