package top.doublespring.group;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class T001 {

    @Parameters({"id"})
    @Test(groups = {"g001"})
    public void t001001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
