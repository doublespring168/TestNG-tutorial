package top.doublespring.group;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class T002 {

    @Parameters({"id"})
    @Test(groups = {"g002"})
    public void t002001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test(groups = {"g002"})
    public void t002002(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }
}
