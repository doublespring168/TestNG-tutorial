package top.doublespring.annotation;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.*;
import top.doublespring.common.log.LC;
import top.doublespring.common.log.LogUtil;

public class FunctionalAnnotation3 {


    @Parameters({"id"})
    @BeforeSuite(groups = "g003")
    public JSONObject beforeSuite(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeSuite"));
        System.out.println();
        return null;
    }

    @Parameters({"id"})
    @AfterSuite(groups = "g003")
    public JSONObject afterSuite(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterSuite"));
        System.out.println();
        return null;
    }

    @Parameters({"id"})
    @BeforeTest(groups = "g003")
    public JSONObject beforeTest(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeTest"));
        return null;
    }

    @Parameters({"id"})
    @AfterTest(groups = "g003")
    public JSONObject afterTest(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterTest"));
        System.out.println();
        return null;
    }

    @Parameters({"id"})
    @BeforeClass(groups = "g003")
    public JSONObject beforeClass(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeClass"));
        return null;
    }

    @Parameters({"id"})
    @AfterClass(groups = "g003")
    public JSONObject afterClass(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterClass"));
        return null;
    }

    @Parameters({"id"})
    @BeforeMethod(groups = "g003")
    public JSONObject beforeMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeMethod"));
        return null;
    }

    @Parameters({"id"})
    @AfterMethod(groups = "g003")
    public JSONObject afterMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterMethod"));
        return null;
    }

    @Parameters({"id"})
    @BeforeGroups("g003")
    public JSONObject beforeGroups3(String id) {
        System.out.println();
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @BeforeGroups for group g003"));
        return null;
    }

    @Parameters({"id"})
    @AfterGroups("g003")
    public JSONObject afterGroups3(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s,%s", id, " -->  @AfterGroups for group g003"));
        System.out.println();
        return null;
    }


}
