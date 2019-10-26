package top.doublespring.annotation;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.*;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class T003 {

    @Parameters({"id"})
    @Test(groups = {"g003"})
    public void t002001(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }

    @Parameters({"id"})
    @Test(groups = {"g003"})
    public void t002002(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id));
    }


    @Parameters({"id"})
    @BeforeClass(groups = {"g003"})
    public JSONObject beforeClass(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format("  id=%s,%s", id, " -->  @BeforeClass"));
        return null;
    }

    @Parameters({"id"})
    @AfterClass(groups = {"g003"})
    public JSONObject afterClass(String id) {
        LogUtil.info(LC.C_100, String.format("  id=%s,%s", id, " -->  @AfterClass"));
        System.out.println();

        return null;
    }

    @Parameters({"id"})
    @BeforeMethod(groups = {"g003"})
    public JSONObject beforeMethod(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeMethod"));
        return null;
    }

    @Parameters({"id"})
    @AfterMethod(groups = {"g003"})
    public JSONObject afterMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterMethod"));
        System.out.println();
        return null;
    }


}
