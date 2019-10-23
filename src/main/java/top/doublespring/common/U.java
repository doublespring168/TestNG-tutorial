package top.doublespring.common;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import top.doublespring.common.exception.ServiceException;
import top.doublespring.common.message.MsgType;
import top.doublespring.common.message.ResponseMessage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * CreateTime: 2019-08-01 22:32
 * ClassName: MyExceptionUtil
 * Package: com.ix.common.utils
 * Describe:
 * 异常工具类
 *
 * @author spring
 */
@SuppressWarnings("unused")
public class U {


    public static final Charset UTF8 = StandardCharsets.UTF_8;
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    public static final String EMPTY = "";

    private static final String LIKE = "%";
    /**
     * 只验证位数, 因为手机号码经常会变化
     */
    private static final String PHONE = "^1([0-9]{10})$";
    /**
     * _abc-def@123-hij.uvw_xyz.com 是正确的, -123@xyz.com 不是
     */
    private static final String EMAIL = "^\\w[\\w\\-]*@([\\w\\-]+\\.\\w+)+$";
    /**
     * ico, jpeg, jpg, bmp, png 后缀
     */
    private static final String IMAGE = "(?i)^(.*)\\.(ico|jpeg|jpg|bmp|png)$";
    /**
     * IPv4 地址
     */
    private static final String IPV4 = "^([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])(\\.([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])){3}$";
    /**
     * 身份证号码
     */
    private static final String ID_CARD = "^([0-9]{15}|[0-9]{17}[0-9Xx])$";

    /**
     * 中文
     */
    private static final String CHINESE = "[\\u4e00-\\u9fa5]";

    private static final String LOCAL = "127.0.0.1,localhost,::1";
    private static final String TMP = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 功能说明：懒式Object转JSON字符串
     * Author：Darcy
     * Date：2019-08-26 16:25
     */
    public static Supplier<String> toString(Object object) {
        return () -> {
            if (object == null) {
                return "object为null";
            }
            return JSON.toJSONString(object);
        };
    }

    /**
     * 功能说明：Object转JSON字符串
     * Author：Darcy
     * Date：2019-08-26 16:25
     */
    public static String toJSS(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 功能说明：懒式byte数据转String方法
     * Author：Darcy
     * Date：2019-08-26 16:25
     */
    public static Supplier<String> toString(byte[] bytes) {
        return () -> {
            if (bytes == null) {
                return "bytes为null";
            }
            return new String(bytes, StandardCharsets.UTF_8);
        };
    }

    /**
     * 功能说明：懒式Throwable转JSON字符串
     * Author：Darcy
     * Date：2019-08-26 16:25
     */
    public static Supplier<String> toString(Throwable throwable) {
        return () -> {
            if (throwable == null) {
                return "throwable为null";
            }
            StringWriter sw = new StringWriter();
            throwable.printStackTrace(new PrintWriter(sw, true));
            return sw.toString();
        };
    }

    /**
     * 功能说明：将可变形参拼接为aaa[参数值1],bbb[参数值2],ccc[参数值3]格式字符串
     * Author：Darcy
     * Date：2018/7/16 下午4:22
     */
    public static Supplier<String> format(Object... msgs) {
        return () -> {

            if (msgs == null || msgs.length == 0) {
                return "msgs为null";
            }

            StringBuffer result = new StringBuffer();
            int len = msgs.length - 1, i = 0;
            Object lastObj = null;
            if (len % 2 == 0) {
                //说明当前参数是奇数个
                lastObj = msgs[len];
                len = len - 1;
            }

            for (; i <= len; i++) {
                if (i % 2 == 0) {
                    //说明当前参数是属性
                    result.append(msgs[i]).append("[");
                } else {
                    //说明当前参数是属性值
                    result.append(msgs[i] instanceof Supplier ? ((Supplier) msgs[i]).get() : msgs[i]).append("],");
                }
            }

            if (lastObj != null) {
                result.append(lastObj + ",");
            }

            result.replace(result.length() - 1, result.length(), "");
            String s = result.toString();
            return s;
        };
    }

    /**
     * 生成指定位数的随机数
     */
    public static String random(int length) {
        if (length <= 0) {
            return EMPTY;
        }

        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sbd.append(RANDOM.nextInt(10));
        }
        return sbd.toString();
    }

