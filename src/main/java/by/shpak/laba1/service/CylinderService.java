package by.shpak.laba1.service;

import by.shpak.laba1.cache.Cache;
import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.QueryContainer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CylinderService {
    private static final Logger logger = Logger.getLogger(CylinderService.class);
    public CylinderDTO calculateVolume(QueryContainer queryContainer) {
        if(Cache.getFromCache(queryContainer) != null){
            return Cache.getFromCache(queryContainer);
        }
        logger.info("calculating cylinder's value");
        return new CylinderDTO(queryContainer.getRadius(), queryContainer.getHeight(), Math.PI*Math.pow(queryContainer.getRadius(),2)*queryContainer.getHeight());
    }
}
