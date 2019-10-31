package top.doublespring.annotation;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.*;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class FunctionalAnnotation {


    @Parameters({"id"})
    @BeforeSuite(description = "开始测试")
    public JSONObject beforeSuite(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeSuite"));
        System.out.println();
        return null;
    }

    @Parameters({"id"})
    @AfterSuite()
    public JSONObject afterSuite(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterSuite"));
        System.out.println();
        return null;
    }

    @Parameters({"id"})
    @BeforeTest()
    public JSONObject beforeTest(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeTest"));
        return null;
    }

    @Parameters({"id"})
    @AfterTest()
    public JSONObject afterTest(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterTest"));
        System.out.println();
        return null;
    }

    @Parameters({"id"})
    @BeforeClass()
    public JSONObject beforeClass(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeClass"));
        return null;
    }

    @Parameters({"id"})
    @AfterClass()
    public JSONObject afterClass(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterClass"));
        return null;
    }

    @Parameters({"id"})
    @BeforeMethod()
    public JSONObject beforeMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeMethod"));
        return null;
    }

    @Parameters({"id"})
    @AfterMethod()
    public JSONObject afterMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterMethod"));
        return null;
    }

    @Parameters({"id"})
    @BeforeGroups()
    public JSONObject beforeGroups3(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeGroups for group g003"));
        return null;
    }

    @Parameters({"id"})
    @AfterGroups()
    public JSONObject afterGroups3(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterGroups for group g003"));
        System.out.println();
        return null;
    }


}
