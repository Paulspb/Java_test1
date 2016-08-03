package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by khomep on 31-Jul-16.
 */
public class GeoIpSeviceTests {

    @Test
    public void  testMyIp() {
                        //soap12 - other protocol version
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("78.25.121.47");
        assertEquals(geoIP.getCountryCode(), "RUS");

        GeoIP geoIP2 = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("94.100.185.72");
        assertEquals(geoIP.getCountryCode(), "RUS");

    }
}
