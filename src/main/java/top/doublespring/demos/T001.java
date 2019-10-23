package top.doublespring.demos;

import org.testng.annotations.Parameters;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class T001 {

    @Parameters({"id"})
    public void t001001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
