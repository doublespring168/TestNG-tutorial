package top.doublespring.common.log;

public enum LC {

    /**
     * 功能枚举类
     * 号段使用者分类
     * 100 - 1000 : 非业务类型日志
     * 1000 - 1999 ：
     * 2000 - 2999 ：
     * 3000 - 3999 ：
     */
    C_000("000", ""),
    C_110("110", "异常错误"),
    C_100("100", "测试消息"),


    ;

    /**
     * 功能编码
     */
    private String code;


    /**
     * 功能名称
     */
    private String name;

    LC(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public LC setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public LC setName(String name) {
        this.name = name;
        return this;
    }
}
