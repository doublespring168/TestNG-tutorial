package top.doublespring.composite;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class T0041 {

    @Parameters({"id"})
    @Test(priority = 1)
    public void t0041004(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test(priority = 2)
    public void t0041003(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }


    @Parameters({"id"})
    @Test(priority = 3)
    public void t0041002(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test(priority = 4)
    public void t0041001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }


}