    public static String randomLetterAndNumber(int length) {
        if (length <= 0) {
            return EMPTY;
        }

        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sbd.append(TMP.charAt(RANDOM.nextInt(TMP.length())));
        }
        return sbd.toString();
    }


    /**
     * 传入的数不为 null 且 大于 0 就返回 true
     */
    public static boolean greater0(Number obj) {
        return obj != null && obj.doubleValue() > 0;
    }

    /**
     * 传入的数为 null 或 小于等于 0 就返回 true
     */
    public static boolean less0(Number obj) {
        return obj == null || obj.doubleValue() <= 0;
    }

    /**
     * 数值在指定的数区间时(包含边界)返回 true
     */
    public static boolean betweenBorder(Number num, Number min, Number max) {
        return num.doubleValue() >= min.doubleValue() && num.doubleValue() <= max.doubleValue();
    }

    /**
     * 将字符串中指定位数的值模糊成 * 并返回. 索引位从 0 开始
     */
    public static String foggy(String param, int start, int end) {
        if (isBlank(param)) {
            return EMPTY;
        }
        if (start < 0 || end < start || end > param.length()) {
            return param;
        }

        return param.substring(0, start) + param.substring(start, end).replaceAll("[0-9]", "*") + param.substring(end);
    }

    /**
     * 对象为 null, 或者其字符串形态为 空白符, "null" 时返回 true
     */
    public static boolean isBlank(Object obj) {
        return obj == null || StringUtils.isBlank(obj.toString()) || "null".equalsIgnoreCase(obj.toString().trim());
    }

    public static String like(String param) {
        return isBlank(param) ? U.EMPTY : LIKE + param + LIKE;
    }

    public static String leftLike(String param) {
        return isBlank(param) ? U.EMPTY : LIKE + param;
    }

    public static String rightLike(String param) {
        return isBlank(param) ? U.EMPTY : param + LIKE;
    }

    /**
     * 后缀是图片则返回 true
     */
    public static boolean checkImage(String image) {
        return checkRegexWithStrict(image, IMAGE);
    }

    /**
     * 验证 指定正则 是否 <span style="color:red;">全字匹配</span> 指定字符串, 匹配则返回 true <br/><br/>
     * <p>
     * 左右空白符 : (?m)(^\s*|\s*$)<br>
     * 空白符 : (^\\s*)|(\\s*$)<br/>
     * 匹配多行注释 : /\*\*(\s|.)*?\* /<br/>
     */
    public static boolean checkRegexWithStrict(String param, String regex) {
        return isNotBlank(param) && Pattern.compile(regex).matcher(param).matches();
    }

    /**
     * 对象非空时返回 true
     */
    public static boolean isNotBlank(Object obj) {
        return !isBlank(obj);
    }

    /**
     * 是正确的邮箱地址则返回 true
     */
    public static boolean checkEmail(String email) {
        return checkRegexWithStrict(email, EMAIL);
    }

    /**
     * 是一个手机则返回 true
     */
    public static boolean checkPhone(String phone) {
        return checkRegexWithStrict(phone, PHONE);
    }

    /**
     * 是一个有效的 ipv4 地址则返回 true
     */
    public static boolean isLicitIp(String ip) {
        return checkRegexWithStrict(ip, IPV4);
    }

    /**
     * 是一个有效的身份证号就返回 true
     */
    public static boolean isIdCard(String num) {
        return checkRegexWithStrict(num, ID_CARD);
    }

    /**
     * 是本地请求则返回 true
     */
    public static boolean isLocalRequest(String ip) {
        return LOCAL.contains(ip);
    }

    /**
     * 传入的参数只要包含中文就返回 true
     */
    public static boolean checkChinese(String param) {
        return checkRegexWithRelax(param, CHINESE);
    }

    /**
     * 只要找到匹配即返回 true
     */
    public static boolean checkRegexWithRelax(String param, String regex) {
        return isNotBlank(param) && Pattern.compile(regex).matcher(param).find();
    }

    /**
     * 字符转义. 主要针对 url 传递给后台前的操作. 如 ? 转换为 %3F, = 转换为 %3D, & 转换为 %26 等
     */
    public static String urlEncode(String url) {
        if (isBlank(url)) {
            return EMPTY;
        }
        try {
            // java 中的 encode 是把空格变成 +, 转义后需要将 + 替换成 %20
            return URLEncoder.encode(url, UTF8.displayName());//.replaceAll("\\+", "%20"));
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }

    /**
     * 字符反转义, 主要针对 url 传递到后台后的操作
     */
    public static String urlDecode(String src) {
        if (isBlank(src)) {
            return EMPTY;
        }
        try {
            // java 中的 encode 是把空格变成 +, 反转义前需要将 %20 替换成 +
            return URLDecoder.decode(src/*.replaceAll("%20", "\\+")*/, UTF8.displayName());
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }

    /**
     * 属性转换成方法, 加上 get 并首字母大写
     */
    public static String fieldToMethod(String field) {
        if (isBlank(field)) {
            return EMPTY;
        }

        field = field.trim();
        return "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    /**
     * 调用对象的公有方法. 将会忽略异常只返回 null, 如果要对异常专门记录勿调用此方法
     */
    public static Object getMethod(Object obj, String method, Object... param) {
        if (isNotBlank(method)) {
            try {
                return obj.getClass().getDeclaredMethod(method).invoke(obj, param);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                // ignore
            }
            // getMethod 会将从父类继承过来的 public 方法也查询出来
            try {
                return obj.getClass().getMethod(method).invoke(obj, param);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e1) {
                // ignore
            }
        }
        return null;
    }


    public static void check(boolean b, String msg) {
        if (b) {
            throw new ServiceException(msg);
        }
    }

    public static void checkEmpty(Object obj, String msg) {
        checkEmpty(obj, msg, msg);
    }


    public static void checkEmpty(Object obj, String msg, String log) {
        if (isBlank(obj)) {
            throw new ServiceException(msg);
        }
    }

    public static void checkCollectionEmpty(Collection obj, String msg) {
        if (obj == null || obj.size() == 0) {
            throw new ServiceException(msg);
        }
    }

    /**
     * 功能说明：返回警告空消息
     * Author：zts
     * Date：2018/4/27 18:30
     */
    public static ResponseMessage returnWarnResponseMessage() {
        return new ResponseMessage<Object>(MsgType.Warn);
    }

    /**
     * 功能说明：返回警告空消息
     * Author：zts
     * Date：2018/4/27 18:30
     */
    public static ResponseMessage returnWarnResponseMessage(Object data) {
        return new ResponseMessage<Object>(MsgType.Warn, data);
    }

    /**
     * 功能说明：返回成功消息
     * Author：zts
     * Date：2018/4/27 18:30
     */
    public static ResponseMessage returnSuccessResponseMessage(Object data) {
        return new ResponseMessage<Object>(data);
    }

    /**
     * 功能说明：返回失败消息
     * Author：zts
     * Date：2018/4/27 18:30
     */
    public static ResponseMessage returnFailedResponseMessage(Object data) {
        return new ResponseMessage<Object>(MsgType.Fail, data);
    }


    /**
     * 功能说明：返回成功空消息
     * Author：zts
     * Date：2018/4/27 18:30
     */
    public static ResponseMessage returnSuccessResponseMessage() {
        return new ResponseMessage<Object>();
    }

    /**
     * 功能说明：返回失败空消息
     * Author：zts
     * Date：2018/4/27 18:30
     */
    public static ResponseMessage returnFailedResponseMessage() {
        return new ResponseMessage<Object>(MsgType.Fail);
    }

    public static void checkMapEmpty(Map obj, String msg) {
        if (obj == null || obj.size() == 0) {
            throw new ServiceException(msg);
        }
    }

    public static void throwServiceExce(String msg) {
        throwServiceExce(msg, msg);
    }

    public static void throwServiceExce(String msg, String log) {
        throwServiceExce(msg, MsgType.Fail.getCode(), log);
    }

    public static void throwServiceExce(String msg, String code, String log) {
        throw new ServiceException(code, msg);
    }

    public static void throwServiceExce(MsgType msgType, String log) {
        throwServiceExce(msgType.getMsg(), msgType.getCode(), log);
    }


}
