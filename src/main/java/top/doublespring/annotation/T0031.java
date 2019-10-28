package top.doublespring.annotation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class T0031 {

    @Parameters({"id"})
    @Test(groups = {"g003"})
    public void t0031001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test(groups = {"g003"})
    public void t0031002(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
