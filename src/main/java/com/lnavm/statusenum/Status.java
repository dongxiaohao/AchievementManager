package com.lnavm.statusenum;

public enum Status {
    OK, //操作成功状态

    //登陆状态枚举
    EMPTY_USERNAME ,//用户名为空
    EMPTY_PASSWORD,//密码为空

    ERROR_USERNAME, //用户名错误
    ERROR_PASSWORD,//密码错误

    //用户修改状态枚举
    FAIL_MOTIFYSJH,  //手机号修改失败
    ERROR_SJH,//手机号格式错误

    //添加管理员用户
    FAIL_ADDADMIN,//添加失败

    //修改用户登录状态
    FAIL_BAN,  //用户登录状态修改失败
   // FAIL_UNBAN, //允许用户登录失败



    //未知错误
    ERROR;
    public static final String OK_MAG="成功";
    public static final String EMPTY_USERNAME_MAG="用户名为空！";
    public static final String EMPTY_PASSWORD_MAG="密码为空！";
    public static final String ERROR_USERNAME_MAG="不存在用户名！";
    public static final String ERROR_PASSWORD_MAG="密码错误！";
    public static final String ERROR_SJH_MAG="手机号格式错误！";
    public static final String FAIL_MOTIFYSJH_MAG="手机号修改失败，请重新尝试！";

    public static final  String FAIL_ADDADMIN_MAG="添加失败请重新尝试！";
    public static final String FAIL_BAN_MAG="禁止或解禁用户失败，请重新尝试！";
    public static final String ERROR_MAG="未知错误，请重新尝试！";
}
