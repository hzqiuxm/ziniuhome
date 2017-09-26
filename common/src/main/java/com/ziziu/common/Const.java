package com.ziziu.common;

/**
 * Created by yeoman on 2017/7/15.
 */
public interface Const {
    static final class ReturnCode {
        /** 请求成功 */
        public static final int OK = 200;
        /** 参数错误 */
        public static final int F_201 = 201;
        /** 无操作权限 */
        public static final int F_202 = 202;
        /** 不支持该操作 */
        public static final int F_203 = 203;
        /** 无需重复操作 */
        public static final int F_204 = 204;
        /** 数据解析失败 */
        public static final int F_205 = 205;
        /** 超出最大支持的大小 */
        public static final int F_206 = 206;

        /** 未查到数据 */
        public static final int F_301 = 301;
        /** 系统保存失败 */
        public static final int F_303 = 303;
    }
}
