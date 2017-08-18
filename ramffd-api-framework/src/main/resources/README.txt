通讯框架：Netty
协议为：
    模块(大写)::功能号::json数据$

api列表：
    用户登录----->  请求：USER::00001::{json}$            响应：USER::00001::0000(errcode)::处理成功(errmsg)::{json}$