package common;

import org.junit.Test;
import org.peng.common.NewObject;

public class NewObjectTest {
    @Test
    public void New() {
        Integer ii = (Integer) NewObject.New("Integer");
        ii = 333;
        double d = ii.doubleValue();
        System.out.println(d);
    }
}
