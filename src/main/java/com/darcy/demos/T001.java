package com.darcy.demos;

import com.darcy.common.log.LC;
import com.darcy.common.log.LogUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T001 {

    @Parameters({"id"})
    @Test
    public void t001001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

}
