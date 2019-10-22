package com.darcy.demos.childPackage;

import com.darcy.common.log.LC;
import com.darcy.common.log.LogUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C002 {

    @Parameters({"id"})
    @Test
    public void c002001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test
    public void c002002(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
