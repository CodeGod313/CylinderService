package by.shpak.laba1.cache;

import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.QueryContainer;
import by.shpak.laba1.repos.CylinderDTORepository;
import by.shpak.laba1.repos.QueryContainerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {

    private static QueryContainerRepository queryContainerRepository;
    private static CylinderDTORepository cylinderDTORepository;

    @Autowired
    QueryContainerRepository queryContainerRepositoryAuto;
    @Autowired
    CylinderDTORepository cylinderDTORepositoryAuto;

    private static final Map<QueryContainer, CylinderDTO> cache = new HashMap<>();
    private static final Logger logger = Logger.getLogger(Cache.class);


    @PostConstruct
    private void init() {
        this.queryContainerRepository = queryContainerRepositoryAuto;
        this.cylinderDTORepository = cylinderDTORepositoryAuto;
    }

    @PostConstruct
    private void initCache(){
        long counter = (long) 1;
        while (queryContainerRepository.existsById(counter++)) {
            System.out.print(counter -1);
            cache.put(queryContainerRepository.findById(counter - 1).get(), cylinderDTORepository.findById(counter - 1).get());
        }
    }

    public static CylinderDTO getFromCache(QueryContainer key){
        logger.info("getting value from cache");
        return cache.get(key);
    }

    public static void putInCache(QueryContainer key, CylinderDTO value){
        logger.info("putting calculated value in cache");
        cache.put(key,value);
        queryContainerRepository.save(key);
        cylinderDTORepository.save(value);
    }
}
