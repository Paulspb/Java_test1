import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by khomep on 6/1/2016.
 */
public class PointTests {
    @Test
    public void testPoint1() {
        Point p11 = new Point(3.0,4.5);
        Point p21 = new Point(3.1,4.9);

         assertEquals(p11.distance3(p21),0.4123105625617664);
        assertEquals(p11.distance3(p21),50.4);
        assert p11.distance3(p21) == 5.0;


    }



}
