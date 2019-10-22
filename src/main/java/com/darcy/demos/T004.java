package com.darcy.demos;

import com.darcy.common.log.LC;
import com.darcy.common.log.LogUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T004 {

    @Parameters({"id"})
    @Test
    public void t004001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test
    public void t004002(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test
    public void t004003(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test
    public void t004004(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
