package com.darcy.demos;

import com.darcy.common.log.LC;
import com.darcy.common.log.LogUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T003 {

    @Parameters({"id"})
    @Test
    public void t003001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test
    public void t003002(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test
    public void t003003(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
