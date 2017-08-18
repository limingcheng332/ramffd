通讯框架：Netty
协议为：
    模块(大写)::功能号::json数据$

api列表：
    用户登录----->  请求：USER::00001::{json}$            响应：USER::00001::0000(errcode)::处理成功(errmsg)::{json}$



    开发指南：
        server.properties中的api.basepackage 定义了api需要扫描的包基础包路径
        在配置的包路径下新建一个java类
        类上使用@RamffdAPI("模块名")
        新建一个方法，其入参出参需自己根据接口需要新建，约束：必须继承APIParam类
        在这个方法上添加注解@RamffdFunction("接口功能号")，至此一个接口的基本结构已经完成。

        拦截器：在配置的包路径下新建一个java类,实现APIInterceptor类
        在该类上添加注解@Interceptor("{模块名/接口功能号，模块名/接口功能号}"),由此可见，一个拦截器可以拦截多个接口
        添加以后分别实现前置拦截和后置拦截