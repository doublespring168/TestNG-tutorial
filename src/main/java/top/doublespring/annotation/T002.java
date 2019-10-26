package top.doublespring.annotation;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.*;
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


    @Parameters({"id"})
    @BeforeClass()
    public JSONObject beforeClass(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format("  id=%s,%s", id, " -->  @BeforeClass"));
        return null;
    }

    @Parameters({"id"})
    @AfterClass()
    public JSONObject afterClass(String id) {
        LogUtil.info(LC.C_100, String.format("  id=%s,%s", id, " -->  @AfterClass"));
        System.out.println();

        return null;
    }

    @Parameters({"id"})
    @BeforeMethod()
    public JSONObject beforeMethod(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeMethod"));
        return null;
    }

    @Parameters({"id"})
    @AfterMethod()
    public JSONObject afterMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterMethod"));
        System.out.println();
        return null;
    }


}
