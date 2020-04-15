package com.lnavm.statusenum;

public enum Status {
    OK, //操作成功状态

    //登陆状态枚举
    EMPTY_USERNAME ,//用户名为空
    EMPTY_PASSWORD,//密码为空
    BAN_ADMIN,   //禁止登录状态

    ERROR_USERNAME, //用户名错误
    ERROR_PASSWORD,//密码错误

    //用户修改状态枚举
    FAIL_MOTIFYSJH,  //手机号修改失败
    ERROR_SJH,//手机号格式错误

    //添加管理员用户
    FAIL_ADDADMIN,//添加失败
    EMPTY_ADMINID, //管理员id为空
    FAIL_UPDATAADMIN, //管理员修改失败
    FAIL_UPDATAADMINSTU, //管理员状态修改失败，禁止或解禁
    SAME_ADMIN, //禁止登录管理员与当前登录管理员相同
    VALID_ADMIN_SMALL, //合法管理员数量过少

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
    public static final String EMPTY_ADMINID_MAG="请选择一位管理员！！"; //管理员id为空
    public static final String  FAIL_UPDATAADMIN_MAG="管理员信息修改失败，请重新尝试"; //管理员修改失败
    public static final String FAIL_UPDATAADMINSTU_MAG="禁止或解禁管理员失败，请重新尝试";
    public static final String BAN_ADMIN_MAG="该管理员已被禁止登录";
    public static final String SAME_ADMIN_MAG="不可以禁止自己哟！！";
    public static final String VALID_ADMIN_SMALL_MAG="当前仅有一位可登录管理员，不可以禁止了哟！！";

}
