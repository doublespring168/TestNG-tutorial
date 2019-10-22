package com.darcy.annotation;

import com.alibaba.fastjson.JSONObject;
import com.darcy.common.log.LC;
import com.darcy.common.log.LogUtil;
import org.testng.annotations.*;

public class FunctionalAnnotation {


    @Parameters({"id"})
    @BeforeSuite(description = "开始测试")
    public JSONObject beforeSuite(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @BeforeSuite"));
        return null;
    }

    @Parameters({"id"})
    @AfterSuite()
    public JSONObject afterSuite(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @AfterSuite"));
        return null;
    }

    @Parameters({"id"})
    @BeforeTest()
    public JSONObject beforeTest(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @BeforeTest"));
        return null;
    }

    @Parameters({"id"})
    @AfterTest()
    public JSONObject afterTest(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @AfterTest"));
        return null;
    }

    @Parameters({"id"})
    @BeforeClass()
    public JSONObject beforeClass(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @BeforeClass"));
        return null;
    }

    @Parameters({"id"})
    @AfterClass()
    public JSONObject afterClass(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @AfterClass"));
        return null;
    }

    @Parameters({"id"})
    @BeforeMethod()
    public JSONObject beforeMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @BeforeMethod"));
        return null;
    }

    @Parameters({"id"})
    @AfterMethod()
    public JSONObject afterMethod(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @AfterMethod"));
        return null;
    }

    @Parameters({"id"})
    @BeforeGroups()
    public JSONObject beforeGroups(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @BeforeGroups"));
        return null;
    }

    @Parameters({"id"})
    @AfterGroups()
    public JSONObject afterGroups(String id) {
        LogUtil.info(LC.C_100, String.format(" id=%s", id, " -->  @AfterGroups"));
        return null;
    }


}
