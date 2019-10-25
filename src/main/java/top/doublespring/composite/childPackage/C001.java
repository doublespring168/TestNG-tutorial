package top.doublespring.composite.childPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class C001 {

    @Parameters({"id"})
    @Test(groups = {"gc004"})
    public void c001001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
