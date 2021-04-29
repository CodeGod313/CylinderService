package by.shpak.laba1.Controllers.rest;

import by.shpak.laba1.counter.Counter;
import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.CylinderDTOListStat;
import by.shpak.laba1.dto.QueryContainer;
import by.shpak.laba1.dto.VolumeDTO;
import by.shpak.laba1.exceptions.AlreadyTakenIdException;
import by.shpak.laba1.exceptions.NegativeParameterException;
import by.shpak.laba1.exceptions.WrongIdException;
import by.shpak.laba1.repos.CylinderDTOListStatRepository;
import by.shpak.laba1.repos.VolumeDTORepository;
import by.shpak.laba1.service.CylinderService;
import by.shpak.laba1.service.CylinderServiceAsync;
import by.shpak.laba1.service.CylinderServiceStreamAPI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cylinderValue")
public class CylinderController {
    @Autowired
    CylinderService cylinderService;

    @Autowired
    CylinderServiceStreamAPI cylinderServiceStreamAPI;

    @Autowired
    CylinderServiceAsync cylinderServiceAsync;

    @Autowired
    VolumeDTORepository volumeDTORepository;

    @Autowired
    CylinderDTOListStatRepository cylinderDTOListStatRepository;


    private static final Logger logger = Logger.getLogger(CylinderController.class);
    //Get
    @GetMapping("/count")
    public CylinderDTO calculateCylinderVolume(@RequestParam(value = "height") double height,
                                               @RequestParam(value = "radius") double radius)
            throws NegativeParameterException {
        if (radius <= 0 || height <= 0) throw new NegativeParameterException();
        QueryContainer queryContainer = new QueryContainer(radius, height);
        Counter.inc();
        logger.info("return GTO");
        return cylinderService.calculateVolume(queryContainer);
    }

    //Post
    @PostMapping("/countViaJSONList")
    public List<CylinderDTO> calculateCylinderVolumeBulk(@RequestBody  List<QueryContainer> queryContainerList){
        Counter.inc();
        return cylinderServiceStreamAPI.CalculateVolumeList(queryContainerList);
    }

    @PostMapping("/countViaJSONListAsync")
    public void calculateCylinderVolumeBulkAsync(@RequestBody  List<QueryContainer> queryContainerList,
                                                 @RequestParam(value = "id") Long id) throws AlreadyTakenIdException {
        Counter.inc();
        cylinderServiceAsync.calculateListAsync(id, queryContainerList);
    }

    @PostMapping("/countViaJSONListStat")
    public CylinderDTOListStat calculateCylinderVolumeBulkStat(@RequestBody List<QueryContainer> queryContainerList){
        Counter.inc();
        return cylinderServiceStreamAPI.CalculateVolumeListStat(queryContainerList);
    }

    //Async
    @GetMapping("/countAsync")
    public void calculateVolumeAsync(@RequestParam(value = "height") double height,
                                     @RequestParam(value = "radius") double radius,
                                     @RequestParam(value = "id") Long id) throws AlreadyTakenIdException, NegativeParameterException {
        Counter.inc();
        cylinderServiceAsync.calculateAsync(id, new QueryContainer(radius, height));
    }

    @GetMapping("/getVolumeById")
    public VolumeDTO getVolumeById(@RequestParam(value = "id") Long id) throws WrongIdException {
        Counter.inc();
        if(volumeDTORepository.existsById(id))
            return volumeDTORepository.findById(id).get();
        else throw new WrongIdException();
    }

    @GetMapping("/getVolumeListById")
    public CylinderDTOListStat getVolumeByIdList(@RequestParam(value = "id") Long id) throws WrongIdException {
        Counter.inc();
        if(!cylinderDTOListStatRepository.existsById(id)) throw new WrongIdException();
        return cylinderDTOListStatRepository.findById(id).get();
    }

}
