import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.QueryContainer;
import by.shpak.laba1.service.CylinderService;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;

public class TestCylinderVolume {
    @Test
    public void testVolume() throws Exception{
        CylinderService cylinder = new CylinderService();
        CylinderDTO cylinderDTO = cylinder.calculateVolume(new QueryContainer(1,1));
        Assert.assertEquals(3.14, cylinderDTO.getVolume(), 0.0001);
    }
}
